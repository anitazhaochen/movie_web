package com.imp4m.serviceImpl;

import com.imp4m.dao.IVipCodeDao;
import com.imp4m.entity.VipCode;
import com.imp4m.service.IVipCodeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类型service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
@Component
public class VipCodeService implements IVipCodeService {
    @Resource
    private IVipCodeDao vipCodeDao;

    @Override
    public String add(VipCode vipCode) {
        return vipCodeDao.add(vipCode)?vipCode.getId():"0";
    }

    @Override
    public List<VipCode> listIsUse() {
        String hql = "from VipCode where is_use = ?";
        return vipCodeDao.list(hql,new Object[]{"1"});
    }

    @Override
    public VipCode load(String val) {
        return vipCodeDao.load(val);
    }

    @Override
    public int saveAll(List<VipCode> vipCodes) {
        int count=0;
        for (int i = 0; i < vipCodes.size(); i++) {
            try {
                vipCodeDao.add(vipCodes.get(i));
                count++;
            }catch (Exception e){
                //不理会
            }
        }
        return count;
    }

    @Override
    public VipCode findByVipCode(String code) {
        String hql = "from VipCode where is_use = ? and code = ?";
        return vipCodeDao.load(hql,new Object[]{"1",code});
    }

    @Override
    public boolean update(VipCode vipCode) {
        return vipCodeDao.update(vipCode);
    }
}
