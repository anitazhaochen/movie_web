package com.imp4m.service;

import com.imp4m.entity.CataLog;

import java.util.List;


/**
 * 一级目录service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:26
 */
public interface ICataLogService {

    String  add(CataLog cataLog);

    List<CataLog> listIsUse();

    CataLog load(String cataLog_id);

}
