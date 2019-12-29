package com.service;

import com.bean.DdupPptteachercontentimportantEntity;
import com.dao.pptTeacherContentImportantDao;
import com.dao.pptTeacherContentImportantDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class pptTeacherContentImportantServiceImpl implements pptTeacherContentImportantService{
    private pptTeacherContentImportantDao pptTeacherContentImportantDao = null;

    public pptTeacherContentImportantServiceImpl(){
        System.out.println("create pptTeacherContentImportantServiceImpl!");
    }

    public void setPptTeacherContentImportantDao(com.dao.pptTeacherContentImportantDao pptTeacherContentImportantDao) {
        this.pptTeacherContentImportantDao = pptTeacherContentImportantDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupPptteachercontentimportantEntity ";
        List list=pptTeacherContentImportantDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupPptteachercontentimportantEntity where ddup_pptNo='"+id+"'";
        List list=pptTeacherContentImportantDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupPptteachercontentimportantEntity t){
        {

            DdupPptteachercontentimportantEntity pptTeacherContentImportant = pptTeacherContentImportantDao.findById(t.getDdupTno());
            if (t.getDdupPptNo() != null && !t.getDdupPptNo().equals("")){
                pptTeacherContentImportant.setDdupPptNo(t.getDdupPptNo());
            }
            if (t.getDdupPptPageNum()> 0){
                pptTeacherContentImportant.setDdupPptPageNum(t.getDdupPptPageNum());
            }
            try{
                pptTeacherContentImportantDao.update(pptTeacherContentImportant);
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
    public Boolean delete(DdupPptteachercontentimportantEntity t){
        try{
            pptTeacherContentImportantDao.delete(t);
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
            String hql="from DdupPptteachercontentimportantEntity where ddup_Tno='"+id+"'";
            List list = pptTeacherContentImportantDao.findByHql(hql);
            DdupPptteachercontentimportantEntity Pptteachercontenthard =(DdupPptteachercontentimportantEntity)list.get(0);
            pptTeacherContentImportantDao.delete(Pptteachercontenthard);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupPptteachercontentimportantEntity t){
        {
            String tno = t.getDdupTno();
            //String pptno = t.getDdupPptNo();
            //int pageno = t.getDdupPptPageNum();
            String hql="from DdupPptteachercontentimportantEntity where ddup_Tno='"+tno+"'";
            List list = pptTeacherContentImportantDao.findByHql(hql);
            if(list.isEmpty()){
                System.out.println("成功");
                pptTeacherContentImportantDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
