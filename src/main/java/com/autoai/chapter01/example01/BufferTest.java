package com.autoai.chapter01.example01;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.*;

/**
 * @Author: zhukaishengy
 * @Date: 2020/4/27 20:09
 * @Description:
 */
@Slf4j
public class BufferTest {

    /**
     * {@code Buffer#capacity}
     */
    @Test
    public void testCapacity() {
        byte[] bytes = new byte[]{1, 2, 3, 4};
        char[] chars = new char[]{'a','b'};
        short[] shorts = new short[]{1, 2, 3, 4};
        int[] ints = new int[]{1, 2, 3, 4};
        long[] longs = new long[]{1, 2, 3, 4};
        float[] floats = new float[]{1, 2, 3, 4};
        double[] doubles = new double[]{1, 2, 3, 4};

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ShortBuffer shortBuffer = ShortBuffer.wrap(shorts);
        IntBuffer intBuffer = IntBuffer.wrap(ints);
        LongBuffer longBuffer = LongBuffer.wrap(longs);
        FloatBuffer floatBuffer = FloatBuffer.wrap(floats);
        DoubleBuffer doubleBuffer = DoubleBuffer.wrap(doubles);

        System.out.println(byteBuffer.getClass());
        System.out.println(charBuffer.getClass());
        System.out.println(shortBuffer.getClass());
        System.out.println(intBuffer.getClass());
        System.out.println(longBuffer.getClass());
        System.out.println(floatBuffer.getClass());
        System.out.println(doubleBuffer.getClass());

        System.out.println(byteBuffer.capacity());
        System.out.println(charBuffer.capacity());
        System.out.println(shortBuffer.capacity());
        System.out.println(intBuffer.capacity());
        System.out.println(longBuffer.capacity());
        System.out.println(floatBuffer.capacity());
        System.out.println(doubleBuffer.capacity());
    }

    @Test
    public void testLimit() {
        char[] chars = new char[]{'a','b','c'};
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        log.info("capacity:{}", charBuffer.capacity());
        log.info("limit default:{}", charBuffer.limit());
        charBuffer.limit(1);
        log.info("limit changed:{}", charBuffer.limit());
        charBuffer.put('d');
        charBuffer.put('e');
    }

    @Test
    public void testPosition() {
        char[] chars = new char[]{'a','b','c'};
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        log.info("capacity:{}, limit:{}, position:{}", charBuffer.capacity(), charBuffer.limit(), charBuffer.position());
        charBuffer.position(1);
        System.out.println(chars);
    }

    @Test
    public void testRemaining() {
        char[] chars = new char[]{'a','b','c'};
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        log.info("capacity:{}, limit:{}, position:{}, remaining:{}", charBuffer.capacity(), charBuffer.limit(),
                charBuffer.position(), charBuffer.remaining());
        charBuffer.position(1);
        log.info("capacity:{}, limit:{}, position:{}, remaining:{}", charBuffer.capacity(), charBuffer.limit(),
                charBuffer.position(), charBuffer.remaining());
    }

    @Test
    public void testMark() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.position(4);
        log.info("position:{}", byteBuffer.position());
        byteBuffer.mark();
        byteBuffer.position(7);
        log.info("position:{}", byteBuffer.position());
        byteBuffer.reset();
        log.info("position:{}", byteBuffer.position());
    }
}
