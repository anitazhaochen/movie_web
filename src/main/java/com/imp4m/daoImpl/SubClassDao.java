package com.imp4m.daoImpl;

import com.imp4m.dao.ISubClassDao;
import com.imp4m.entity.SubClass;
import com.imp4m.util.BaseDao;
import org.springframework.stereotype.Component;

/**
 * 二级目录dao层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:21
 */
@Component
public class SubClassDao extends BaseDao<SubClass> implements ISubClassDao {
}
