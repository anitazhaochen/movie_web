package com.imp4m.serviceImpl;

import com.imp4m.dao.ILocDao;
import com.imp4m.entity.Loc;
import com.imp4m.service.ILocService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地区service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:31
 */
@Component
public class LocService implements ILocService {

    @Resource
    private ILocDao locDao;

    @Override
    public String add(Loc loc) {
        return locDao.add(loc)?loc.getId():"0";
    }

    @Override
    public List<Loc> listIsUse() {
        String hql = "from Loc where isUse = ?";
        return locDao.list(hql,new Object[]{1});
    }
}
