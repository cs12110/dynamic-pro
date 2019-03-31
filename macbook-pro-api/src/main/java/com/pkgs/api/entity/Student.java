package com.pkgs.api.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * TODO:
 *
 * <p>
 *
 * @author cs12110 create at 2019-03-31 01:26
 * <p>
 * @since 1.0.0
 */
@Data
public class Student {

    private Integer id;

    private String name;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
