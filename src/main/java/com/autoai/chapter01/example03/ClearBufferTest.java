package com.autoai.chapter01.example03;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.CharBuffer;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/28 14:43
 * @Description:
 */
@Slf4j
public class ClearBufferTest {

    public static void main(String[] args) {
        char[] chars = new char[]{'a','b','c','d'};
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
        charBuffer.limit(3);
        charBuffer.position(2);
        charBuffer.mark();
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
        charBuffer.clear();
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
        for (int i = 0; i < chars.length; i++) {
            log.info("item:{}", chars[i]);
        }
    }
}
