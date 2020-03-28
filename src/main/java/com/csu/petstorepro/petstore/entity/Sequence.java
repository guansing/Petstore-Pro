package com.csu.petstorepro.petstore.entity;

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
public class Sequence implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String name;

    private Integer nextid;

    public Sequence(String name,int nextid)
    {
        this.name = name;
        this.nextid = nextid;
    }
    public Sequence() {
    }
}
