package com.csu.petstorepro.petstore.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lgx
 * @since 2020-03-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String suppid;

    private String name;

    private String status;

    private String addr1;

    private String addr2;

    private String city;

    private String state;

    private String zip;

    private String phone;

    @TableField(exist = false)
    private String password;

}
