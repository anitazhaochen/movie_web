package com.imp4m.daoImpl;

import com.imp4m.dao.ITypeDao;
import com.imp4m.entity.Type;
import com.imp4m.util.BaseDao;
import org.springframework.stereotype.Component;

/**
 * 类型dao层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:23
 */
@Component
public class TypeDao extends BaseDao<Type> implements ITypeDao {
}
