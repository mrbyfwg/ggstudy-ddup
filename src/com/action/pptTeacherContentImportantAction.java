package com.action;

import com.bean.DdupPptcontentEntity;
import com.service.pptContentService;
import com.bean.DdupPptteachercontentimportantEntity;
import com.service.pptTeacherContentImportantService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pptTeacherContentImportantAction extends baseActionConfig8 {
    private DdupPptcontentEntity DdupPptcontentEntity;
    private pptContentService pptContentService;
    private DdupPptteachercontentimportantEntity pptTeacherContentImportant;
    private pptTeacherContentImportantService pptTeacherContentImportantService;
    private String tno;
    private String pptNo;
    private int pptPageNum;

    public com.bean.DdupPptcontentEntity getDdupPptcontentEntity() {
        return DdupPptcontentEntity;
    }

    public void setDdupPptcontentEntity(com.bean.DdupPptcontentEntity ddupPptcontentEntity) {
        DdupPptcontentEntity = ddupPptcontentEntity;
    }

    public com.service.pptContentService getPptContentService() {
        return pptContentService;
    }

    public void setPptContentService(com.service.pptContentService pptContentService) {
        this.pptContentService = pptContentService;
    }

    public DdupPptteachercontentimportantEntity getPptTeacherContentImportant() {
        return pptTeacherContentImportant;
    }

    public void setPptTeacherContentImportant(DdupPptteachercontentimportantEntity pptTeacherContentImportant) {
        this.pptTeacherContentImportant = pptTeacherContentImportant;
    }

    public com.service.pptTeacherContentImportantService getPptTeacherContentImportantService() {
        return pptTeacherContentImportantService;
    }

    public void setPptTeacherContentImportantService(com.service.pptTeacherContentImportantService pptTeacherContentImportantService) {
        this.pptTeacherContentImportantService = pptTeacherContentImportantService;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getPptNo() {
        return pptNo;
    }

    public void setPptNo(String pptNo) {
        this.pptNo = pptNo;
    }

    public int getPptPageNum() {
        return pptPageNum;
    }

    public void setPptPageNum(int pptPageNum) {
        this.pptPageNum = pptPageNum;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = pptTeacherContentImportantService.findAll();
            if (list.size() != 0) {
                map.put("pptTeacherContentImportantList", list);
                status = "1";

            } else {
                status = "0";
            }
            map.put("status", status);
            return ajax(map);
        } catch (Exception e) {
            status="-1";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }
    public String findById(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{
            List list=pptTeacherContentImportantService.findById(pptNo);
            if(list.size()!=0){
                pptTeacherContentImportant=(DdupPptteachercontentimportantEntity) list.get(0);
                map.put("pptTeacherContentImportant",pptTeacherContentImportant);
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
            pptTeacherContentImportant  =new DdupPptteachercontentimportantEntity();
            String tid = tno+"+";
            tid += pptNo;
            tid += "+";
            tid += pptPageNum;
            pptTeacherContentImportant.setDdupTno(tid);
            System.out.println(tid);
            pptTeacherContentImportant.setDdupPptNo(pptNo);
            pptTeacherContentImportant.setDdupPptPageNum(pptPageNum);
            if(pptTeacherContentImportantService.add(pptTeacherContentImportant)){
                status="1";
            }else{
                status="0";
            }
            map.put("status", status);
            return ajax(map);
        }catch (Exception e) {
            status="-1";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }

    public String update(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            pptTeacherContentImportant=new DdupPptteachercontentimportantEntity();
            pptTeacherContentImportant.setDdupTno(tno);
            System.out.println(tno);
            pptTeacherContentImportant.setDdupPptNo(pptNo);
            pptTeacherContentImportant.setDdupPptPageNum(pptPageNum);
            if(pptTeacherContentImportantService.updateInfo(pptTeacherContentImportant)){
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
    public String deleteById() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{
            String tid = tno+"+";
            tid += pptNo;
            tid += "+";
            tid += pptPageNum;
            if(pptTeacherContentImportantService.deleteById(tid)){
                List list=pptContentService.findByHql(pptNo,pptPageNum);
                DdupPptcontentEntity =(DdupPptcontentEntity) list.get(0);
                int n = DdupPptcontentEntity.getDdupPptImportant() - 1;
                DdupPptcontentEntity.setDdupPptImportant(n);
                pptContentService.updateById(DdupPptcontentEntity);
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
    public String findByTno() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = pptTeacherContentImportantService.findAll();
            List<String> list2 = new ArrayList();
            if (list.size() != 0) {
                for(int i=0;i<list.size();i++){
                    pptTeacherContentImportant=(DdupPptteachercontentimportantEntity) list.get(i);
                    String[] strarray = pptTeacherContentImportant.getDdupTno().split("\\+");
                    if(strarray[0].equals(tno)&&strarray[1].equals(pptNo)){
                        list2.add(strarray[2]);
                    }
                }
                map.put("pptPageNumList", list2);
                status = "1";
            } else {
                status = "0";
            }
            map.put("status", status);
            return ajax(map);
        } catch (Exception e) {
            status="-1";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }
}
