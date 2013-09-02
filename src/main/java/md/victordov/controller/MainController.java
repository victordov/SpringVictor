package md.victordov.controller;

import md.victordov.formObjects.JavaBean;
import md.victordov.formObjects.JaxbList;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/26/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {
    UserDetails userDetails = null;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/xml", method = RequestMethod.GET)
    public
    @ResponseBody
    JaxbList writeXml() {
        List<JavaBean> javaBeanList = new ArrayList<JavaBean>(4);
        javaBeanList.add(new JavaBean("bar", "apple"));
        javaBeanList.add(new JavaBean("bar1", "apple1"));
        javaBeanList.add(new JavaBean("bar2", "apple2"));
        javaBeanList.add(new JavaBean("bar3", "apple3"));
        return new JaxbList(javaBeanList);
    }

//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logout() {
//        return "logout";
//    }


}
