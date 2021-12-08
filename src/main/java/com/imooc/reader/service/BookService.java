package com.imooc.reader.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imooc.reader.entity.Book;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/22 15:17]
 * Description   : []
 */
public interface BookService {
/**
 *Description: 分页查询图书
 *@author [xieHang]
 *@date [2021/11/22 20:34]
 * @param categoryId 分类
 * @param order 排序规则
 * @param page 页号
 * @param rows 每页记录数
 * @return IPage<Book>
 */
    public IPage<Book> paging(Long categoryId,String order,Integer page, Integer rows);
    /**
     *Description: 根据图书Id查找图书对象
     *@author [xieHang]
     *@date [2021/11/22 21:45]
     * @param bookId 图书Id
     * @return Book 对应的图书对象
     */
    public Book selectById(Long bookId);
    /**
     *Description: 更新图书评分/评价数量
     *@author [xieHang]
     *@date [2021/11/24 22:15]
     */
    public void updateEvaluation();

    /**
     *Description: 新增图书
     *@author [xieHang]
     *@date [2021/12/6 19:36]
     * @param book
     * @return Book
     */
    public Book createBook(Book book);

    @Transactional
    Book updateBook(Book book);

    @Transactional
    void deleteBook(Long bookId);
}
