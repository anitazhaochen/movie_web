package com.imp4m.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 类型
 *
 * @author skl
 * @date 2016/10/3
 * @time 2018-4-24 08:17:32
 */
@Entity
@Table(name = "t_vipcode")
public class VipCode {


    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
    @GeneratedValue(generator = "hibernate-uuid")
    private String id;//主键id

    private String is_use;//是否在使用


    private String code;//编码

    private Date create_time;//创建时间

    private Date expire_time;//过期时间


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_use() {
        return is_use;
    }

    public void setIs_use(String is_use) {
        this.is_use = is_use;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }


    @Override
    public String toString() {
        return "VipCode{" +
                "id='" + id + '\'' +
                ", isUse='" + is_use + '\'' +
                ", code='" + code + '\'' +
                ", create_time=" + create_time +
                ", expire_time=" + expire_time +
                '}';
    }
}
