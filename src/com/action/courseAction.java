package com.action;

import com.bean.DdupCourseEntity;
import com.service.courseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class courseAction extends baseActionConfig4{
    private DdupCourseEntity course;
    private courseService courseService;

    public DdupCourseEntity getCourse() {
        return course;
    }

    public void setCourse(DdupCourseEntity course) {
        this.course = course;
    }

    public com.service.courseService getCourseService() {
        return courseService;
    }

    public void setCourseService(com.service.courseService courseService) {
        this.courseService = courseService;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTestm() {
        return testm;
    }

    public void setTestm(String testm) {
        this.testm = testm;
    }

    public int getLtime() {
        return ltime;
    }

    public void setLtime(int ltime) {
        this.ltime = ltime;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    private String id;
    private String name;
    private String period;
    private String testm;
    private int ltime;
    private int credit;



    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = courseService.findAll();
            if (list.size() != 0) {
                map.put("courselist", list);
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
            List list=courseService.findById(id);
            if(list.size()!=0){
                course=(DdupCourseEntity) list.get(0);
                map.put("course",course);
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
            course=new DdupCourseEntity();
            course.setDdupCno(id);
            course.setDdupCredit(credit);
            course.setDdupLearnTime(ltime);
            course.setDdupPeriod(period);
            course.setDdupName(name);
            course.setDdupTestMethod(testm);
            if(courseService.add(course)){
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
            course=new DdupCourseEntity();
            course.setDdupCno(id);
            course.setDdupCredit(credit);
            course.setDdupLearnTime(ltime);
            course.setDdupPeriod(period);
            course.setDdupName(name);
            course.setDdupTestMethod(testm);
            if(courseService.updateInfo(course)){
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
            if(courseService.deleteById(id)){
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
