package md.victordov.dao;

import md.victordov.dao.inf.AuthorityDao;
import md.victordov.db.securityBeans.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 9/2/13
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AuthorityDaoImpl implements AuthorityDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<Authority> findAll(){
        return getCurrentSession().createCriteria(Authority.class)
                .list();
    }
}
