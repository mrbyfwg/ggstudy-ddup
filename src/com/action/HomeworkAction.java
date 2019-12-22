package com.action;

import com.bean.DdupHomeworkEntity;
import com.service.HomeworkService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkAction extends baseActionConfig2{
    private DdupHomeworkEntity homework;
    private HomeworkService homeworkService;
    private String id;
    private String Cno;
    private String name;
    private int submitNum;
    private String eTime;
    private String sTime;

    public com.bean.DdupHomeworkEntity getHomework() {
        return homework;
    }

    public void setHomework(com.bean.DdupHomeworkEntity homework) {
        this.homework = homework;
    }

    public com.service.HomeworkService getHomeworkService() {
        return homeworkService;
    }

    public void setHomeworkService(com.service.HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubmitNum() {
        return submitNum;
    }

    public void setSubmitNum(int submitNum) {
        this.submitNum = submitNum;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }
    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list=homeworkService.findAll();
            if (list.size() != 0) {
                map.put("homeworklist", list);
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
            List list=homeworkService.findById(id);
            if(list.size()!=0){
                homework=(DdupHomeworkEntity) list.get(0);
                map.put("homework",homework);
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
            homework=new DdupHomeworkEntity();
            homework.setDdupCno(Cno);
            homework.setDdupEndTime(eTime);
            homework.setDdupStartTime(sTime);
            homework.setDdupSubmitNum(submitNum);
            homework.setDdupHomeworkNum(id);
            homework.setDdupHomeworkName(name);
            if(homeworkService.add(homework)){
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
            homework=new DdupHomeworkEntity();
            homework.setDdupCno(Cno);
            homework.setDdupEndTime(eTime);
            homework.setDdupStartTime(sTime);
            homework.setDdupSubmitNum(submitNum);
            homework.setDdupHomeworkNum(id);
            if(homeworkService.updateInfo(homework)){
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
            if(homeworkService.deleteById(id)){
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
