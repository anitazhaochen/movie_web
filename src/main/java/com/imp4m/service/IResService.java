package com.imp4m.service;

import com.imp4m.entity.Res;

import java.util.List;

/**
 * 资源service层接口
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:07
 */
public interface IResService {
    String add(Res res);

    List<Res> listByfilm_id(String film_id);

    boolean delete(String res_id);

    boolean updateIsUse(String res_id);

    List<Res> listByLinkType(String film_id,String linkType);
}
