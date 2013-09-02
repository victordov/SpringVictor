package md.victordov.dao.inf;

import md.victordov.db.securityBeans.UserDb;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/28/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDbDao {
    // C R U D
    List<UserDb> findAll();

    UserDb findById(String username);

    void save(UserDb userDb);

    void delete(UserDb userDb);

    void update(UserDb userDb);

}
