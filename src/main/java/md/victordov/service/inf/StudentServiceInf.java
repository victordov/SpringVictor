package md.victordov.service.inf;

import md.victordov.db.beans.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/12/13
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StudentServiceInf {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void delete(Integer id);
    void update(Student student);
    List<Student> findForCourse(String studName, String courseName);
}
