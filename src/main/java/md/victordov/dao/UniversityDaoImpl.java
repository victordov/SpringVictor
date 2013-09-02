package md.victordov.dao;

import md.victordov.dao.inf.UniversityDaoInf;
import md.victordov.db.beans.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/13/13
 * Time: 9:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UniversityDaoImpl implements UniversityDaoInf {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public List<University> findAll() {
//        return getCurrentSession().createCriteria(University.class,"u")
//                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
//                .setFetchMode("students", FetchMode.JOIN)
//                .list();
        //return getCurrentSession().getNamedQuery("withAssocEntities").list();
        return getCurrentSession().createCriteria(University.class, "u").list();
    }

    @Override
    public University findById(Integer id) {
        return (University) getCurrentSession().get(University.class, id);
    }

    @Override
    public void save(University university) {
        getCurrentSession().save(university);
    }

    @Override
    public void delete(University university) {
        getCurrentSession().delete(university);
    }

    @Override
    public void update(University university) {
        getCurrentSession().update(university);
    }
}
