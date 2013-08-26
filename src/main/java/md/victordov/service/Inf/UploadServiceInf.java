package md.victordov.service.Inf;

import md.victordov.formObjects.UploadItem;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/23/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UploadServiceInf {

    void uploadTheFile(UploadItem uploadItem) throws IOException;
}
