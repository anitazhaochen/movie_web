package com.imp4m.service;

import com.imp4m.entity.Level;

import java.util.List;

/**
 * 级别service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:29
 */
public interface ILevelService {
    String add(Level level);

    List<Level> listIsUse();
}
