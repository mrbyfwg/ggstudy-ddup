package com.service;

import com.bean.DdupPptteachercontentimportanthardEntity;
import com.dao.pptTeacherContentImportantHardDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class pptTeacherContentImportantHardServiceImpl implements pptTeacherContentImportantHardService{
    private com.dao.pptTeacherContentImportantHardDao pptTeacherContentImportantHardDao = null;

    public pptTeacherContentImportantHardServiceImpl(){
        System.out.println("create pptTeacherContentImportantHardServiceImpl!");
    }

    public void setPptTeacherContentImportantHardDao(com.dao.pptTeacherContentImportantHardDao pptTeacherContentImportantHardDao) {
        this.pptTeacherContentImportantHardDao = pptTeacherContentImportantHardDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupPptteachercontentimportanthardEntity ";
        List list=pptTeacherContentImportantHardDao.findByHql(hql);
        return list;
    }

    @Override
    @Transactional
    public List findByHql(String tno, String pptno, int pageno){
        String hql="from DdupPptteachercontentimportanthardEntity where ddup_Tno='"+tno+"' AND ddup_pptNo='"+pptno+"' AND ddup_pptPageNum='"+pageno+"'";
        List list=pptTeacherContentImportantHardDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupPptteachercontentimportanthardEntity where ddup_pptNo='"+id+"'";
        List list=pptTeacherContentImportantHardDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupPptteachercontentimportanthardEntity t){
        {

            DdupPptteachercontentimportanthardEntity pptTeacherContentImportantHard = pptTeacherContentImportantHardDao.findById(t.getDdupTno());
            if (t.getDdupPptNo() != null && !t.getDdupPptNo().equals("")){
                pptTeacherContentImportantHard.setDdupPptNo(t.getDdupPptNo());
            }
            if (t.getDdupPptPageNum()> 0){
                pptTeacherContentImportantHard.setDdupPptPageNum(t.getDdupPptPageNum());
            }
            try{
                pptTeacherContentImportantHardDao.update(pptTeacherContentImportantHard);
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
    public Boolean delete(DdupPptteachercontentimportanthardEntity t){
        try{
            pptTeacherContentImportantHardDao.delete(t);
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
            String hql="from DdupPptteachercontentimportanthardEntity where ddup_Tno='"+id+"'";
            List list = pptTeacherContentImportantHardDao.findByHql(hql);
            DdupPptteachercontentimportanthardEntity Pptteachercontenthard =(DdupPptteachercontentimportanthardEntity)list.get(0);
            pptTeacherContentImportantHardDao.delete(Pptteachercontenthard);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }

    public com.dao.pptTeacherContentImportantHardDao getPptTeacherContentImportantHardDao() {
        return pptTeacherContentImportantHardDao;
    }

    @Override
    @Transactional
    public Boolean add(DdupPptteachercontentimportanthardEntity t){
        {
            String account1 = t.getDdupTno();
            //String account2 = t.getDdupPptNo();
            //String account3 = String.valueOf(t.getDdupPptPageNum());
            String hql="from DdupPptteachercontentimportanthardEntity where ddup_tno='"+account1+"'";
            List list = pptTeacherContentImportantHardDao.findByHql(hql);
            if(list.isEmpty()){
                pptTeacherContentImportantHardDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }

}
