package com.qsn.order.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


/**
 * 
 *
 * @author qiusn
 * @date 2021-01-08
 */
@Getter
@Setter
@ToString
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;

}