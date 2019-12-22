package com.service;

import com.bean.DdupHomeworkEntity;
import com.dao.HomeworkDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HomeworkServiceImpl implements HomeworkService{
    private HomeworkDao homeworkDao = null;

    public HomeworkServiceImpl(){
        System.out.println("create HomeworkServiceImpl!");
    }

    public com.dao.HomeworkDao getHomeworkDao() {
        return homeworkDao;
    }

    public void setHomeworkDao(com.dao.HomeworkDao homeworkDao) {
        this.homeworkDao = homeworkDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupHomeworkEntity ";
        List list=homeworkDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupHomeworkEntity where ddup_homeworkNum='"+id+"'";
        List list=homeworkDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupHomeworkEntity t){
        {
            String hql="from DdupHomeworkEntity where ddup_homeworkNum='"+t.getDdupHomeworkNum()+"'";
            List list=homeworkDao.findByHql(hql);
            DdupHomeworkEntity homework =(DdupHomeworkEntity)list.get(0);
            if (t.getDdupHomeworkName() != null && !t.getDdupHomeworkName().equals("")){
                homework.setDdupHomeworkName(t.getDdupHomeworkName());
            }
            if (t.getDdupCno() != null && t.getDdupCno().equals("")){
                homework.setDdupCno(t.getDdupCno());
            }
            if (t.getDdupStartTime() != null && !t.getDdupStartTime().equals("")){
                homework.setDdupStartTime(t.getDdupStartTime());
            }
            if (t.getDdupEndTime() != null && !t.getDdupEndTime().equals("")){
                homework.setDdupEndTime(t.getDdupEndTime());
            }
            if (t.getDdupSubmitNum() != null && !t.getDdupSubmitNum().equals("")){
                homework.setDdupSubmitNum(t.getDdupSubmitNum());
            }
            try{
                homeworkDao.update(homework);
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
    public Boolean delete(DdupHomeworkEntity t){
        try{
            homeworkDao.delete(t);
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
            String hql="from DdupHomeworkEntity where ddup_homeworkNum='"+id+"'";
            List list=homeworkDao.findByHql(hql);
            DdupHomeworkEntity homework =(DdupHomeworkEntity)list.get(0);
            homeworkDao.delete(homework);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupHomeworkEntity t){
        {
            String account = t.getDdupHomeworkNum();
            String hql="from DdupHomeworkEntity where ddup_homeworkNum='"+account+"'";
            List list = homeworkDao.findByHql(hql);
            if(list.isEmpty()){
                homeworkDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
