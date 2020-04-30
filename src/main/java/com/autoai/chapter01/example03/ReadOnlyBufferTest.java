package com.autoai.chapter01.example03;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/28 14:31
 * @Description:
 */
@Slf4j
public class ReadOnlyBufferTest {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        log.info("readonly:{}", byteBuffer.isReadOnly());
        try {
            byteBuffer.asReadOnlyBuffer().put((byte)4);
        } catch (ReadOnlyBufferException e) {
            log.error("read only buffer");
        }
    }
}
