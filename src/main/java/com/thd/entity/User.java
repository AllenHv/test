package com.thd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * testDemo
 * @author Allen
 */
@Data
@Builder
//@NoArgsConstructor
public class User {
    /**
     * 主键
     */
    private Long id;
    /**
     * @TableField("name") realName匹配数据库中的column name
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
