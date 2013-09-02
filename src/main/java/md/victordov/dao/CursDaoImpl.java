package md.victordov.dao;

import md.victordov.dao.inf.CursDaoInf;
import md.victordov.db.beans.Curs;
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
 * Date: 8/13/13
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CursDaoImpl implements CursDaoInf {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<Curs> findAll() {
        return getCurrentSession().createCriteria(Curs.class, "c").setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .setFetchMode("students", FetchMode.JOIN)
                .list();

    }

    @Override
    public Curs findById(Integer id) {
        return (Curs) getCurrentSession().get(Curs.class, id);
    }

    @Override
    public void save(Curs curs) {
        getCurrentSession().save(curs);
    }

    @Override
    public void delete(Curs curs) {
        getCurrentSession().delete(curs);
    }

    @Override
    public void update(Curs curs) {
        getCurrentSession().delete(curs);
    }
}
