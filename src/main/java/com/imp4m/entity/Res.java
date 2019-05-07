package com.imp4m.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 资源
 *
 * @author 10589
 * @date 2016/10/4
 * @time 11:29
 */
@Entity
@Table(name = "t_res")
public class Res {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    private String id;//主键id

    @Lob
    @Column(columnDefinition="TEXT", nullable=true)
    private String name;//资源名称

    private int episodes;//集

    @Lob
    @Column(columnDefinition="TEXT", nullable=true)
    private String link;//资源链接

    private String linkType;//链接类型

    private String updateTime;//更新时间

    private int isUse;//是否在使用

    @ManyToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    private Film film;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "Res{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", episodes=" + episodes +
                ", link='" + link + '\'' +
                ", linkType='" + linkType + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isUse=" + isUse +
                ", film=" + film +
                '}';
    }
}
