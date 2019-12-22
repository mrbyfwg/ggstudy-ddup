package com.service;

import com.bean.DdupMajorEntity;
import com.dao.majorDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class majorServiceImpl implements majorService{
    private majorDao majorDao = null;

    public majorServiceImpl(){
        System.out.println("create majorServiceImpl!");
    }

    public void setMajorDao(com.dao.majorDao majorDao) {
        this.majorDao = majorDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupMajorEntity ";
        List list=majorDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(int id){
        String hql="from DdupMajorEntity where ddup_id='"+id+"'";
        List list=majorDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupMajorEntity t){
        {

            DdupMajorEntity major = majorDao.findById(t.getDdupId());
            if (t.getDdupName() != null && !t.getDdupName().equals("")){
                major.setDdupName(t.getDdupName());
            }
            if (t.getDdupName() != null && t.getDdupName().equals("")){
                major.setDdupName(t.getDdupName());
            }
            try{
                majorDao.update(major);
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
    public Boolean delete(DdupMajorEntity t){
        try{
            majorDao.delete(t);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean deleteById(int id){
        try{
            DdupMajorEntity major = majorDao.findById(id);
            majorDao.delete(major);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupMajorEntity t){
        {
            int account = t.getDdupId();
            String hql="from DdupMajorEntity where ddup_id='"+account+"'";
            List list = majorDao.findByHql(hql);
            if(list.isEmpty()){
                majorDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
