package com.service;

import com.bean.DdupClassEntity;
import com.dao.classDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class classServiceImpl implements classService{
    private classDao classDao = null;

    public classServiceImpl(){
        System.out.println("create classServiceImpl!");
    }

    public void setClassDao(com.dao.classDao classDao) {
        this.classDao = classDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupClassEntity ";
        List list=classDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupClassEntity where ddup_Cno='"+id+"'";
        List list=classDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupClassEntity t){
        {

            DdupClassEntity DDclass = classDao.findById(t.getDdupCno());
            if (t.getDdupName() != null && !t.getDdupName().equals("")){
                DDclass.setDdupName(t.getDdupName());
            }
            if (t.getDdupName() != null && t.getDdupName().equals("")){
                DDclass.setDdupName(t.getDdupName());
            }
            if (t.getDdupMajor() !=0 ){
                DDclass.setDdupMajor(t.getDdupMajor());
            }

            try{
                classDao.update(DDclass);
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
    public Boolean delete(DdupClassEntity t){
        try{
            classDao.delete(t);
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
            DdupClassEntity DDclass = classDao.findById(id);
            classDao.delete(DDclass);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupClassEntity t){
        {
            String account = t.getDdupCno();
            String hql="from DdupClassEntity where ddup_Cno='"+account+"'";
            List list = classDao.findByHql(hql);
            if(list.isEmpty()){
                classDao.save(t);
                return true;
            }else{
                return false;
            }
        }
    }
}
