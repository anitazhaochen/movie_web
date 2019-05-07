package com.imp4m.service;

import com.imp4m.entity.Film;
import com.imp4m.util.PageBean;

import java.util.List;

/**
 * 影片service层接口
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:05
 */
public interface IFilmService {
    String add(Film film);

    Film load(String film_id);

    boolean update(Film film);

    PageBean<Film> getPage(Film ob, int pc, int ps);

    List<Film> listByType_id(String type_id);

    List<Film> listByCataLog_id(String id);

    List<Film> listByEvaluation(String id);

    int getCountAll();

    int getCountByCataLog(String id);
}
