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
public class Types extends Model<Types> {

    private static final long serialVersionUID=1L;

    @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;

    private String type;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Serializable pkVal() {
        return this.typeId;
    }

    @Override
    public String toString() {
        return "Types{" +
        "typeId=" + typeId +
        ", type=" + type +
        "}";
    }
}
