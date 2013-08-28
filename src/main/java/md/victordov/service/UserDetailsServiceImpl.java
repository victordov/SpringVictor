package md.victordov.service;

import md.victordov.db.securityBeans.UserDb;
import md.victordov.service.Inf.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/28/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDbService userDbService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDb userDb = userDbService.findById(s);
        User user = new User(userDb.getUsername(), userDb.getPassword(), userDb.isAccountEnabled(), userDb.isAccountNonExpired(), userDb.isCredentialsNonExpired(), userDb.isAccountNonLocked(), userDb.getAuthoritySet());
        return user;
    }
}
