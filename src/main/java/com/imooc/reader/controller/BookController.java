package com.imooc.reader.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imooc.reader.entity.*;
import com.imooc.reader.mapper.MemberReadStateMapper;
import com.imooc.reader.service.BookService;
import com.imooc.reader.service.CategoryService;
import com.imooc.reader.service.EvaluationService;
import com.imooc.reader.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xieHang
 * @version V1.0
 * @Package com.imooc.reader.controller
 * @date 2021/11/21 20:38
 */
@Controller
public class BookController {
    @Resource
    private CategoryService categoryService;

    @Resource
    private BookService bookService;

    @Resource
    private EvaluationService evaluationService;
    @Resource
    private MemberService memberService;

    /**
     *Description:显示首页
     *@author    [xieHang]
     *@date      [2021/11/22 8:39]
     *@return    org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/")
    public ModelAndView showIndex(){
        ModelAndView mav = new ModelAndView("/index");
        List<Category> categoryList = categoryService.selectAll();
        mav.addObject("categoryList",categoryList);
        return mav;
    }
    /**
     *Description:分页查询图书列表
     *@author [xieHang]
     *@date [2021/11/22 16:11]
     * @param p 页号
     * @return IPage<Book>分页对象
     */
    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> selectBook(Long categoryId,String order,Integer p){
        if(p == null){
            p=1;
        }
        IPage<Book> pageObject = bookService.paging(categoryId,order,p,10);
        return pageObject;
    }

    @GetMapping("/book/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id, HttpSession session){
        Book book = bookService.selectById(id);
        List<Evaluation> evaluationList = evaluationService.selectByBookId(id);
        Member member = (Member) session.getAttribute("loginMember");
        ModelAndView mav = new ModelAndView("/detail");
        if(member != null){
            MemberReadState memberReadState = memberService.selectMemberReadState(member.getMemberId(), id);
            mav.addObject("memberReadState",memberReadState);
        }
        mav.addObject("book",book);
        mav.addObject("evaluationList",evaluationList);
        return mav;
    }
}
