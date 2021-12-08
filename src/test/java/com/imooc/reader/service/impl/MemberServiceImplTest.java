package com.imooc.reader.service.impl;

import com.imooc.reader.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author : [xieHang]
 * @version : [v1.0.0]
 * @date : [2021/11/23 21:09]
 * Description   : []
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MemberServiceImplTest {
    @Resource
    private MemberService mberService;
    @Test
    public void createMember() {
        mberService.createMember("nihaodd","ddfdffd","测试");

    }
}