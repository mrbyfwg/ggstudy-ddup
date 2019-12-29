package com.action;

import com.bean.*;
import com.service.pptStudentContentService;
import com.service.pptTeacherContentImportantService;
import jdk.management.resource.internal.inst.AbstractPlainDatagramSocketImplRMHooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Dwt0610
 * @Date 2019/12/14
 */
public class pptContentAction extends baseAction{
    private DdupPptcontentEntity pptContent;
    private com.service.pptContentService pptContentService;
    private DdupPptmanageEntity pptManage;
    private com.service.pptManageService pptManageService;

    private String id;
    private int pageNum;
    private int pptImportant;
    private int pptHard;
    private int pptImportantHard;
    private int pptQuestion;
    private  String cno;

    public DdupPptcontentEntity getpptContent() {
        return pptContent;
    }

    public void setPptContent(DdupPptcontentEntity pptContent) {
        this.pptContent = pptContent;
    }

    public com.service.pptContentService getPptContentService() {
        return pptContentService;
    }

    public void setPptContentService(com.service.pptContentService pptContentService) {
        this.pptContentService = pptContentService;
    }
    public DdupPptmanageEntity getpptManage() {
        return pptManage;
    }

    public void setPptManage(DdupPptmanageEntity pptManage) {
        this.pptManage = pptManage;
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
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPptImportant() {
        return pptImportant;
    }

    public void setPptImportant(int pptImportant) {
        this.pptImportant = pptImportant;
    }

    public int getPptHard() {
        return pptHard;
    }

    public void setPptHard(int pptHard) {
        this.pptHard = pptHard;
    }

    public int getPptImportantHard() {
        return pptImportantHard;
    }

    public void setPptImportantHard(int pptImportantHard) {
        this.pptImportantHard = pptImportantHard;
    }

    public int getPptQuestion() {
        return pptQuestion;
    }

    public void setPptQuestion(int pptQuestion) {
        this.pptQuestion = pptQuestion;
    }


    private com.bean.DdupPptteachercontentimportanthardEntity pptTeacherContentImportantHard;
    private com.service.pptTeacherContentImportantHardService pptTeacherContentImportantHardService;
    private DdupPptstudentcontentEntity pptStudentContentEntity;
    private com.service.pptStudentContentService pptStudentContentService;
    private String content;
    private String stno;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStno() {
        return stno;
    }

    public void setStno(String stno) {
        this.stno = stno;
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

    public String updateLable() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = pptContentService.findById(id);
            if (list.size() != 0) {
                for(int i=0; i<list.size(); i++){
                    pptContent = (DdupPptcontentEntity) list.get(i);
                    if( pptContent.getDdupPptPageNum() == pageNum ){
                        break;
                    }
                }
                if(pptImportantHard == 1){
                    pptContent.setDdupPptImportant(0);
                    pptContent.setDdupPptHard(0);
                    pptContent.setDdupPptImportantHard(pptImportantHard);
                    pptContentService.updateById(pptContent);
                    pptTeacherContentImportantHard  =new DdupPptteachercontentimportanthardEntity();
                    String PAGENUM = pageNum + "";
//                    String TNO = stno+"+"+id+"+"+PAGENUM;
                    String TNO = "1"+"+"+id+"+"+PAGENUM;
                    System.out.println(pptTeacherContentImportantHard.getDdupPptNo());
                    pptTeacherContentImportantHard.setDdupTno(TNO);
                    pptTeacherContentImportantHard.setDdupPptNo(content);
                    pptTeacherContentImportantHard.setDdupPptPageNum(pageNum);
                    pptTeacherContentImportantHardService.add(pptTeacherContentImportantHard);
                }else{
                    pptContent.setDdupPptImportantHard(0);
                    pptContent.setDdupPptHard(pptHard);
                    pptContent.setDdupPptImportant(pptImportant);
                    pptContentService.updateById(pptContent);
                }
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
    public String updateQuestion() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = pptContentService.findById(id);
            if (list.size() != 0) {
                for(int i=0; i<list.size(); i++){
                    pptContent = (DdupPptcontentEntity) list.get(i);
                    if(pptContent.getDdupPptPageNum()==pageNum){
                        break;
                    }
                }
                pptQuestion = pptContent.getDdupPptQuestionNum() + 1;
                pptContent.setDdupPptQuestionNum(pptQuestion);
                pptContentService.updateById(pptContent);

                pptStudentContentEntity = new DdupPptstudentcontentEntity();
                String PAGENUM = pageNum + "";
                String SNO = stno + "+" + id + "+" + PAGENUM;
                pptStudentContentEntity.setDdupSno(SNO);
                pptStudentContentEntity.setDdupPptNo(id);
                pptStudentContentEntity.setDdupPptPageNum(pageNum);
                System.out.println(SNO+" "+id+" "+pageNum);
                pptStudentContentService.add(pptStudentContentEntity);
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
    //增加一个接口，放回课程的章节名
    public String findCoursepPpt() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List alllist = pptManageService.findAll();
            List<String> idlist = new ArrayList<>();
            List<String> namelist = new ArrayList<>();
            List<String> chapterlist = new ArrayList<>();
            int count = 0;
            if (alllist.size() != 0) {
                for(int i=0; i<alllist.size(); i++) {
                    pptManage = (DdupPptmanageEntity) alllist.get(i);
                    String PPTNAME = pptManage.getDdupName();
                    String[] strarray = PPTNAME.split("\\+");
                    if (strarray[2].equals(cno)) {
                        idlist.add(pptManage.getDdupPptNo());
                        chapterlist.add(strarray[3]);
                        namelist.add(strarray[0]);
                    }
                }
                map.put("idlist", idlist);
                map.put("namelist", namelist);
                map.put("chapterlist", chapterlist);
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
    /*
    <action name="findCoursepPpt" class="com.action.pptContentAction" method="findCoursepPpt">
            <result type="json">
                <param name="root">result</param>
            </result>
        </action>
     */



    public String CourseInformation() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List alllist = pptManageService.findAll();
            List<String> idlist = new ArrayList<>();
            List<String> namelist = new ArrayList<>();
            List<String> chapterlist = new ArrayList<>();
            List<String> nameimportantlist = new ArrayList<>();
            List<String> pageimportantlist = new ArrayList<>();
            List<String> namehardlist  = new ArrayList<>();
            List<String> pagehardlist = new ArrayList<>();
            List<String> nameimportanthardlist = new ArrayList<>();//teacher
            List<String> pageimportanthardlist = new ArrayList<>();//teacher
            List<String> numimportanthardlist = new ArrayList<>();//student
            List<String> numhardlist = new ArrayList<>();
            List<String> numimportantlist = new ArrayList<>();
            List<String> numlist = new ArrayList<>();
            int count = 0;
            int allcount = 0;
            if (alllist.size() != 0) {
                for(int i=0; i<alllist.size(); i++){
                    pptManage = (DdupPptmanageEntity)alllist.get(i);
                    String PPTNAME = pptManage.getDdupName();
                    String[] strarray=PPTNAME.split("\\+");
                    if(strarray[3].equals(id) && strarray[2].equals(cno)){
                        idlist.add(pptManage.getDdupPptNo());
                        chapterlist.add(strarray[3]);
                        namelist.add(strarray[0]);
                    }
                }
                for(int i=0; i<idlist.size(); i++){
                    System.out.println("idlist.get(i)"+idlist.get(i));
                    alllist = pptContentService.findById(idlist.get(i));
                    System.out.println(alllist);
                    for(int j=0; j<alllist.size(); j++){
                        pptContent = (DdupPptcontentEntity)alllist.get(j);
                        System.out.println("pptContent.getDdupPptQuestionNum()="+pptContent.getDdupPptQuestionNum()+"  j="+j);
                        allcount = allcount + pptContent.getDdupPptQuestionNum();
                        if(pptContent.getDdupPptImportantHard()==1){
                            nameimportanthardlist.add(namelist.get(i));
                            pageimportanthardlist.add(pptContent.getDdupPptPageNum()+"");
                            numimportanthardlist.add(pptContent.getDdupPptQuestionNum() + "");
                        }else{
                            if(pptContent.getDdupPptHard()==1){
                                namehardlist.add(namelist.get(i));
                                pagehardlist.add(pptContent.getDdupPptPageNum()+"");
                                numhardlist.add(pptContent.getDdupPptQuestionNum() + "");
                            }
                            if(pptContent.getDdupPptImportant()==1){
                                nameimportantlist.add(namelist.get(i));
                                pageimportantlist.add(pptContent.getDdupPptPageNum()+"");
                                numimportantlist.add(pptContent.getDdupPptQuestionNum() + "");
                            }
                        }
                    }
                    numlist.add(allcount+"");
                    allcount = 0;
                }
                map.put("nameimportantlist", nameimportantlist);
                map.put("pageimportantlist", pageimportantlist);
                map.put("namehardlist ", namehardlist );
                map.put("pagehardlist", pagehardlist);
                map.put("nameimportanthardlist", nameimportanthardlist);
                map.put("pageimportanthardlist", pageimportanthardlist);
                map.put("idlist", idlist);
                map.put("namelist", namelist);
                map.put("chapterlist", chapterlist);
                map.put("numlist", numlist);
                map.put("numimportanthardlist", numimportanthardlist);
                map.put("numhardlist", numhardlist);
                map.put("numimportantlist", numimportantlist);
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
    public String findLable() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = pptContentService.findById(id);
            if (list.size() != 0) {
                map.put("list", list);
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


    public DdupPptmanageEntity getPptManage() {
        return pptManage;
    }

    public DdupPptcontentEntity getPptContent() {
        return pptContent;
    }

    public String findAllUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        try {
            List list = pptContentService.findAll();
            if (list.size() != 0) {
                map.put("pptContentList", list);
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
            List list=pptContentService.findById(id);
            if(list.size()!=0){
                pptContent=(DdupPptcontentEntity) list.get(0);
                map.put("pptContent",pptContent);
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
            pptContent =new DdupPptcontentEntity();
            pptContent.setDdupPptNo(id);
            pptContent.setDdupPptPageNum(pageNum);
            pptContent.setDdupPptImportant(pptImportant);
            pptContent.setDdupPptHard(pptHard);
            pptContent.setDdupPptImportantHard(pptImportantHard);
            pptContent.setDdupPptQuestionNum(pptQuestion);
            if(pptContentService.add(pptContent)){
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
            pptContent=new DdupPptcontentEntity();
            pptContent.setDdupPptNo(id);
            pptContent.setDdupPptPageNum(pageNum);
            pptContent.setDdupPptImportant(pptImportant);
            pptContent.setDdupPptHard(pptHard);
            pptContent.setDdupPptImportantHard(pptImportantHard);
            pptContent.setDdupPptQuestionNum(pptQuestion);
            if(pptContentService.updateInfo(pptContent)){
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

            if(pptContentService.deleteById(id)){
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
