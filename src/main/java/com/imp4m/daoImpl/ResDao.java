package com.imp4m.daoImpl;

import com.imp4m.dao.IResDao;
import com.imp4m.entity.Res;
import com.imp4m.util.BaseDao;
import org.springframework.stereotype.Component;

/**
 * 资源dao层接口实现
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:00
 */
@Component
public class ResDao extends BaseDao<Res> implements IResDao{
}
