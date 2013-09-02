package md.victordov.service;

import md.victordov.dao.inf.AuthorityDao;
import md.victordov.db.securityBeans.Authority;
import md.victordov.service.inf.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 9/2/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(readOnly = true)
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    AuthorityDao authorityDao;

    public List<Authority> findAll(){
        return  authorityDao.findAll();
    }
}
