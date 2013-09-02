package md.victordov.controller;

import md.victordov.db.securityBeans.Authority;
import md.victordov.db.securityBeans.UserDb;
import md.victordov.service.inf.AuthorityService;
import md.victordov.service.inf.UserDbService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 9/2/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UsersController {
    private static Logger logger = Logger.getLogger(UsersController.class);

    @Autowired
    UserDbService userDbService;

    @Autowired
    AuthorityService authorityService;

    @RequestMapping(value = "/usrs/{username}")
    public String getUser(@PathVariable(value = "username") String username, ModelMap map){

        UserDb userDb = userDbService.findById(username);
        map.addAttribute("registeredUser", userDb);
        map.addAttribute("authority", new Authority());
        map.addAttribute("authorities", authorityService.findAll());

        return "userDisplay";
    }

    @RequestMapping(value="/usrs/{username}", method = RequestMethod.POST)
    public String addAuthority(@RequestParam Integer idAuthority, @PathVariable("username") String username){
        UserDb userDb = userDbService.findById(username);
        List<Authority> list = authorityService.findAll();
        Authority authority = null;
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getId()==idAuthority){
                authority = list.get(i);
                System.out.println("auth: " + authority.getRoleName());
            }
        }




        userDb.getAuthoritySet().clear();
        userDb.getAuthoritySet().add(authority);

        userDbService.update(userDb);

        return "userDisplay";
    }


}
