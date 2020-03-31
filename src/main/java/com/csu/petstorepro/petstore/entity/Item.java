package com.csu.petstorepro.petstore.entity;

import java.math.BigDecimal;
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
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String itemid;

    private String productid;

    private Double listprice;

    private Double unitcost;

    private String supplier;

    private String status;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    @TableField(exist = false)
    private String productname;

    @TableField(exist = false)
    private String suppname;

}
