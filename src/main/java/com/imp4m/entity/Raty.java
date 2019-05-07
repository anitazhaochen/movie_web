package com.imp4m.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评分实体
 *
 * @author 10589
 * @date 2016/10/8
 * @time 12:48
 */
@Entity
@Table(name = "t_raty")
public class Raty {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    private String id;//主键id

    private String film_id;//影片id

    private String score;//评分

    private String enTime;//评分时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilm_id() {
        return film_id;
    }

    public void setFilm_id(String film_id) {
        this.film_id = film_id;
    }

    public String getEnTime() {
        return enTime;
    }

    public void setEnTime(String enTime) {
        this.enTime = enTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Raty{" +
                "id='" + id + '\'' +
                ", film_id='" + film_id + '\'' +
                ", score='" + score + '\'' +
                ", enTime='" + enTime + '\'' +
                '}';
    }
}
