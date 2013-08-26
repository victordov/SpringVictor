package md.victordov.form.validator;

import md.victordov.formObjects.UploadItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/23/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class UploadItemForm {


    List<UploadItem> uploadItemList = new ArrayList<UploadItem>();

    //Default constructor
    public UploadItemForm() {
        uploadItemList.add(new UploadItem());
    }

    public List<UploadItem> getUploadItemList() {
        return uploadItemList;
    }

    public void setUploadItemList(List<UploadItem> uploadItemList) {
        this.uploadItemList = uploadItemList;
    }


}
