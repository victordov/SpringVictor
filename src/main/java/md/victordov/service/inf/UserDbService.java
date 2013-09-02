package md.victordov.service.inf;

import md.victordov.db.securityBeans.UserDb;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/28/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDbService {
    List<UserDb> findAll();

    UserDb findById(String username);

    void save(UserDb userDb);

    void delete(UserDb userDb);

    void update(UserDb userDb);
}
