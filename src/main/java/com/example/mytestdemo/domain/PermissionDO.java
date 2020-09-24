package com.example.mytestdemo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author angtai
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("permission")
public class PermissionDO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 角色Id
     */
    private Integer roleId;



}
