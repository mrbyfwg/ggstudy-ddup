package com.service;

import com.bean.DdupPptmanageEntity;
import com.dao.pptManageDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public class pptManageServiceImpl implements pptManageService{
    private pptManageDao pptManageDao = null;

    public pptManageServiceImpl(){
        System.out.println("create teacherServiceImpl!");
    }

    public void setPptManageDao(com.dao.pptManageDao pptManageDao) {
        this.pptManageDao = pptManageDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupPptmanageEntity ";
        List list=pptManageDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupPptmanageEntity where ddup_pptNo='"+id+"'";
        List list=pptManageDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupPptmanageEntity t){
        {

            DdupPptmanageEntity pptManage = pptManageDao.findById(t.getDdupPptNo());
            if (t.getDdupName() != null && !t.getDdupName().equals("")){
                pptManage.setDdupName(t.getDdupName());
            }
            if (t.getDdupPptPageNum() != null && t.getDdupPptPageNum()!=0){
                pptManage.setDdupPptPageNum(t.getDdupPptPageNum());
            }
            if (t.getDdupPptDownloadNum() != null && t.getDdupPptDownloadNum()!=0){
                pptManage.setDdupPptDownloadNum(t.getDdupPptDownloadNum());
            }
            try{
                pptManageDao.update(pptManage);
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
    public Boolean delete(DdupPptmanageEntity t){
        try{
            pptManageDao.delete(t);
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
            DdupPptmanageEntity teacher = pptManageDao.findById(id);
            pptManageDao.delete(teacher);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupPptmanageEntity t){
        {
            String account = t.getDdupPptNo();
            String hql="from DdupPptmanageEntity where ddup_pptNo='"+account+"'";
            List list = pptManageDao.findByHql(hql);
            if(list.isEmpty()){
                pptManageDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
