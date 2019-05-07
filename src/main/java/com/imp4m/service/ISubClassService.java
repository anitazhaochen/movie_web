package com.imp4m.service;

import com.imp4m.entity.SubClass;

import java.util.List;

/**
 * 二级目录service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:32
 */
public interface ISubClassService {

    String add(SubClass subClass);

    SubClass load(String subClass_id);

    List<SubClass> listByCataLog_id(String catalog_id);

    List<SubClass> listIsUse(String catalog_id);
}
