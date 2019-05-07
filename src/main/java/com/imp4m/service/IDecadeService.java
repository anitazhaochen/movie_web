package com.imp4m.service;

import com.imp4m.entity.Decade;

import java.util.List;

/**
 * 年代service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:27
 */
public interface IDecadeService {

    String add(Decade decade);

    List<Decade> listIsUse();
}
