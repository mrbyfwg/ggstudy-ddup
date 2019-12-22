package com.service;

import com.bean.DdupStudentEntity;
import com.dao.studentDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class studentServiceImpl implements studentService{
    private studentDao studentDao = null;

    public studentServiceImpl(){
        System.out.println("create studentServiceImpl!");
    }

    public void setStudentDao(com.dao.studentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupStudentEntity ";
        List list=studentDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupStudentEntity where ddup_Sno='"+id+"'";
        List list=studentDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupStudentEntity t){
        {

            DdupStudentEntity student = studentDao.findById(t.getDdupSno());
            if (t.getDdupName() != null && !t.getDdupName().equals("")){
                student.setDdupName(t.getDdupName());
            }
            if (t.getDdupAge() != null && t.getDdupAge()!=0){
                student.setDdupAge(t.getDdupAge());
            }
            if (t.getDdupSex() != null && !t.getDdupSex().equals("")){
                student.setDdupSex(t.getDdupSex());
            }
            if (t.getDdupClass() != null && !t.getDdupClass().equals("")){
                student.setDdupClass(t.getDdupClass());
            }
            if (t.getDdupOriginPlace() != null && !t.getDdupOriginPlace().equals("")){
                student.setDdupOriginPlace(t.getDdupOriginPlace());
            }
            try{
                studentDao.update(student);
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
    public Boolean delete(DdupStudentEntity t){
        try{
            studentDao.delete(t);
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
            DdupStudentEntity student = studentDao.findById(id);
            studentDao.delete(student);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupStudentEntity t){
        {
            String account = t.getDdupSno();
            String hql="from DdupStudentEntity where ddup_Sno='"+account+"'";
            List list = studentDao.findByHql(hql);
            if(list.isEmpty()){
                studentDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
