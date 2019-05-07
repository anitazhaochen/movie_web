package com.imp4m.serviceImpl;

import com.imp4m.dao.IDecadeDao;
import com.imp4m.entity.Decade;
import com.imp4m.service.IDecadeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 年代service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:28
 */
@Component
public class DecadeService implements IDecadeService {

    @Resource
    private IDecadeDao decadeDao;

    /**
     * 添加年代信息
     * @param decade
     * @return
     */
    @Override
    public String add(Decade decade) {
        return decadeDao.add(decade)?decade.getId():"0";
    }

    /**
     * 查询在使用的年代
     * @return
     */
    @Override
    public List<Decade> listIsUse() {
        String hql = "from Decade where isUse = ? order by name desc";
        return decadeDao.list(hql,new Object[]{1});
    }


}
