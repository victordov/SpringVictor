package md.victordov.dao.inf;

import md.victordov.db.securityBeans.Authority;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 9/2/13
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorityDao {

    List<Authority> findAll();
}
