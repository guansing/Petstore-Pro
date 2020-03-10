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
//@Data注解简化代码，不用写get和set了
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    //Category的id
    private String catid;
    //Category的名字
    private String name;
    //Category的描述
    private String descn;


}
