package com.imp4m.service;

import com.imp4m.entity.Type;

import java.util.List;

/**
 * 类型service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
public interface ITypeService {
    String  add(Type type);

    List<Type> listIsUse();

    List<Type> listBySubClass_id(String subClass_id);

    Type load(String val);

    List<Type> listIsUseBySubClass_id(String subClass_id);
}
