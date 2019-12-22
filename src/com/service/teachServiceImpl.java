package com.service;

import com.bean.DdupTeachEntity;
import com.dao.teachDao;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class teachServiceImpl implements teachService{
    private teachDao teachDao = null;

    public teachServiceImpl(){
        System.out.println("create teachServiceImpl!");
    }

    public void setTeachDao(com.dao.teachDao teachDao) {
        this.teachDao = teachDao;
    }

    @Override
    @Transactional
    public List findAll(){
        String hql="from DdupTeachEntity ";
        List list=teachDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String tno, String cno, String classno){
        String hql="delete from DdupTeachEntity where ddup_Tno='"+tno+"' AND ddup_Cno='"+cno+"' AND ddup_Classno='"+classno+"'";
        List list=teachDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public Boolean updateInfo(DdupTeachEntity t){
        {
            String hql="from DdupTeachEntity where ddup_Tno='"+t.getDdupTno()+"' AND ddup_Cno='"+t.getDdupCno()+"' AND ddup_Classno='"+t.getDdupClassno()+"'";
            List list= teachDao.findByHql(hql);
            DdupTeachEntity teach = (DdupTeachEntity)list.get(0);
            if (t.getDdupTno() != null && !t.getDdupTno().equals("")){
                teach.setDdupTno(t.getDdupTno());
            }
            if (t.getDdupCno() != null && t.getDdupCno().equals("")){
                teach.setDdupCno(t.getDdupCno());
            }
            if (t.getDdupClassno() != null && !t.getDdupClassno().equals("")){
                teach.setDdupClassno(t.getDdupClassno());
            }
            if (t.getDdupTeachRoomId() != null && !t.getDdupTeachRoomId().equals("")){
                teach.setDdupTeachRoomId(t.getDdupTeachRoomId());
            }
            if (t.getDdupTeachBuildingId() != null && !t.getDdupTeachBuildingId().equals("")){
                teach.setDdupTeachBuildingId(t.getDdupTeachBuildingId());
            }
            try{
                teachDao.update(teach);
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
    public Boolean delete(DdupTeachEntity t){
        try{
            teachDao.delete(t);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean deleteByHql(String tno, String cno, String classno){
        try{
            String hql="from DdupTeachEntity where ddup_Tno='"+tno+"' AND ddup_Cno='"+cno+"' AND ddup_Classno='"+classno+"'";
            List list = teachDao.findByHql(hql);
            DdupTeachEntity teach =(DdupTeachEntity)list.get(0);
//            teachDao.deleteByHql(hql);
            teachDao.delete(teach);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupTeachEntity t){
        {
            String tno = t.getDdupTno();
            String cno = t.getDdupCno();
            String classno = t.getDdupClassno();
            String hql="from DdupTeachEntity where ddup_Tno='"+tno+"' AND ddup_Cno='"+cno+"' AND ddup_Classno='"+classno+"'";
            List list = teachDao.findByHql(hql);
            if(list.isEmpty()){
                teachDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
