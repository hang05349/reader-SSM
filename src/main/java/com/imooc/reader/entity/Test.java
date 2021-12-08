package com.imooc.reader.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author xieHang
 * @version V1.0
 * @date 2021/11/21 16:40
 */
@TableName("test")//说明实体类对应哪一张表
public class Test {
    @TableId(type = IdType.AUTO)//TableId说明哪个属性对应主键，type=IdType.AUTO代表使用数据库底层的主键自动递增
    @TableField("id")//说明主键对应哪个字段，如果字段名与属性名相同或者符合驼峰命名转换规则，可省略
    private Integer id;
    @TableField("content")
    private String content;
    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
