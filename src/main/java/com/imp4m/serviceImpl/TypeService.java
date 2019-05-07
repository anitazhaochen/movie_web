package com.imp4m.serviceImpl;

import com.imp4m.dao.ITypeDao;
import com.imp4m.entity.Type;
import com.imp4m.service.ITypeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类型service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
@Component
public class TypeService implements ITypeService {
    @Resource
    private ITypeDao typeDao;

    @Override
    public String add(Type type) {
        return typeDao.add(type)?type.getId():"0";
    }

    @Override
    public List<Type> listIsUse() {
        String hql = "from Type where isUse = ?";
        return typeDao.list(hql,new Object[]{1});
    }

    @Override
    public List<Type> listBySubClass_id(String subClass_id) {
        String hql = "from Type where subclass_id = ?";
        return typeDao.list(hql,new Object[]{subClass_id});
    }

    @Override
    public Type load(String val) {
        return typeDao.load(val);
    }

    @Override
    public List<Type> listIsUseBySubClass_id(String subClass_id) {
        String hql = "from Type where subclass_id = ? and isUse = ?";
        return typeDao.list(hql,new Object[]{subClass_id,1});
    }
}
