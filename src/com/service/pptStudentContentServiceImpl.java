package com.service;

import com.bean.DdupPptstudentcontentEntity;
import com.dao.pptStudentContentDao;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class pptStudentContentServiceImpl implements pptStudentContentService {
    private pptStudentContentDao pptStudentContentDao = null;

    public pptStudentContentServiceImpl(){
        System.out.println("create pptTeacherContentHardServiceImpl!");
    }

    public void setPptStudentContentDao(com.dao.pptStudentContentDao pptStudentContentDao) {
        this.pptStudentContentDao = pptStudentContentDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupPptstudentcontentEntity ";
        List list=pptStudentContentDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupPptstudentcontentEntity where ddup_pptNo='"+id+"'";
        List list=pptStudentContentDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findByHql(String sno, String pptno, int pageno){
        String hql="from DdupPptstudentcontentEntity where ddup_sno='"+sno+"' AND ddup_pptNo='"+pptno+"' AND ddup_pptPageNum='"+pageno+"'";
        List list=pptStudentContentDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupPptstudentcontentEntity t){
        {

            DdupPptstudentcontentEntity pptTeacherContentHard = pptStudentContentDao.findById(t.getDdupSno());
            if (t.getDdupPptNo() != null && !t.getDdupPptNo().equals("")){
                pptTeacherContentHard.setDdupPptNo(t.getDdupPptNo());
            }
            if (t.getDdupPptPageNum()> 0){
                pptTeacherContentHard.setDdupPptPageNum(t.getDdupPptPageNum());
            }
            try{
                pptStudentContentDao.update(pptTeacherContentHard);
                System.out.println("更新成功");
                return true;
            }catch(Exception e){
                System.out.println("更新失败");
                return false;
            }

        }
    }
    @Override
    @Transactional
    public Boolean delete(DdupPptstudentcontentEntity t){
        try{
            pptStudentContentDao.delete(t);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean deleteById(String id){
        try{
            String hql="from DdupPptstudentcontentEntity where ddup_sno='"+id+"'";
            List list = pptStudentContentDao.findByHql(hql);
            DdupPptstudentcontentEntity Pptteachercontenthard =(DdupPptstudentcontentEntity)list.get(0);
            pptStudentContentDao.delete(Pptteachercontenthard);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupPptstudentcontentEntity t){
        {
            String sno = t.getDdupSno();
            String pptno = t.getDdupPptNo();
            int pageno = t.getDdupPptPageNum();
            String hql="from DdupPptstudentcontentEntity where ddup_sno='"+sno+"'";
            List list = pptStudentContentDao.findByHql(hql);
            if(list.isEmpty()){
                System.out.println("成功");
                pptStudentContentDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
