package com.example.mytestdemo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author angtai
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("role")
public class RoleDO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      private Integer id;

    /**
     * 权限名称
     */
    private String roleName;


}
