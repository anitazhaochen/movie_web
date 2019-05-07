package com.imp4m.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 一级分类目录
 * @author 10589
 * @date 2016/10/3
 * @time 14:27
 */
@Entity
@Table(name = "t_catalog")
public class CataLog {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    private String id;//主键id

    private String name;//名称

    private int isUse;//是否在使用 1：使用 2：未使用

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cataLog", fetch = FetchType.EAGER, targetEntity = SubClass.class)
    private List<SubClass> subClassList;



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

    public List<SubClass> getSubClassList() {
        return subClassList;
    }

    public void setSubClassList(List<SubClass> subClassList) {
        this.subClassList = subClassList;
    }


    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "CataLog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isUse=" + isUse +
                ", subClassList=" + subClassList +
                '}';
    }
}
