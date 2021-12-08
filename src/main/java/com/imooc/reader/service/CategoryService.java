package com.imooc.reader.service;

import com.imooc.reader.entity.Category;

import java.util.List;

/**
 * @author xieHang
 * @version V1.0
 * @date 2021/11/21 20:08
 */
public interface CategoryService {
    public List<Category> selectAll();
}
