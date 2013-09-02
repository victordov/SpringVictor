package md.victordov.controller;

import md.victordov.form.validator.UploadItemForm;
import md.victordov.formObjects.UploadItem;
import md.victordov.service.inf.UploadServiceInf;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/23/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/uploads")
public class UploadController {

    private static Logger logger = Logger.getLogger(UploadController.class);

    public UploadServiceInf getUploadServiceInf() {
        return uploadServiceInf;
    }

    @Autowired
    private UploadServiceInf uploadServiceInf;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listUploadPage(ModelMap map) throws InterruptedException {
        UploadItemForm uploadItemForm = new UploadItemForm();
        map.addAttribute("uploadItems", new UploadItemForm());
        return "uploads";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String uploadMethod(@Valid UploadItemForm uploadItemForm, BindingResult result, ModelMap map) throws InterruptedException {
        if (!result.hasErrors()) {
            for (UploadItem uploadItem : uploadItemForm.getUploadItemList()) {
                try {
                    uploadServiceInf.uploadTheFile(uploadItem);
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
        return "redirect:/uploads.html";
    }


}
