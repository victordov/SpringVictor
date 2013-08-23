package md.victordov.controller;

import md.victordov.db.beans.University;
import md.victordov.service.Inf.UniversityServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/13/13
 * Time: 10:07 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityServiceInf universityServiceInf;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllUniversities(ModelMap model) {
        List<University> universities = universityServiceInf.findAll();
        model.addAttribute("universities", universities);
        if (universities == null) {
            model.addAttribute("notFound", true);
        }
        return "university";
    }
}
