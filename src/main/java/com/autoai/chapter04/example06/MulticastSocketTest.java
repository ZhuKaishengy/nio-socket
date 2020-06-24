package com.autoai.chapter04.example06;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/**
 * @Author: zhukaishengy
 * @Date: 2020/6/24 10:49
 * @Description:
 */
@Slf4j
public class MulticastSocketTest {

    @Test
    public void server() {
        try {
            MulticastSocket multicastSocket = new MulticastSocket(null);
            multicastSocket.bind(new InetSocketAddress("172.19.4.227", 9000));
            multicastSocket.joinGroup(InetAddress.getByName("172.19.4.227"));
            byte[] bytes = new byte[10];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            multicastSocket.receive(datagramPacket);
            log.info("message:{}", datagramPacket.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void client() {
        try {
            MulticastSocket multicastSocket = new MulticastSocket(null);
            multicastSocket.bind(new InetSocketAddress("172.19.4.227", 8000));
            multicastSocket.connect(new InetSocketAddress("172.19.4.227", 9000));
            DatagramPacket datagramPacket = new DatagramPacket("123".getBytes(), 0, 3);
            multicastSocket.send(datagramPacket);
            log.info("message:{}", datagramPacket.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
