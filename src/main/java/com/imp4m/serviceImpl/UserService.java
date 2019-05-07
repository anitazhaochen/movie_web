package com.imp4m.serviceImpl;

import com.imp4m.dao.IUserDao;
import com.imp4m.entity.User;
import com.imp4m.service.IUserService;
import com.imp4m.util.Tools;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 类型service层接口实现
 *
 * @author 10589
 * @date 2016/10/3
 * @time 18:25
 */
@Component
public class UserService implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public User add(User user) {
        return userDao.add(user)?user:null;
    }

    @Override
    public List<User> listIsUse() {
        String hql = "from User where is_use = ?";
        return userDao.list(hql,new Object[]{"1"});
    }

    @Override
    public User load(String val) {
        return userDao.load(val);
    }

    @Override
    public int saveAll(List<User> users) {
        int count=0;
        for (int i = 0; i < users.size(); i++) {
            try {
                userDao.add(users.get(i));
                count++;
            }catch (Exception e){
                //不理会
            }
        }
        return count;
    }

    @Override
    public List<User> findByCondition(User user) {
        StringBuilder hql = new StringBuilder("from User where 1=1 ");
        List<Object> objects = new ArrayList<>();

        if(Tools.notEmpty(user.getUserName())){
            hql.append("and userName =?");
            objects.add(user.getUserName());
        }
        if(Tools.notEmpty(user.getUserEmail())){
            hql.append("and userEmail =?");
            objects.add(user.getUserEmail());
        }
        return userDao.list(hql.toString(),objects.toArray());
    }

    @Override
    public Boolean update(User user) {
        return userDao.update(user);
    }
}
