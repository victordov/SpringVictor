package md.victordov.service;

import md.victordov.dao.inf.UserDbDao;
import md.victordov.db.securityBeans.UserDb;
import md.victordov.service.inf.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/28/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(readOnly = true)
public class UserDbServiceImpl implements UserDbService {

    @Autowired
    private UserDbDao userDbDao;

    @Override
    public List<UserDb> findAll() {
        return userDbDao.findAll();
    }

    @Override
    public UserDb findById(String username) {
        return userDbDao.findById(username);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(UserDb userDb) {
        userDbDao.save(userDb);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(UserDb userDb) {
        userDbDao.delete(userDb);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(UserDb userDb) {
        userDbDao.update(userDb);
    }
}
