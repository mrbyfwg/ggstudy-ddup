package com.action;

import com.bean.CourseinformationEntity;
import com.bean.DdupStudentEntity;
import com.service.courseInfService;
import com.service.studentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class courseInfAction extends baseAction {
    private com.bean.CourseinformationEntity CourseinformationEntity;
    private com.service.courseInfService courseInfService;
    private com.bean.DdupStudentEntity StudentEntity;
    private com.service.studentService studentService;
    private String sno;
    private String courseName;
    private String cno;
    private String teacherName;
    private String tno;
    private String classno;
    private String period;
    private int learnTime;
    private String testMethod;
    private int credit;
    private String teachRoomId;
    private String teachBuildingName;

    public com.bean.CourseinformationEntity getCourseinformationEntity() {
        return CourseinformationEntity;
    }

    public void setCourseinformationEntity(com.bean.CourseinformationEntity courseinformationEntity) {
        CourseinformationEntity = courseinformationEntity;
    }

    public com.service.courseInfService getCourseInfService() {
        return courseInfService;
    }

    public void setCourseInfService(com.service.courseInfService courseInfService) {
        this.courseInfService = courseInfService;
    }

    public DdupStudentEntity getStudentEntity() {
        return StudentEntity;
    }

    public void setStudentEntity(DdupStudentEntity studentEntity) {
        StudentEntity = studentEntity;
    }

    public com.service.studentService getStudentService() {
        return studentService;
    }

    public void setStudentService(com.service.studentService studentService) {
        this.studentService = studentService;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getLearnTime() {
        return learnTime;
    }

    public void setLearnTime(int learnTime) {
        this.learnTime = learnTime;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getTeachRoomId() {
        return teachRoomId;
    }

    public void setTeachRoomId(String teachRoomId) {
        this.teachRoomId = teachRoomId;
    }

    public String getTeachBuildingName() {
        return teachBuildingName;
    }

    public void setTeachBuildingName(String teachBuildingName) {
        this.teachBuildingName = teachBuildingName;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = courseInfService.findAll();
            if (list.size() != 0) {
                map.put("courseInfList", list);
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
    public String findByTno(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{
            List list=courseInfService.findByTno(tno);
            if(list.size()!=0){
                map.put("courseInfList1", list);
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

    public String findByClassno(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{
            List list=courseInfService.findByClassno(classno);
            if(list.size()!=0){
                map.put("courseInfList2", list);
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

    public String findBySno(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{
            List list1=studentService.findById(sno);
            if(list1.size()!=0){
                StudentEntity=(DdupStudentEntity) list1.get(0);
                //map.put("student",StudentEntity);
                //status="1";
                List list=courseInfService.findByClassno(StudentEntity.getDdupClass());
                if(list.size()!=0){
                    map.put("courseInfList2", list);
                    status="1";
                }
                else{
                    status="0";
                }
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

/*
    public String openSign(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;

        try{
            List list=courseInfService.findByCno(cno);
            if(list.size()!=0){
                CourseinformationEntity = (CourseinformationEntity)list.get(0);
                CourseinformationEntity.setDdupTestMethod(testMethod);
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

    }*/
//        public String add(){
//        Map<String, Object> map = new HashMap<String, Object>();
//        String status = null;
//        try{
//            CourseinformationEntity=new CourseinformationEntity();
//            CourseinformationEntity.setDdupAge(age);
//            System.out.println(age);
//            CourseinformationEntity.setDdupName(name);
//            CourseinformationEntity.setDdupPhone(phone);
//            CourseinformationEntity.setDdupSex(sex);
//            CourseinformationEntity.setDdupTitle(title);
//            CourseinformationEntity.setDdupTno(id);
//            if(courseInfService.add(CourseinformationEntity)){
//                status="1";
//            }else{
//                status="0";
//            }
//            map.put("status", status);
//            return ajax(map);
//        }catch (Exception e) {
//            status="0";
//            map.put("status", status);
//            e.printStackTrace();
//            return ajax(map);
//        }
//    }
//        public String update(){
//        Map<String, Object> map = new HashMap<String, Object>();
//        String status = null;
//        try{
//            CourseinformationEntity=new CourseinformationEntity();
//            CourseinformationEntity.setDdupAge(age);
//            CourseinformationEntity.setDdupName(name);
//            CourseinformationEntity.setDdupPhone(phone);
//            CourseinformationEntity.setDdupSex(sex);
//            CourseinformationEntity.setDdupTitle(title);
//            CourseinformationEntity.setDdupTno(id);
//            if(courseInfService.updateInfo(CourseinformationEntity)){
//                status="1";
//            }else{
//                status="0";
//            }
//            map.put("status", status);
//            return ajax(map);
//        }catch (Exception e) {
//            status="0";
//            map.put("status", status);
//            e.printStackTrace();
//            return ajax(map);
//        }
//    }
//        public String deleteById(){
//        Map<String, Object> map = new HashMap<String, Object>();
//        String status = null;
//
//        try{
//
//            if(courseInfService.deleteById(id)){
//                status="1";
//            }else{
//                status="0";
//            }
//            map.put("status", status);
//            return ajax(map);
//        }catch (Exception e) {
//            status="0";
//            map.put("status", status);
//            e.printStackTrace();
//            return ajax(map);
//        }

//    }
}
