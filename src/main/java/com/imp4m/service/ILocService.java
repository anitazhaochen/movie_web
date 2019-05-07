package com.imp4m.service;

import com.imp4m.entity.Loc;

import java.util.List;

/**
 * 地区service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:30
 */
public interface ILocService {
    String add(Loc loc);

    List<Loc> listIsUse();
}
