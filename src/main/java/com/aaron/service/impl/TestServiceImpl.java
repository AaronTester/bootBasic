package com.aaron.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/22
 */
@Service
public class TestServiceImpl {
    @Async
    public void testAsyn() {
        try {
            Thread.sleep(3000);
            System.out.println("**************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
