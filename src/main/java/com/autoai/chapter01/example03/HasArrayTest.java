package com.autoai.chapter01.example03;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/28 15:09
 * @Description:
 */
@Slf4j
public class HasArrayTest {


    public static void main(String[] args) {

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);
        boolean b1 = byteBuffer1.hasArray();
        log.info("hasArray:{}", b1);

        ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(10);
        boolean b2 = byteBuffer2.hasArray();
        log.info("hasArray:{}", b2);
    }
}
