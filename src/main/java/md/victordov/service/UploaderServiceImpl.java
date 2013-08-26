package md.victordov.service;

import md.victordov.formObjects.UploadItem;
import md.victordov.service.Inf.UploadServiceInf;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/23/13
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UploaderServiceImpl implements UploadServiceInf {


    private static Logger logger = Logger.getLogger(UploaderServiceImpl.class);
    @Value("#{projectprop['uploads.folder']}")
    private String uploadFolder;
    @Value("#{projectprop['uploads.folder.tmp']}")
    private String uploadTmpFolder;

    @Override
    public void uploadTheFile(UploadItem uploadItem) {


        try {
            CommonsMultipartFile file = uploadItem.getFileData();
            if ((file != null) && (file.getSize() > 0)) {
                logger.info("Size of the uploaded file is: " + file.getSize());
                StringBuilder strBuilderSorurce = new StringBuilder();
                StringBuilder strBuilderDest = new StringBuilder();
                String filePath = uploadTmpFolder + strBuilderSorurce.append(new Date().getTime()).append("_").append(uploadItem.getFileName()).append(file.getOriginalFilename()).toString();
                String convertedFilePath = uploadFolder + strBuilderDest.append(new Date().getTime()).append("_").append(uploadItem.getFileName()).toString();
                Integer indexFound = file.getOriginalFilename().lastIndexOf(".");

                if (indexFound != -1) {
                    String extension = file.getOriginalFilename().substring(indexFound + 1);
                    logger.info("Extension: " + extension);
                    File dest = new File(filePath);
                    uploadItem.getFileData().transferTo(dest);
                }
            }

        } catch (IllegalStateException e) {
            logger.error(e);
            logger.error("File uploaded failed:" + uploadItem.getFileName());
        } catch (IOException e) {
            logger.error(e);
            logger.error("File uploaded failed:" + uploadItem.getFileName());
        }
    }


}
