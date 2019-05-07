package com.imp4m.serviceImpl;

import com.imp4m.dao.ICataLogDao;
import com.imp4m.entity.CataLog;
import com.imp4m.service.ICataLogService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 一级目录service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:27
 */
@Component
public class CataLogService implements ICataLogService {

    @Resource
    private ICataLogDao cataLogDao;

    /**
     * 添加一级目录
     * @param cataLog
     * @return
     */
    @Override
    public String add(CataLog cataLog) {
        return cataLogDao.add(cataLog)?cataLog.getId():"0";
    }

    /**
     * 查询所有在使用的一级目录
     * @return
     */
    @Override
    public List<CataLog> listIsUse() {
        String hql ="from CataLog where isUse = ?";
        return cataLogDao.list(hql,1);
    }

    @Override
    public CataLog load(String cataLog_id) {
        return cataLogDao.load(cataLog_id);
    }
}
