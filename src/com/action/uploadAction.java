package com.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class uploadAction extends baseAction{
    private File[] uploadFiles;
    private String[] uploadFileContentType;
    private String[] uploadFileName;

    public File[] getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(File[] uploadFiles) {
        this.uploadFiles = uploadFiles;
    }

    public String[] getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String[] uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public String[] getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
    public String upload(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            String realpath = ServletActionContext.getServletContext().getRealPath("/pdf");
            File file = new File(realpath);
            if(!file.exists()){
                file.mkdirs();
            }
            for(int i=0;i<uploadFiles.length;i++){
                File uploadFile=uploadFiles[i];
                FileUtils.copyFile(uploadFile,new File(file,uploadFileName[i]));
            }
            status="1";
            map.put("status", status);
            return ajax(map);
        }catch (Exception e){
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }

    }
}
