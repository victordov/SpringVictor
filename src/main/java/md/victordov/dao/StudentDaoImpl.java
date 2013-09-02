package md.victordov.dao;

import md.victordov.dao.inf.StudentDaoInf;
import md.victordov.db.beans.Student;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/12/13
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class StudentDaoImpl implements StudentDaoInf {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Student> findAll() {
//        return getCurrentSession().createQuery("FROM Student").list();
        return getCurrentSession().createCriteria(Student.class, "s").setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .setFetchMode("curses", FetchMode.JOIN)
                .setFetchMode("university", FetchMode.JOIN)
                .list();
    }

    //Find by Id without other entities
    @Override
    public Student findById(Integer id) {
        return (Student) getCurrentSession().get(Student.class, id);
    }

    @Override
    public void save(Student student) {
        getCurrentSession().save(student);
    }

    @Override
    public void delete(Integer id) {
        getCurrentSession().createSQLQuery("delete from student where id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void update(Student student) {
        getCurrentSession().update(student);
    }

    @Override
    public List<Student> findForCourse(String studName, String courseName) {
       return getCurrentSession()
                .getNamedQuery("studentForCourse")
                .setParameter("studName", studName)
                .setParameter("courseName", courseName)
                .list();
    }
}
