package md.victordov.formObjects;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/23/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class UploadItem {

    public UploadItem() {
    }

    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @NotNull
    private CommonsMultipartFile fileData;
    private String fileName;
}
