package com.imp4m.service;

import com.imp4m.entity.VipCode;

import java.util.List;

/**
 * 类型service层接口
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
public interface IVipCodeService {

    String  add(VipCode vipCode);

    List<VipCode> listIsUse();

    VipCode load(String val);

    int saveAll(List<VipCode> vipCodes);

    VipCode findByVipCode(String code);

    boolean update(VipCode vipCode);
}
