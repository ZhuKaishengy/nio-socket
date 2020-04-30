package com.autoai.chapter01.example03;

import java.nio.CharBuffer;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/28 14:59
 * @Description:
 */
public class FlipTest {

    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(20);
        charBuffer.put("zhukaishengy");
        charBuffer.flip();
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get());
        }
    }
}
