package com.autoai.chapter04.example06;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.*;

/**
 * @Author: zhukaishengy
 * @Date: 2020/6/23 20:15
 * @Description:
 */
@Slf4j
public class BroadcastTest {

    @Test
    public void server1() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        log.info("address:{}", hostAddress);
        try (DatagramSocket datagramSocket = new DatagramSocket(null)){
            datagramSocket.bind(new InetSocketAddress(hostAddress, 9000));
            byte[] bytes = new byte[10];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            String message = new String(datagramPacket.getData());
            log.info(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void client() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            boolean broadcast = datagramSocket.getBroadcast();
            log.info("broadcast:{}", broadcast);
            datagramSocket.setBroadcast(true);
            // 网段.255
            datagramSocket.connect(new InetSocketAddress("172.19.4.255", 9000));
            datagramSocket.send(new DatagramPacket("123".getBytes(), 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
