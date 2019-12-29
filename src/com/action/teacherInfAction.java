package com.action;

import com.bean.TeacherinformationEntity;
import com.service.teacherInfService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Dwt0610
 * @Date 2019/12/14
 */
public class teacherInfAction extends baseAction {
    private TeacherinformationEntity TeacherinformationEntity;
    private teacherInfService teacherInfService;
    private String result;
    private String id;
    private String name;
    private String sex;
    private int age;
    private String phone;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public com.bean.TeacherinformationEntity getTeacherinformationEntity() {
        return TeacherinformationEntity;
    }

    public void setTeacherinformationEntity(com.bean.TeacherinformationEntity teacherinformationEntity) {
        TeacherinformationEntity = teacherinformationEntity;
    }

    public com.service.teacherInfService getTeacherInfService() {
        return teacherInfService;
    }

    public void setTeacherInfService(com.service.teacherInfService teacherInfService) {
        this.teacherInfService = teacherInfService;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = teacherInfService.findAll();
            if (list.size() != 0) {
                map.put("teacherList", list);
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
            List list=teacherInfService.findById(id);
            if(list.size()!=0){
                TeacherinformationEntity=(TeacherinformationEntity) list.get(0);
                map.put("teacher",TeacherinformationEntity);
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
//        public String add(){
//        Map<String, Object> map = new HashMap<String, Object>();
//        String status = null;
//        try{
//            TeacherinformationEntity=new TeacherinformationEntity();
//            TeacherinformationEntity.setDdupAge(age);
//            System.out.println(age);
//            TeacherinformationEntity.setDdupName(name);
//            TeacherinformationEntity.setDdupPhone(phone);
//            TeacherinformationEntity.setDdupSex(sex);
//            TeacherinformationEntity.setDdupTitle(title);
//            TeacherinformationEntity.setDdupTno(id);
//            if(teacherInfService.add(TeacherinformationEntity)){
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
//            TeacherinformationEntity=new TeacherinformationEntity();
//            TeacherinformationEntity.setDdupAge(age);
//            TeacherinformationEntity.setDdupName(name);
//            TeacherinformationEntity.setDdupPhone(phone);
//            TeacherinformationEntity.setDdupSex(sex);
//            TeacherinformationEntity.setDdupTitle(title);
//            TeacherinformationEntity.setDdupTno(id);
//            if(teacherInfService.updateInfo(TeacherinformationEntity)){
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
//            if(teacherInfService.deleteById(id)){
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
