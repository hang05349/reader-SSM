package com.imooc.reader.task;

import com.imooc.reader.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/24 22:19]
 * Description   : [完成自动计算任务]
 */
@Component
public class ComputeTask {
    @Resource
    private BookService bookService;
    /**
     *Description:任务调度，定时更新图书评分
     *@author [xieHang]
     *@date [2021/11/24 22:25]
     */
    @Scheduled(cron = "0 * * * * ?")
    public void updateEvaluation(){
        bookService.updateEvaluation();
        System.out.println("已更新所有图书评分");
    }

}
