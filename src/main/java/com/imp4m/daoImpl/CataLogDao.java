package com.imp4m.daoImpl;

import com.imp4m.dao.ICataLogDao;
import com.imp4m.entity.CataLog;
import com.imp4m.util.BaseDao;
import org.springframework.stereotype.Component;

/**
 * 一级目录接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:10
 */
@Component
public class CataLogDao extends BaseDao<CataLog> implements ICataLogDao {
}
