package com.imp4m.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 类型
 *
 * @author 10589
 * @date 2016/10/3
 * @time 15:16
 */
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    private String id;//主键id

    private String name;//名称


    private int isUse;//是否在使用

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="subclass_id")
    private SubClass subClass;

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

    public SubClass getSubClass() {
        return subClass;
    }

    public void setSubClass(SubClass subClass) {
        this.subClass = subClass;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isUse=" + isUse +
                ", subClass=" + subClass +
                '}';
    }
}
