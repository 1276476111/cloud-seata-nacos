package com.qsn.order.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * 测试实体
 *
 * @author qiusn
 * @date 2020-01-07
 */
@Getter
@Setter
@ToString
@TableName("t_user")
public class TestEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    @ApiModelProperty("名字")
    private String name;

    private int age;

    private Date gmtCreate;

    private Date gmtModified;

}
