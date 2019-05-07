package com.imp4m.service;

import com.imp4m.entity.Raty;

import java.util.List;


/**
 * 评分service接口
 *
 * @author 10589
 * @date 2016/10/8
 * @time 12:52
 */
public interface IRatyService {

    String  add(Raty raty);

    List<Raty> listALLByFilm_id(String film_id);

    int getCountByFilm_id(String film_id);
}
