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
public class Lineitem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderid;

    private Integer linenum;

    private String itemid;

    private Integer quantity;

    private double unitprice;


}
