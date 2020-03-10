package com.csu.petstorepro.petstore.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderid;

    private String userid;

    private LocalDate orderdate;

    private String shipaddr1;

    private String shipaddr2;

    private String shipcity;

    private String shipstate;

    private String shipzip;

    private String shipcountry;

    private String billaddr1;

    private String billaddr2;

    private String billcity;

    private String billstate;

    private String billzip;

    private String billcountry;

    private String courier;

    private BigDecimal totalprice;

    private String billtofirstname;

    private String billtolastname;

    private String shiptofirstname;

    private String shiptolastname;

    private String creditcard;

    private String exprdate;

    private String cardtype;

    private String locale;


}
