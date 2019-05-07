package com.imp4m.serviceImpl;

import com.imp4m.dao.IResDao;
import com.imp4m.entity.Film;
import com.imp4m.entity.Res;
import com.imp4m.service.IResService;
import com.imp4m.util.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资源service层接口实现
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:08
 */
@Component
public class ResService implements IResService{

    @Resource
    private IResDao resDao;

    @Override
    public String add(Res res) {
        res.setIsUse(1);
        res.setUpdateTime(DateUtil.getTime());
        return resDao.add(res)?res.getId():"0";
    }

    /**
     * 查询该film_id的资源
     * @param film_id
     * @return
     */
    @Override
    public List<Res> listByfilm_id(String film_id) {
        String hql = "from Res where film_id = ?";
        return resDao.list(hql,new Object[]{film_id});
    }

    @Override
    public boolean delete(String res_id) {
        Res res = resDao.load(res_id);
        res.getFilm().getResList().remove(res);
        res.setFilm(null);
        return resDao.delete(res);
    }

    /**
     * 更改在离线
     * @param res_id
     * @return
     */
    @Override
    public boolean updateIsUse(String res_id) {
        Res res = resDao.load(res_id);
        int isUse = res.getIsUse();
        if(isUse==1){
            res.setIsUse(0);
        }else{
            res.setIsUse(1);
        }
        return resDao.update(res);
    }

    @Override
    public List<Res> listByLinkType(String film_id,String linkType) {
        String hql = "from Res where film_id = ? and linkType = ?";
        return resDao.list(hql,new Object[]{film_id,linkType});
    }
}
