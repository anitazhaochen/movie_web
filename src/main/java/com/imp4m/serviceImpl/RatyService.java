package com.imp4m.serviceImpl;

import com.imp4m.dao.IRatyDao;
import com.imp4m.entity.Raty;
import com.imp4m.service.IRatyService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评分service层接口实现
 *
 * @author 10589
 * @date 2016/10/8
 * @time 12:52
 */
@Component
public class RatyService implements IRatyService{
    @Resource
    private IRatyDao ratyDao;

    @Override
    public String add(Raty raty) {

        return ratyDao.add(raty)?raty.getId():"0";
    }

    @Override
    public List<Raty> listALLByFilm_id(String film_id) {
        String hql = "from Raty where film_id = ?";
        return ratyDao.list(hql,film_id);
    }

    @Override
    public int getCountByFilm_id(String film_id) {
        String hql = "select count(*)from Raty where film_id = ?";
        return ratyDao.getTotalCount(hql,new Object[]{film_id});
    }
}
