package md.victordov.form.validator;

import md.victordov.formObjects.UploadItem;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FileUploadValidator implements Validator {

    public boolean supports(Class<?> arg0) {
        return UploadItemForm.class.isAssignableFrom(arg0);
    }

    public void validate(Object arg0, Errors arg1) {
        UploadItemForm bean = (UploadItemForm) arg0;
        if (bean.getUploadItemList() == null && bean.getUploadItemList().size() == 0) {
            arg1.rejectValue("file", "error.file.empty");
        } else if (bean.getUploadItemList().size() == 1) {
            MultipartFile file = (MultipartFile) bean.getUploadItemList().get(0);
            if (file.getOriginalFilename() == null || file.getOriginalFilename().equals(""))
                arg1.rejectValue("file", "error.file.empty");
            else if (file.getSize() > 100000000)
                arg1.rejectValue("file", "error.file.size.max.limit.error", new String[]{file.getOriginalFilename()}, "File size limit exceeded");
        } else {
            List<UploadItem> files = bean.getUploadItemList();
            boolean isValid = true;
            StringBuilder sb = new StringBuilder("");
            for (UploadItem file : files) {
                if (file.getFileData().getSize() > 1000000) {
                    isValid = false;
                    sb.append(file.getFileData().getOriginalFilename() + " ");
                }
            }
            if (!isValid)
                arg1.rejectValue("file", "error.file.size.max.limit.error", new String[]{sb.toString()}, "File size limit exceeded");

        }

    }

}