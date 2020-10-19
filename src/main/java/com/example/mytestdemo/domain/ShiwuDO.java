package com.example.mytestdemo.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author angtai
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("shiwu")
public class ShiwuDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id 不自增
     */
    private Integer id;

    private String value;


}
