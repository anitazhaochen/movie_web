package com.imp4m.serviceImpl;

import com.imp4m.dao.ICataLogDao;
import com.imp4m.dao.IFilmDao;
import com.imp4m.dao.ISubClassDao;
import com.imp4m.dao.ITypeDao;
import com.imp4m.entity.Film;
import com.imp4m.entity.Type;
import com.imp4m.service.IFilmService;
import com.imp4m.util.DateUtil;
import com.imp4m.util.PageBean;
import com.imp4m.util.Tools;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 影片service层接口实现
 *
 * @author 10589
 * @date 2016/10/4
 * @time 12:06
 */
@Component
public class FilmService implements IFilmService{
    @Resource
    private IFilmDao filmDao;


    @Resource
    private ITypeDao typeDao;


    @Override
    public String add(Film film) {
        /**
         * 初始化参数
         */
        film.setIsUse(1);
        film.setUpdateTime(DateUtil.getTime());
        film.setEvaluation(0);

        /**
         * 查询出类型
         */
        Type type  =typeDao.load(film.getType_id());
        film.setSubClass_id(type.getSubClass().getId());
        film.setSubClassName(type.getSubClass().getName());
        film.setCataLog_id(type.getSubClass().getCataLog().getId());
        film.setCataLogName(type.getSubClass().getCataLog().getName());

        return filmDao.add(film)?film.getId():"0";
    }

    @Override
    public Film load(String film_id) {
        return filmDao.load(film_id);
    }

    /**
     * 更改信息
     * @param film
     * @return
     */
    @Override
    public boolean update(Film film) {
        return filmDao.update(film);
    }

    /**
     * 在线影片分页
     * @param ob
     * @param pc
     * @param ps
     * @return
     */
    @Override
    public PageBean<Film> getPage(Film ob, int pc, int ps) {

        /**
         *
         *需要修该 5 个地方
         */



        /**需要修改的对象*/
        String obName = "Film";                                    /**1.修改*/


        /**
         * 1. 给出基本的sql语句
         */
        StringBuilder where = new StringBuilder("where 1=1");

        /**
         * 2. 创建List，用来保存参数
         */
        List<Object> params = new ArrayList<Object>();

        /**(
         * 3. 判断c中每个字段是否存在，如果存在说明有这个条件，如果不存在就没有这个条件
         */
        /**=========================有条件则加范围===============================*/     /**2.修改*/  //有条件则加,无条件不加
        if(ob!=null){
            String name = ob.getName();
            if(Tools.notEmpty(name)) {
                where.append(" and name like ?");
                params.add("%" + name + "%");
            }

            String actor = ob.getActor();
            if(Tools.notEmpty(actor)) {
                where.append(" and actor like ?");
                params.add("%" + actor + "%");
            }


            String cataLog_id = ob.getCataLog_id();
            if(Tools.notEmpty(cataLog_id)) {
                where.append(" and cataLog_id = ?");
                params.add(cataLog_id);
            }


            String subClass_id = ob.getSubClass_id();
            if(Tools.notEmpty(subClass_id)) {
                where.append(" and subClass_id = ?");
                params.add(subClass_id);
            }

            String onDecade = ob.getOnDecade();
            if(Tools.notEmpty(onDecade)) {
                where.append(" and onDecade = ?");
                params.add(onDecade);
            }

            String type_id = ob.getType_id();
            if(Tools.notEmpty(type_id)) {
                where.append(" and type_id = ?");
                params.add(type_id);
            }

            String loc_id = ob.getLoc_id();
            if(Tools.notEmpty(loc_id)) {
                where.append(" and loc_id = ?");
                params.add(loc_id);
            }

            double  evaluation = ob.getEvaluation();
            if(Tools.notEmpty(loc_id)) {
                where.append(" and evaluation = ?");
                params.add(evaluation);
            }
        }

        where.append(" order by updateTime desc");
        /**=========================有条件则加范围===============================*/


        /**
         * 得到count的sql语句
         */
        StringBuilder countSql = new StringBuilder("select count(*) from "+obName);
        String hql = countSql.append(" ").append(where).toString();



        /**
         * 查询当前页的记录
         * 头 + where + limit
         */
        StringBuilder selectSql = new StringBuilder("from "+obName);


        /**=========================修改对应对象===============================*/
        PageBean<Film> pb = new PageBean<Film>();                                             /**3.修改*/
        pb.setPc(pc);
        pb.setPs(ps);
        pb.setTr(filmDao.getTotalCount(hql,params.toArray()));                                  /**4.修改*/
        pb.setBeanList(filmDao.getPage(selectSql.append(" ").append(where).toString(),params.toArray(),(pc-1)*ps,ps));          /**5.修改*/
        return pb;
    }

    /**
     * 通过type_id查询影片
     * @param type_id
     * @return
     */
    @Override
    public List<Film> listByType_id(String type_id) {
        String hql="from Film where type_id = ?";
        return filmDao.list(hql,new Object[]{type_id});
    }

    @Override
    public List<Film> listByCataLog_id(String id) {
        String hql = "from Film where isUse = ? and cataLog_id = ? order by updateTime desc";
        return filmDao.getPage(hql,new Object[]{1,id},0,12);
    }

    @Override
    public List<Film> listByEvaluation(String id) {
        String hql = "from Film where isUse = ? and cataLog_id = ? order by evaluation desc";
        return filmDao.getPage(hql,new Object[]{1,id},0,13);
    }

    @Override
    public int getCountAll() {
        return filmDao.getTotalCount();
    }

    @Override
    public int getCountByCataLog(String id) {
        String hql = "select count(*) from Film where isUse = ? and cataLog_id = ?";
        return filmDao.getTotalCount(hql,new Object[]{1,id});
    }
}
