package com.csu.petstorepro.petstore.entity;

import java.math.BigDecimal;
import java.io.Serializable;
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
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    private String itemid;

    private String productid;

    private String name;

    private Boolean instock;

    private int quantity;

    private Double listprice;

    private Double total;
}
