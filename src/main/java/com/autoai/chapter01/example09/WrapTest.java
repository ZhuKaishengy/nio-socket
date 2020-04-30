package com.autoai.chapter01.example09;

import lombok.extern.slf4j.Slf4j;

import java.nio.CharBuffer;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/30 11:25
 * @Description:
 */
@Slf4j
public class WrapTest {

    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.wrap("abcde", 1, 3);
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.get());
        }
        charBuffer.clear();
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.get());
        }
    }
}
