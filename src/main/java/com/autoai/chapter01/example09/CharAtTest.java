package com.autoai.chapter01.example09;

import lombok.extern.slf4j.Slf4j;

import java.nio.CharBuffer;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/30 11:06
 * @Description:
 */
@Slf4j
public class CharAtTest {

    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.append("abcdef");
        charBuffer.position(2);

        log.info("char at 0:{}", charBuffer.charAt(0));
        log.info("char at 3:{}", charBuffer.charAt(3));
    }
}
