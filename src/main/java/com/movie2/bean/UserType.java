package com.movie2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

public class UserType extends Model<UserType> {
    private static final long serialVersionUID=1L;
    @TableId(value = "utid", type = IdType.AUTO)

    private Integer utid;
    private String username;
    private String utype;

    public Integer getUtid() {
        return utid;
    }

    public void setUtid(Integer utid) {
        this.utid = utid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    @Override
    protected Serializable pkVal() {
        return this.utid;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "utid=" + utid +
                ", username='" + username + '\'' +
                ", utype='" + utype + '\'' +
                '}';
    }
}
