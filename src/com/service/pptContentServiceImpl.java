package com.service;

import com.bean.DdupPptcontentEntity;
import com.dao.pptContentDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class pptContentServiceImpl implements pptContentService {
    private pptContentDao pptContentDao = null;

    public pptContentServiceImpl(){
        System.out.println("create PptContentServiceImpl!");
    }

    public void setPptContentDao(pptContentDao pptContentDao) {
        this.pptContentDao = pptContentDao;
    }

    @Override
    @Transactional
    public Boolean updateById(DdupPptcontentEntity t){
        {
            DdupPptcontentEntity pptContent = new DdupPptcontentEntity();
            System.out.println("Service Begin");
            List list = findById(t.getDdupPptNo());
            for(int i=0; i<list.size(); i++){
                pptContent = (DdupPptcontentEntity) list.get(i);
                if(pptContent.getDdupPptPageNum() == t.getDdupPptPageNum()){
                    break;
                }
            }
            try{
                pptContentDao.update(pptContent);
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
    public List findAll(){
        String hql="from DdupPptcontentEntity ";
        List list=pptContentDao.findByHql(hql);
        return list;
    }
    @Override
    @Transactional
    public List findById(String id){
        String hql="from DdupPptcontentEntity where ddup_pptNo='"+id+"'";
        List list=pptContentDao.findByHql(hql);
        return list;
    }

    @Override
    @Transactional
    public List findByHql(String pptno, int pageno){
        String hql="from DdupPptcontentEntity where ddup_pptNo='"+pptno+"' and ddup_pptPageNum='"+ pageno+"'";
        List list=pptContentDao.findByHql(hql);
        return list;
    }


    @Override
    @Transactional
    public Boolean updateInfo(DdupPptcontentEntity t){
        {
            System.out.println("Service Begin");
            DdupPptcontentEntity PptContent = pptContentDao.findById(t.getDdupPptNo());
            if (t.getDdupPptPageNum()!=0){
                PptContent.setDdupPptPageNum(t.getDdupPptPageNum());
            }

            if (t.getDdupPptImportant() != null && t.getDdupPptImportant()!=0){
                PptContent.setDdupPptImportant(t.getDdupPptImportant());
            }
            if (t.getDdupPptHard() != null && t.getDdupPptHard()!=0){
                PptContent.setDdupPptHard(t.getDdupPptHard());
            }
            if (t.getDdupPptImportantHard() != null && t.getDdupPptImportantHard()!=0){
                PptContent.setDdupPptImportantHard(t.getDdupPptImportantHard());
            }
            if (t.getDdupPptQuestionNum() != null && t.getDdupPptQuestionNum()!=0){
                PptContent.setDdupPptQuestionNum(t.getDdupPptQuestionNum());
            }

            try{
                pptContentDao.update(PptContent);
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
    public Boolean delete(DdupPptcontentEntity t){
        try{
            pptContentDao.delete(t);
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
            DdupPptcontentEntity PptContent = pptContentDao.findById(id);
            pptContentDao.delete(PptContent);
            System.out.println("删除成功");
            return true;
        }catch(Exception e){
            System.out.println("删除失败");
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean add(DdupPptcontentEntity t){
        {
            String account = t.getDdupPptNo();
            String hql="from DdupPptcontentEntity where ddup_pptNo='"+account+"'";
            List list = pptContentDao.findByHql(hql);
            if(list.isEmpty()){
                pptContentDao.save(t);
                return true;
            }else{

                return false;
            }
        }
    }
}
