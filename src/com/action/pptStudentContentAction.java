package com.action;

import com.bean.DdupPptcontentEntity;
import com.bean.DdupPptstudentcontentEntity;
import com.service.pptStudentContentService;
import com.service.pptContentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Dwt0610
 * @Date 2019/12/14
 */
public class pptStudentContentAction extends baseAction{
    private DdupPptcontentEntity DdupPptcontentEntity;
    private pptContentService pptContentService;
    private DdupPptstudentcontentEntity pptStudentContentEntity;
    private pptStudentContentService pptStudentContentService;
    private String sno;
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

    public DdupPptstudentcontentEntity getPptStudentContentEntity() {
        return pptStudentContentEntity;
    }

    public void setPptStudentContentEntity(DdupPptstudentcontentEntity pptStudentContentEntity) {
        this.pptStudentContentEntity = pptStudentContentEntity;
    }

    public com.service.pptStudentContentService getPptStudentContentService() {
        return pptStudentContentService;
    }

    public void setPptStudentContentService(com.service.pptStudentContentService pptStudentContentService) {
        this.pptStudentContentService = pptStudentContentService;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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
            List list = pptStudentContentService.findAll();
            if (list.size() != 0) {
                map.put("pptStudentContentList", list);
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
            List list=pptStudentContentService.findById(pptNo);
            if(list.size()!=0){
                pptStudentContentEntity=(DdupPptstudentcontentEntity) list.get(0);
                map.put("pptStudentContentEntity",pptStudentContentEntity);
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
            pptStudentContentEntity  =new DdupPptstudentcontentEntity();
            String sid = sno+"+";
            sid += pptNo;
            sid += "+";
            sid += pptPageNum;
            pptStudentContentEntity.setDdupSno(sid);
            System.out.println(sid);
            pptStudentContentEntity.setDdupPptNo(pptNo);
            pptStudentContentEntity.setDdupPptPageNum(pptPageNum);
            if(pptStudentContentService.add(pptStudentContentEntity)){
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
            pptStudentContentEntity=new DdupPptstudentcontentEntity();
            pptStudentContentEntity.setDdupSno(sno);
            System.out.println(sno);
            pptStudentContentEntity.setDdupPptNo(pptNo);
            pptStudentContentEntity.setDdupPptPageNum(pptPageNum);
            if(pptStudentContentService.updateInfo(pptStudentContentEntity)){
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
            String sid = sno+"+";
            sid += pptNo;
            sid += "+";
            sid += pptPageNum;
            if(pptStudentContentService.deleteById(sid)){
                List list=pptContentService.findByHql(pptNo,pptPageNum);
                DdupPptcontentEntity =(DdupPptcontentEntity) list.get(0);
                int n = DdupPptcontentEntity.getDdupPptQuestionNum() - 1;
                DdupPptcontentEntity.setDdupPptQuestionNum(n);
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


    public String findBySno() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = pptStudentContentService.findAll();
            List<String> list2 = new ArrayList();
            if (list.size() != 0) {
                for(int i=0;i<list.size();i++){
                    pptStudentContentEntity=(DdupPptstudentcontentEntity) list.get(i);
                    String[] strarray = pptStudentContentEntity.getDdupSno().split("\\+");
                    if(strarray[0].equals(sno)&&strarray[1].equals(pptNo)){
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
