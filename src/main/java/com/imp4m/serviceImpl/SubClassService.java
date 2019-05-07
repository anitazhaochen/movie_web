package com.imp4m.serviceImpl;

import com.imp4m.dao.ISubClassDao;
import com.imp4m.entity.SubClass;
import com.imp4m.service.ISubClassService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 二级目录service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:33
 */
@Component
public class SubClassService implements ISubClassService {


    @Resource
    private ISubClassDao subClassDao;


    @Override
    public String add(SubClass subClass) {
        return subClassDao.add(subClass)?subClass.getId():"0";
    }

    @Override
    public SubClass load(String subClass_id) {
        return subClassDao.load(subClass_id);
    }

    @Override
    public List<SubClass> listByCataLog_id(String catalog_id) {
        String hql = "from SubClass where catalog_id = ?";
        return subClassDao.list(hql,new Object[]{catalog_id});
    }

    @Override
    public List<SubClass> listIsUse(String cataLog_id) {
        String hql ="from SubClass where isUse = ? and cataLog_id = ?";
        return subClassDao.list(hql,new Object[]{1,cataLog_id});
    }
}
