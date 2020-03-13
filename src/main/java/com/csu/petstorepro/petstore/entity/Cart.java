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

    private Integer quantity;

    private BigDecimal listprice;

    private BigDecimal total;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInstock() {
        return instock;
    }

    public void setInstock(Boolean instock) {
        this.instock = instock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getListprice() {
        return listprice;
    }

    public void setListprice(BigDecimal listprice) {
        this.listprice = listprice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
