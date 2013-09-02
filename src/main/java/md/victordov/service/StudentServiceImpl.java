package md.victordov.service;

import md.victordov.dao.inf.StudentDaoInf;
import md.victordov.db.beans.Student;
import md.victordov.service.inf.StudentServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/12/13
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentServiceInf {

    @Autowired
    private StudentDaoInf studentDaoInf;

    @Override
    public List<Student> findAll() {
        return studentDaoInf.findAll();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Student findById(Integer id) {
        return studentDaoInf.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(Student student) {
        studentDaoInf.save(student);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        studentDaoInf.delete(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Student student) {
        studentDaoInf.update(student);
    }

    @Override
    public List<Student> findForCourse(String nameStudent, String courseName) {
        return studentDaoInf.findForCourse(nameStudent, courseName);
    }
}
