package com.imp4m.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 二级子类目录
 * @author 10589
 * @date 2016/10/3
 * @time 15:12
 */
@Entity
@Table(name = "t_subclass")
public class SubClass {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    private String id;//主键id

    private String name;//名称

    private int isUse;//是否在使用

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="catalog_id")
    private CataLog cataLog;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subClass", fetch = FetchType.LAZY, targetEntity = Type.class)
    private List<Type> types;

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

    public CataLog getCataLog() {
        return cataLog;
    }

    public void setCataLog(CataLog cataLog) {
        this.cataLog = cataLog;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isUse=" + isUse +
                ", cataLog=" + cataLog +
                ", types=" + types +
                '}';
    }
}
