package com.imooc.reader.service;

import com.imooc.reader.entity.Evaluation;

import java.util.List;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/22 22:27]
 * Description   : []
 */
public interface EvaluationService {
    /**
     *Description: 按图书编号查询有效短评
     *@author [xieHang]
     *@date [2021/11/22 22:29]
     * @param bookId 图书编号
     * @return List<Evaluation> 评论列表
     */
    public List<Evaluation> selectByBookId(Long bookId);
}
