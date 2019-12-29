package com.service;

import com.bean.DdupPptteachercontenthardEntity;
import com.dao.pptTeacherContentHardDao;
import com.dao.pptTeacherContentHardDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class pptTeacherContentHardServiceImpl implements pptTeacherContentHardService {
    private pptTeacherContentHardDao pptTeacherContentHardDao = null;

    public pptTeacherContentHardServiceImpl(){
        System.out.println("create pptTeacherContentHardServiceImpl!");
    }

    public void setPptTeacherContentHardDao(com.dao.pptTeacherContentHardDao pptTeacherContentHardDao) {
        this.pptTeacherContentHardDao = pptTeacherContentHardDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupPptteachercontenthardEntity ";
        List list=pptTeacherContentHardDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupPptteachercontenthardEntity where ddup_pptNo='"+id+"'";
        List list=pptTeacherContentHardDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findByHql(String tno, String pptno, int pageno){
        String hql="from DdupPptteachercontenthardEntity where ddup_Tno='"+tno+"' AND ddup_pptNo='"+pptno+"' AND ddup_pptPageNum='"+pageno+"'";
        List list=pptTeacherContentHardDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupPptteachercontenthardEntity t){
        {

            DdupPptteachercontenthardEntity pptTeacherContentHard = pptTeacherContentHardDao.findById(t.getDdupTno());
            if (t.getDdupPptNo() != null && !t.getDdupPptNo().equals("")){
                pptTeacherContentHard.setDdupPptNo(t.getDdupPptNo());
            }
            if (t.getDdupPptPageNum()> 0){
                pptTeacherContentHard.setDdupPptPageNum(t.getDdupPptPageNum());
            }
            try{
                pptTeacherContentHardDao.update(pptTeacherContentHard);
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
    public Boolean delete(DdupPptteachercontenthardEntity t){
        try{
            pptTeacherContentHardDao.delete(t);
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
            String hql="from DdupPptteachercontenthardEntity where ddup_tno='"+id+"'";
            List list = pptTeacherContentHardDao.findByHql(hql);
            DdupPptteachercontenthardEntity Pptteachercontenthard =(DdupPptteachercontenthardEntity)list.get(0);
            pptTeacherContentHardDao.delete(Pptteachercontenthard);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupPptteachercontenthardEntity t){
        {
            String tno = t.getDdupTno();
            //String pptno = t.getDdupPptNo();
            //int pageno = t.getDdupPptPageNum();
            String hql="from DdupPptteachercontenthardEntity where ddup_Tno='"+tno+"'";
            List list = pptTeacherContentHardDao.findByHql(hql);
            if(list.isEmpty()){
                System.out.println("成功");
                pptTeacherContentHardDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }

}
