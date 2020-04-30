package com.autoai.chapter01.example09;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.CharBuffer;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/30 10:54
 * @Description:
 */
@Slf4j
public class AppendTest {

    @Test
    public void test1() {
        CharBuffer charBuffer = CharBuffer.allocate(10);
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
        charBuffer.append('a');
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
        charBuffer.append("bcd");
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());
        charBuffer.append("abcdef", 4, 6);
        log.info("position:{},limit:{},capacity:{}", charBuffer.position(), charBuffer.limit(), charBuffer.capacity());

        charBuffer.flip();
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.get());
        }
    }
}
