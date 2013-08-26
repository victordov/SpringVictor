package md.victordov.controller;

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
@RequestMapping("/index")
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexPage() {

        return "index";
    }
}
