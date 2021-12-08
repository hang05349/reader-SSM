package com.imooc.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.reader.entity.Book;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/22 15:14]
 * Description   : []
 */
public interface BookMapper extends BaseMapper<Book> {
    /**
     *Description: 更新图书评分/评价数量
     *@author [xieHang]
     *@date [2021/11/24 22:11]

     */
    public void updateEvaluation();
}
