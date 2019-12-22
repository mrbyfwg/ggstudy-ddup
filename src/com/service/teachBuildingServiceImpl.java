
package com.service;

import com.bean.DdupTeachbuildingEntity;
import com.dao.teachBuildingDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class teachBuildingServiceImpl implements teachBuildingService{
    public com.dao.teachBuildingDao getTeachBuildingDao() {
        return teachBuildingDao;
    }

    public void setTeachBuildingDao(com.dao.teachBuildingDao teachBuildingDao) {
        this.teachBuildingDao = teachBuildingDao;
    }

    private teachBuildingDao teachBuildingDao = null;

    public teachBuildingServiceImpl(){
        System.out.println("create teachBuildingServiceImpl!");
    }

    public void teachBuildingDao(com.dao.teachBuildingDao teachBuildingDao) {
        this.teachBuildingDao = teachBuildingDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupTeachbuildingEntity ";
        List list=teachBuildingDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupTeachbuildingEntity where ddup_teachBuildingID='"+id+"'";
        List list=teachBuildingDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupTeachbuildingEntity t){
        {

            DdupTeachbuildingEntity student = teachBuildingDao.findById(t.getDdupTeachBuildingId());
            if (t.getDdupTeachBuildingName() != null && !t.getDdupTeachBuildingName().equals("")){
                student.setDdupTeachBuildingName(t.getDdupTeachBuildingName());
            }
            try{
                teachBuildingDao.update(student);
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
    public Boolean delete(DdupTeachbuildingEntity t){
        try{
            teachBuildingDao.delete(t);
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
            DdupTeachbuildingEntity student = teachBuildingDao.findById(id);
            teachBuildingDao.delete(student);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupTeachbuildingEntity t){
        {
            String account = t.getDdupTeachBuildingId();
            String hql="from DdupTeachbuildingEntity where ddup_teachBuildingID='"+account+"'";
            List list = teachBuildingDao.findByHql(hql);
            if(list.isEmpty()){
                teachBuildingDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
