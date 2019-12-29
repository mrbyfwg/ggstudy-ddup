package com.action;

import com.bean.DdupPptmanageEntity;
import com.service.pptManageService;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Dwt0610
 * @Date 2019/12/14
 */
public class pptManageAction extends baseActionConfig7 {
    private DdupPptmanageEntity pptManage;
    private pptManageService pptManageService;
    private String id;
    private String name;
    private int pageNum;
    private int DownloadNum;

    public DdupPptmanageEntity getPptmanageEntity() {
        return pptManage;
    }

    public void setPptmanageEntity(DdupPptmanageEntity pptmanageEntity) {
        this.pptManage = pptmanageEntity;
    }

    public com.service.pptManageService getPptManageService() {
        return pptManageService;
    }

    public void setPptManageService(com.service.pptManageService pptManageService) {
        this.pptManageService = pptManageService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getDownloadNum() {
        return DownloadNum;
    }

    public void setDownloadNum(int downloadNum) {
        DownloadNum = downloadNum;
    }

    public String findAllPpt(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List alllist = pptManageService.findAll();
            List<String> idlist = new ArrayList<>();
            List<String> namelist = new ArrayList<>();
            if (alllist.size() != 0) {
                for(int i=0; i<alllist.size(); i++){
                    pptManage = (DdupPptmanageEntity)alllist.get(i);
                    String PPTNAME = pptManage.getDdupName();
                    String[] strarray=PPTNAME.split("\\+");
                    if(strarray[1].equals(id)){
                        idlist.add(pptManage.getDdupPptNo());
                        namelist.add(strarray[0]);
                    }
                }
                map.put("idlist", idlist);
                map.put("namelist", namelist);
                status = "1";
            } else {
                status = "0";
            }
            map.put("status", status);
            return ajax(map);
        } catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }





    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = pptManageService.findAll();
            if (list.size() != 0) {
                map.put("pptManageList", list);
                status = "1";
            } else {
                status = "0";
            }
            map.put("status", status);
            return ajax(map);
        } catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }
    public String findById(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{
            List list=pptManageService.findById(id);
            if(list.size()!=0){
                pptManage=(DdupPptmanageEntity) list.get(0);
                map.put("pptManage",pptManage);
                status="1";
            }
            else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }

    }
    public String add(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            pptManage=new DdupPptmanageEntity();
            pptManage.setDdupPptNo(id);
            pptManage.setDdupName(name);
            pptManage.setDdupPptPageNum(pageNum);
            pptManage.setDdupPptDownloadNum(DownloadNum);
            if(pptManageService.add(pptManage)){
                status="1";
            }else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }
    public String update(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            pptManage=new DdupPptmanageEntity();
            pptManage.setDdupPptNo(id);
            pptManage.setDdupName(name);
            pptManage.setDdupPptPageNum(pageNum);
            pptManage.setDdupPptDownloadNum(DownloadNum);
            if(pptManageService.updateInfo(pptManage)){
                status="1";
            }else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }
    public String deleteById(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{

            if(pptManageService.deleteById(id)){
                status="1";
            }else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }

    }

}
