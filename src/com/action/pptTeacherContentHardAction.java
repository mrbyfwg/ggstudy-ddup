package com.action;

import com.bean.DdupPptcontentEntity;
import com.service.pptContentService;
import com.bean.DdupPptteachercontenthardEntity;
import com.service.pptTeacherContentHardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pptTeacherContentHardAction extends baseAction {
    private DdupPptcontentEntity DdupPptcontentEntity;
    private pptContentService pptContentService;
    private DdupPptteachercontenthardEntity pptTeacherContentHard;
    private pptTeacherContentHardService pptTeacherContentHardService;
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

    public DdupPptteachercontenthardEntity getPptTeacherContentHard() {
        return pptTeacherContentHard;
    }

    public void setPptTeacherContentHard(DdupPptteachercontenthardEntity pptTeacherContentHard) {
        this.pptTeacherContentHard = pptTeacherContentHard;
    }

    public com.service.pptTeacherContentHardService getPptTeacherContentHardService() {
        return pptTeacherContentHardService;
    }

    public void setPptTeacherContentHardService(com.service.pptTeacherContentHardService pptTeacherContentHardService) {
        this.pptTeacherContentHardService = pptTeacherContentHardService;
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
            List list = pptTeacherContentHardService.findAll();
            if (list.size() != 0) {
                map.put("pptTeacherContentHardList", list);
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
            List list=pptTeacherContentHardService.findById(pptNo);
            if(list.size()!=0){
                //pptTeacherContentHard=(DdupPptteachercontenthardEntity) list.get(0);
                map.put("pptTeacherContentHardList",list);
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
            List list = pptTeacherContentHardService.findByHql(tno, pptNo, pptPageNum);
            if (list.size() != 0) {
                pptTeacherContentHard = (DdupPptteachercontenthardEntity) list.get(0);
                map.put("pptTeacherContentHard", pptTeacherContentHard);
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
            pptTeacherContentHard  =new DdupPptteachercontenthardEntity();
            String tid = tno+"+";
            tid += pptNo;
            tid += "+";
            tid += pptPageNum;
            pptTeacherContentHard.setDdupTno(tid);
            System.out.println(tid);
            pptTeacherContentHard.setDdupPptNo(pptNo);
            pptTeacherContentHard.setDdupPptPageNum(pptPageNum);
            if(pptTeacherContentHardService.add(pptTeacherContentHard)){
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
            pptTeacherContentHard=new DdupPptteachercontenthardEntity();
            pptTeacherContentHard.setDdupTno(tno);
            System.out.println(tno);
            pptTeacherContentHard.setDdupPptNo(pptNo);
            pptTeacherContentHard.setDdupPptPageNum(pptPageNum);
            if(pptTeacherContentHardService.updateInfo(pptTeacherContentHard)){
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
            String tid = tno+"+";
            tid += pptNo;
            tid += "+";
            tid += pptPageNum;
            if(pptTeacherContentHardService.deleteById(tid)){
                List list=pptContentService.findByHql(pptNo,pptPageNum);
                DdupPptcontentEntity =(DdupPptcontentEntity) list.get(0);
                int n = DdupPptcontentEntity.getDdupPptHard() - 1;
                DdupPptcontentEntity.setDdupPptHard(n);
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
            List list = pptTeacherContentHardService.findAll();
            List<String> list2 = new ArrayList();
            if (list.size() != 0) {
                for(int i=0;i<list.size();i++){
                    pptTeacherContentHard=(DdupPptteachercontenthardEntity) list.get(i);
                    String[] strarray = pptTeacherContentHard.getDdupTno().split("\\+");
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
