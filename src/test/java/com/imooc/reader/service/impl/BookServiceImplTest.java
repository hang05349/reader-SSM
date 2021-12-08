package com.imooc.reader.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imooc.reader.entity.Book;
import com.imooc.reader.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/22 15:39]
 * Description   : []
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class BookServiceImplTest {
    @Resource
    private BookService bookService;
    @Test
    public void paging() {
        IPage<Book> pageObject = bookService.paging(2l,"quantity",1,10);
        List<Book> records = pageObject.getRecords();
        for(Book b:records){
            System.out.println(b.getBookId()+":"+b.getBookName());
        }
        System.out.println("总页数:"+pageObject.getPages());
        System.out.println("总记录数:"+pageObject.getTotal());

    }
}