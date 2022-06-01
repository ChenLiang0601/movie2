package com.movie2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CL
 * @since 2022-05-31
 */
public class Admin extends Model<Admin> {

    private static final long serialVersionUID=1L;

    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    private String adminUsername;

    private String adminPwd;

    private Integer teliphomenumber;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Integer getTeliphomenumber() {
        return teliphomenumber;
    }

    public void setTeliphomenumber(Integer teliphomenumber) {
        this.teliphomenumber = teliphomenumber;
    }

    @Override
    protected Serializable pkVal() {
        return this.adminId;
    }

    @Override
    public String toString() {
        return "Admin{" +
        "adminId=" + adminId +
        ", adminUsername=" + adminUsername +
        ", adminPwd=" + adminPwd +
        ", teliphomenumber=" + teliphomenumber +
        "}";
    }
}
