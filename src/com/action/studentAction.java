package com.action;

import com.bean.DdupStudentEntity;
import com.service.studentService;
import com.bean.DdupCourseEntity;
import com.service.courseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Dwt0610
 * @Date 2019/12/14
 */
public class studentAction extends baseActionConfig{
    private DdupStudentEntity student;
    private studentService studentService;
    private DdupCourseEntity course;
    private courseService courseService;
    private String result;
    private String id;
    private String name;
    private String sex;
    private int age;
    private String ddclass;
    private String originPlace;




    public DdupStudentEntity getStudent() {
        return student;
    }

    public void setStudent(DdupStudentEntity student) {
        this.student = student;
    }

    public com.service.studentService getStudentService() {
        return studentService;
    }

    public void setStudentService(com.service.studentService studentService) {
        this.studentService = studentService;
    }

    public DdupCourseEntity getCourse() {
        return course;
    }

    public com.service.courseService getCourseService() {
        return courseService;
    }

    public void setCourseService(com.service.courseService courseService) {
        this.courseService = courseService;
    }


    public void setCourse(DdupCourseEntity course) {
        this.course = course;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getDdclass() {
        return ddclass;
    }

    public void setDdclass(String ddclass) {
        this.ddclass = ddclass;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }


    public String sign() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        String ORIGINPLACE = null;
        try {
            System.out.println(id + " "+ name + " "+ sex +" "+ ddclass);
            List slist = studentService.findById(id);
            System.out.println("cno:"+name);
            List clist = courseService.findById(name);
            if (slist.size() != 0 && clist.size() != 0) {
                student = (DdupStudentEntity) slist.get(0);
                course = (DdupCourseEntity) clist.get(0);
                System.out.println("sex="+sex+" =="+course.getDdupTestMethod().equals(sex));
                if( course.getDdupTestMethod().equals(sex) ){
                    ORIGINPLACE = "1+";
                    ORIGINPLACE = ORIGINPLACE + ddclass;
                    student.setDdupOriginPlace(ORIGINPLACE);
                    studentService.updateInfo(student);
                    status = "1";
                }else{
                    ORIGINPLACE = "3+";
                    ORIGINPLACE = ORIGINPLACE + ddclass;
                    student.setDdupOriginPlace(ORIGINPLACE);
                    studentService.updateInfo(student);
                    status = "0";
                }
//                status = "1";
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

    public String updateSign() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        String ORIGINPLACE = null;
        try
        {
            List slist = studentService.findById(id);
            if (slist.size() != 0) {
                student = (DdupStudentEntity) slist.get(0);
                ORIGINPLACE = student.getDdupOriginPlace();
                String[] strarray=ORIGINPLACE.split("\\+");
                for (int i = 0; i < strarray.length; i++) {
                    System.out.println(strarray[i]);
                }
                strarray[0] = name;
                ORIGINPLACE = strarray[0] + "+" + strarray[1];
                System.out.println(ORIGINPLACE);
                student.setDdupOriginPlace(ORIGINPLACE);
                studentService.updateInfo(student);
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

    public String getSign() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        int signNum = 0;
        int allNum = 0;
        int leaveNum = 0;
        List<String> idlist = new ArrayList<>();
        List<String> namelist = new ArrayList<>();
        List<String> statelist = new ArrayList<>();
        List<String> timelist = new ArrayList<>();
        try
        {
            List slist = studentService.findAll();
            allNum = slist.size();
            for( int i=0; i<slist.size(); i++ ){
                student = (DdupStudentEntity) slist.get(i);
                idlist.add(student.getDdupSno());
                namelist.add(student.getDdupName());
                String ORIGINPLACE = null ;
                ORIGINPLACE = student.getDdupOriginPlace();
                String[] strarray=ORIGINPLACE.split("\\+");
                statelist.add(strarray[0]);
                timelist.add(strarray[1]);
                if(strarray[0].equals("1")){
                    signNum++;
                }else if(strarray[0].equals("2")){
                    leaveNum++;
                }
            }
            status = "1";
            map.put("status", status);
            map.put("allNum", allNum);
            map.put("signNum", signNum);
            map.put("leaveNum", leaveNum);
            map.put("idlist", idlist);
            map.put("namelist", namelist);
            map.put("statelist", statelist);
            map.put("timelist", timelist);
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
            List list = studentService.findAll();
            if (list.size() != 0) {
                map.put("studentlist", list);
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
            List list=studentService.findById(id);
            if(list.size()!=0){
                student=(DdupStudentEntity) list.get(0);
                map.put("student",student);
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
            student=new DdupStudentEntity();
            student.setDdupAge(age);
            System.out.println(age);
            student.setDdupName(name);
            student.setDdupClass(ddclass);
            student.setDdupSex(sex);
            student.setDdupOriginPlace(originPlace);
            student.setDdupSno(id);
            if(studentService.add(student)){
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
            student=new DdupStudentEntity();
            student.setDdupAge(age);
            System.out.println(age);
            student.setDdupName(name);
            student.setDdupClass(ddclass);
            student.setDdupSex(sex);
            student.setDdupOriginPlace(originPlace);
            student.setDdupSno(id);
            if(studentService.updateInfo(student)){
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
            if(studentService.deleteById(id)){
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



    public String rankingCreate() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = studentService.findAllOrder();
            if (list.size() != 0) {
                map.put("studentlist", list);
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

    public String rankingFind(){
        Map<String, Object> map = new HashMap<String, Object>();
        int no = 0;
        String status = null;
        try{
            List list1=studentService.findById(id);
            if(list1.size()!=0){
                student=(DdupStudentEntity) list1.get(0);
                map.put("yourLearnTime",student.getDdupAge());
                List list2 = studentService.findAllOrder();
                if (list2.size() != 0) {
                    //map.put("studentlist", list);
                    no = list2.indexOf(student);
                    map.put("no", no+1);
                    if(no != 0){
                        student=(DdupStudentEntity) list2.get(no-1);
                        map.put("laststudentLearnTime",student.getDdupAge());
                    }
                    status = "1";
                } else {
                    status = "0";
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

    public String addToStudyTime(){
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try{
            if(studentService.updateInfo2(id,age)){
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
