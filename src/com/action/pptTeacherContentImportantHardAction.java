package com.action;

import com.bean.DdupPptcontentEntity;
import com.service.pptContentService;
import com.bean.DdupPptteachercontentimportanthardEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pptTeacherContentImportantHardAction extends baseAction{
    private DdupPptcontentEntity DdupPptcontentEntity;
    private pptContentService pptContentService;
    private DdupPptteachercontentimportanthardEntity pptTeacherContentImportantHard;
    private com.service.pptTeacherContentImportantHardService pptTeacherContentImportantHardService;
    private String tno;
    private String pptNo;
    private int pptPageNum;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public DdupPptteachercontentimportanthardEntity getPptTeacherContentImportantHard() {
        return pptTeacherContentImportantHard;
    }

    public void setPptTeacherContentImportantHard(DdupPptteachercontentimportanthardEntity pptTeacherContentImportantHard) {
        this.pptTeacherContentImportantHard = pptTeacherContentImportantHard;
    }

    public com.service.pptTeacherContentImportantHardService getPptTeacherContentImportantHardService() {
        return pptTeacherContentImportantHardService;
    }

    public void setPptTeacherContentImportantHardService(com.service.pptTeacherContentImportantHardService pptTeacherContentImportantHardService) {
        this.pptTeacherContentImportantHardService = pptTeacherContentImportantHardService;
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
            List list = pptTeacherContentImportantHardService.findAll();
            if (list.size() != 0) {
                map.put("pptTeacherContentImportantHardList", list);
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
            List list=pptTeacherContentImportantHardService.findById(pptNo);
            if(list.size()!=0){
                pptTeacherContentImportantHard=(DdupPptteachercontentimportanthardEntity) list.get(0);
                map.put("pptTeacherContentImportantHard",pptTeacherContentImportantHard);
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

    public String findByHql() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try {
            List list = pptTeacherContentImportantHardService.findByHql(tno, pptNo, pptPageNum);
            if (list.size() != 0) {
                pptTeacherContentImportantHard = (DdupPptteachercontentimportanthardEntity) list.get(0);
                map.put("pptTeacherContentHard", pptTeacherContentImportantHard);
                status = "1";
            } else {
                status = "0";
            }
            map.put("status", status);
            return ajax(map);
        } catch (Exception e) {
            status = "0";
            map.put("status", status);
            e.printStackTrace();
            return ajax(map);
        }
    }


    public String add(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            pptTeacherContentImportantHard  =new DdupPptteachercontentimportanthardEntity();
            String tid = tno+"+";
            tid += pptNo;
            tid += "+";
            tid += pptPageNum;
            pptTeacherContentImportantHard.setDdupTno(tid);
            System.out.println(tid);
            pptTeacherContentImportantHard.setDdupPptNo(content);
            pptTeacherContentImportantHard.setDdupPptPageNum(pptPageNum);
            if(pptTeacherContentImportantHardService.add(pptTeacherContentImportantHard)){
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
            pptTeacherContentImportantHard=new DdupPptteachercontentimportanthardEntity();
            pptTeacherContentImportantHard.setDdupTno(tno);
            System.out.println(tno);
            pptTeacherContentImportantHard.setDdupPptNo(pptNo);
            pptTeacherContentImportantHard.setDdupPptPageNum(pptPageNum);
            if(pptTeacherContentImportantHardService.updateInfo(pptTeacherContentImportantHard)){
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
            if(pptTeacherContentImportantHardService.deleteById(tid)){
                List list=pptContentService.findByHql(pptNo,pptPageNum);
                DdupPptcontentEntity =(DdupPptcontentEntity) list.get(0);
                int n = DdupPptcontentEntity.getDdupPptImportantHard() - 1;
                DdupPptcontentEntity.setDdupPptImportantHard(n);
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
            List list = pptTeacherContentImportantHardService.findAll();
            List<String> list2 = new ArrayList();
            if (list.size() != 0) {
                for(int i=0;i<list.size();i++){
                    pptTeacherContentImportantHard=(DdupPptteachercontentimportanthardEntity) list.get(i);
                    String[] strarray = pptTeacherContentImportantHard.getDdupTno().split("\\+");
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
