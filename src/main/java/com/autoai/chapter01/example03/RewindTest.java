package com.autoai.chapter01.example03;

import lombok.extern.slf4j.Slf4j;

import java.nio.CharBuffer;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/28 15:20
 * @Description:
 */
@Slf4j
public class RewindTest {

    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.put("zks");
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
        charBuffer.rewind();
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
    }
}
