package com.csu.petstorepro.petstore.entity;

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
public class Bannerdata implements Serializable {

    private static final long serialVersionUID = 1L;

    private String favcategory;

    private String bannername;


}
