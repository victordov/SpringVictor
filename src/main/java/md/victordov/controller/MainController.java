package md.victordov.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/26/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("")
public class MainController {
    UserDetails userDetails = null;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied() {
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "logout";
    }


}
