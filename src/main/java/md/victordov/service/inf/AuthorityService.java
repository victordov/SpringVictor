package md.victordov.service.inf;

import md.victordov.db.securityBeans.Authority;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 9/2/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorityService {

    List<Authority> findAll();
}
