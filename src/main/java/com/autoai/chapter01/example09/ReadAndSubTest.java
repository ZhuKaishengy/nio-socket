package com.autoai.chapter01.example09;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/30 11:13
 * @Description:
 */
@Slf4j
public class ReadAndSubTest {

    public static void main(String[] args) throws IOException {

        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.put("abcdefg12");
        // abcdefg12_
        charBuffer.position(7);
        // abcdefghi_
        charBuffer.append("hi");

        charBuffer.rewind();
        for (int i = 0; i < charBuffer.limit(); i++) {
            char c = charBuffer.get();
            // abcdefghi_
            System.out.print(c);
        }

        System.out.println();

        charBuffer.position(6);
        CharBuffer charBuffer1 = CharBuffer.allocate(4);
        // ghi_
        charBuffer.read(charBuffer1);

        for (int i = 0; i < charBuffer1.limit(); i++) {
            char c = charBuffer1.get(i);
            System.out.print(c);
        }

        System.out.println();

        charBuffer.position(0);
        // abcdefg
        CharBuffer charBuffer2 = charBuffer.subSequence(0, 7);
        // 0 7 10
        log.info("position:{},limit:{},capacity:{}", charBuffer2.position(), charBuffer2.limit(), charBuffer2.capacity());
        for (int i = 0; i < charBuffer2.limit(); i++) {
            char c = charBuffer2.get(i);
            System.out.print(c);
        }
    }
}
