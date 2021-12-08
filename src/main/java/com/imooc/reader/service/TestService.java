package com.imooc.reader.service;

import com.imooc.reader.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xieHang
 * @version V1.0
 * @date 2021/11/21 9:21
 */
@Service
public class TestService {
    @Resource
    private TestMapper testMapper;
    public void batchImport() {
        for (int i = 0; i < 5; i++) {
            testMapper.insertSample();
        }

    }
}
