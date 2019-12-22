package com.service;

import com.bean.DdupCourseEntity;
import com.dao.courseDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class courseServiceImpl implements courseService{
    private courseDao courseDao = null;

    public courseServiceImpl(){
        System.out.println("create courseServiceImpl!");
    }

    public void setCourseDao(com.dao.courseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupCourseEntity ";
        List list=courseDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupCourseEntity where ddup_Cno='"+id+"'";
        List list=courseDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupCourseEntity t){
        {

            DdupCourseEntity course = courseDao.findById(t.getDdupCno());
            if (t.getDdupName() != null && !t.getDdupName().equals("")){
                course.setDdupName(t.getDdupName());
            }
            if (t.getDdupCredit() != null && t.getDdupCredit()!=0){
                course.setDdupCredit(t.getDdupCredit());
            }
            if (t.getDdupLearnTime() != null && !t.getDdupLearnTime().equals("")){
                course.setDdupLearnTime(t.getDdupLearnTime());
            }
            if (t.getDdupPeriod() != null && !t.getDdupPeriod().equals("")){
                course.setDdupPeriod(t.getDdupPeriod());
            }
            if (t.getDdupTestMethod() != null && !t.getDdupTestMethod().equals("")){
                course.setDdupTestMethod(t.getDdupTestMethod());
            }

            try{
                courseDao.update(course);
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
    public Boolean delete(DdupCourseEntity t){
        try{
            courseDao.delete(t);
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
            DdupCourseEntity course = courseDao.findById(id);
            courseDao.delete(course);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupCourseEntity t){
        {
            String account = t.getDdupCno();
            String hql="from DdupCourseEntity where ddup_Cno='"+account+"'";
            List list = courseDao.findByHql(hql);
            if(list.isEmpty()){
                courseDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
