package com.imp4m.serviceImpl;

import com.imp4m.dao.ILevelDao;
import com.imp4m.entity.Level;
import com.imp4m.service.ILevelService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 级别service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:29
 */
@Component
public class LevelService implements ILevelService {
    @Resource
    private ILevelDao levelDao;

    /**
     * 添加级别
     * @param level
     * @return
     */
    @Override
    public String add(Level level) {
        return levelDao.add(level)?level.getId():"0";
    }


    /**
     * 查询在使用的界别类型
     * @return
     */
    @Override
    public List<Level> listIsUse() {
        String hql = "from Level where isUse = ?";
        return levelDao.list(hql,new Object[]{1});
    }
}
