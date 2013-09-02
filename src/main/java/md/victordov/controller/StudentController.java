package md.victordov.controller;

import md.victordov.db.beans.Student;
import md.victordov.service.inf.StudentServiceInf;
import org.apache.log4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/12/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentServiceInf studentServiceInf;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllStudents(ModelMap model) {
        List<Student> students = studentServiceInf.findAll();
        model.addAttribute("students", students);
        boolean oneObj = false;
        model.addAttribute("oneObj", oneObj);
        if (students == null) {
            model.addAttribute("notFound", true);
        }

        return "student";
    }

    //Return JSON & XML
    @RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
    public
    @ModelAttribute
    Student getAllStudentsa(@PathVariable("id") Integer id, ModelMap model) {
        Student student = studentServiceInf.findById(id);
        return student;
    }

    //Returns one student html || json || xml
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOneStudent(@PathVariable Integer id, ModelMap model) {

        List<Student> students = new ArrayList<Student>();
        students.add(studentServiceInf.findById(id));
        model.addAttribute("students", students);
        boolean oneObj = false;
        model.addAttribute("oneObj", oneObj);
        if (students == null) {
            model.addAttribute("notFound", true);
        }
        return "student";
    }

    //deletes & redirects
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteStudent(@PathVariable Integer id, ModelMap model) {
        studentServiceInf.delete(id);
        return "redirect:/student.html";
    }

    //displays the student for editing
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String editStudent(@PathVariable(value = "id") Integer id, ModelMap model) {
        Student student = studentServiceInf.findById(id);
        if (student != null) {
            model.addAttribute("student", student);
        } else {
            model.addAttribute("notFound", true);
        }
        return "editStudent";
    }

    //updates student
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String updateStudent(@Valid @ModelAttribute("student") md.victordov.formObjects.Student student,
                                BindingResult bindingResult,
                                ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "editStudent";
        }

        Student dbStudent = studentServiceInf.findById(student.getId());
        dbStudent.setName(student.getName());
        dbStudent.setLname(student.getLname());

        if (dbStudent != null) {
            studentServiceInf.update(dbStudent);
        }
        return "redirect:/student.html";
    }

    //returns an empty page for search
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchStudentCursEmpty(ModelMap model) {
        model.addAttribute("emptyPage", true);

        return "srchStudent";
    }

    //searches for students who attended for "x" course taking 2 params and the search is relative to names
    // you don't have to provide full name of course or student
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchStudentCurs(@RequestParam("studentName") String studentName,
                                    @RequestParam("courseName") String courseName,
                                    ModelMap model) {
        List<Student> studentList = new ArrayList<Student>();
        if (courseName != "") {
            studentList = studentServiceInf.findForCourse(studentName, courseName);
            model.addAttribute("courseName", courseName);
        }

        model.addAttribute("studentList", studentList);
        model.addAttribute("emptyPage", false);

        return "srchStudent";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newStudent(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "insertStudent";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String insertStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult,
                                ModelMap model) {
        if (bindingResult.hasErrors()) {
            logger.info("has errors");
            return "insertStudent";
        }
        studentServiceInf.save(student);
        return "redirect:/student.html";
    }

    //@ExceptionHandler(MissingServletRequestParameterException.class)
    @ExceptionHandler(TypeMismatchException.class)
    public String handleMyException(Exception exception) {
        return "error";
    }
}
