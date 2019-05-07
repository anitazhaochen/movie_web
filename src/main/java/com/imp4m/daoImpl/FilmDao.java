package com.imp4m.daoImpl;

import com.imp4m.dao.IFilmDao;
import com.imp4m.entity.Film;
import com.imp4m.util.BaseDao;
import org.springframework.stereotype.Component;

/**
 * 影片dao层接口实现
 *
 * @author 10589
 * @date 2016/10/4
 * @time 11:59
 */
@Component
public class FilmDao extends BaseDao<Film> implements IFilmDao {
}
