
package com.service;

import com.bean.DdupStudentpasswordmanageEntity;
import com.dao.studentPasswordManageDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class studentPasswordManageServiceImpl implements studentPasswordManageService{
    private studentPasswordManageDao studentPasswordManageDao = null;

    public studentPasswordManageServiceImpl(){
        System.out.println("create studentPasswordManageServiceImpl!");
    }

    public void setStudentPasswordManageDao(com.dao.studentPasswordManageDao studentPasswordManageDao) {
        this.studentPasswordManageDao = studentPasswordManageDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupStudentpasswordmanageEntity ";
        List list=studentPasswordManageDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupStudentpasswordmanageEntity where ddup_Sno='"+id+"'";
        List list=studentPasswordManageDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupStudentpasswordmanageEntity t){
        {

            DdupStudentpasswordmanageEntity student = studentPasswordManageDao.findById(t.getDdupSno());
            if (t.getDdupPassword() != null && !t.getDdupPassword().equals("")){
                student.setDdupPassword(t.getDdupPassword());
            }
            try{
                studentPasswordManageDao.update(student);
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
    public Boolean delete(DdupStudentpasswordmanageEntity t){
        try{
            studentPasswordManageDao.delete(t);
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
            DdupStudentpasswordmanageEntity student = studentPasswordManageDao.findById(id);
            studentPasswordManageDao.delete(student);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupStudentpasswordmanageEntity t){
        {
            String account = t.getDdupSno();
            String hql="from DdupStudentpasswordmanageEntity where ddup_Sno='"+account+"'";
            List list = studentPasswordManageDao.findByHql(hql);
            if(list.isEmpty()){
                studentPasswordManageDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
