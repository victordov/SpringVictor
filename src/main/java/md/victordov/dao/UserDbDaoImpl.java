package md.victordov.dao;

import md.victordov.dao.Inf.UserDbDao;
import md.victordov.db.securityBeans.UserDb;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/28/13
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDbDaoImpl implements UserDbDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<UserDb> findAll() {
        return getCurrentSession().createQuery("from UserDb ").list();
    }

    @Override
    public UserDb findById(String username) {
        return (UserDb) getCurrentSession().get(UserDb.class, username);
    }

    @Override
    public void save(UserDb userDb) {
        getCurrentSession().save(userDb);
    }

    @Override
    public void delete(UserDb userDb) {
        getCurrentSession().delete(userDb);
    }

    @Override
    public void update(UserDb userDb) {
        getCurrentSession().update(userDb);
    }
}
