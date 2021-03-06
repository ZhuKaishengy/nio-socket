package com.autoai.chapter02.example05;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhukaishengy
 * @Date: 2020/6/1 13:34
 * @Description:
 */
@Slf4j
public class PositionReadTest {

    /**
     * 验证read(ByteBuffer dst, long position)方法返回值的意义
     * 朱开生   朱开生
     */
    @Test
    public void test1() {
        try (
            FileInputStream fis = new FileInputStream("/Users/zhukaishengy/StudyWorkSpace/nio-socket/src/main/java/com/autoai/chapter02/file/a.txt");
            FileChannel channel = fis.getChannel()
        ){
            ByteBuffer byteBuffer = ByteBuffer.allocate(3);
            long read1 = channel.read(byteBuffer, 15);
            log.info("read1:{},result:{}", read1, new String(byteBuffer.array(), Charset.forName("utf-8")));
            byteBuffer.clear();
            long read2 = channel.read(byteBuffer, 18);
            log.info("read2:{},result:{}", read2, new String(byteBuffer.array(), Charset.forName("utf-8")));
            byteBuffer.clear();
            long read3 = channel.read(byteBuffer, 21);
            log.info("read3:{},result:{}", read3, new String(byteBuffer.array(), Charset.forName("utf-8")));

        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    /**
     * 验证read(ByteBuffer dst, long position)方法将字节放入ByteBuffer当前位置
     */
    @Test
    public void test2() {
        try (
            FileInputStream fis = new FileInputStream("/Users/zhukaishengy/StudyWorkSpace/nio-socket/src/main/java/com/autoai/chapter02/file/a.txt");
            FileChannel channel = fis.getChannel()
        ){
            ByteBuffer byteBuffer = ByteBuffer.allocate(4);
            byteBuffer.position(1);
            long read1 = channel.read(byteBuffer, 15);
            log.info("read1:{},result:{}", read1, new String(byteBuffer.array(), Charset.forName("utf-8")));
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    /**
     * 验证read(ByteBuffer dst, long position)方法具有同步特性，读写阻塞
     */
    @Test
    public void test3() {
        try (
            RandomAccessFile file = new RandomAccessFile("/Users/zhukaishengy/StudyWorkSpace/nio-socket/src/main/java/com/autoai/chapter02/file/ng_1730.log","rw");
            FileChannel channel = file.getChannel()
        ){
            // 创建线程池
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>(100), new ThreadFactory() {
                private AtomicInteger count = new AtomicInteger(0);
                @Override
                public Thread newThread(Runnable r) {
                    Thread th = new Thread(r);
                    th.setName("zks-" + count.getAndIncrement());
                    return th;
                }
            }, (r, executor) -> log.error("queue is full"));

            threadPoolExecutor.submit(() -> {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024*89);
                try {
                    channel.read(byteBuffer, 0);
                    log.info("read error");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            threadPoolExecutor.submit(() -> {
                ByteBuffer byteBuffer = ByteBuffer.wrap("123".getBytes());
                try {
                    channel.write(byteBuffer, 0);
                    log.info("write error");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread.sleep(5000);
            log.info("main end...");
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
