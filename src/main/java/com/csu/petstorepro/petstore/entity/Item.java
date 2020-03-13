package com.csu.petstorepro.petstore.entity;

import java.math.BigDecimal;
import java.io.Serializable;

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

    private BigDecimal listprice;

    private BigDecimal unitcost;

    private Integer supplier;

    private String status;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

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

    public BigDecimal getListprice() {
        return listprice;
    }

    public void setListprice(BigDecimal listprice) {
        this.listprice = listprice;
    }

    public BigDecimal getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }
}
