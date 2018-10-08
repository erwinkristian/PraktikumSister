/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_1;

/**
 *
 * @author ErwindKristian
 */

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class macAddress {
    
    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("IP Address" + ip.getHostAddress());
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        byte[] mac = network.getHardwareAddress();
        
        System.out.print("MAC Address : ");
        StringBuilder ab = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            ab.append(String.format("%02X%s", mac[1], (i < mac.length - 1) ? "-" : ""));
        }
        System.out.println(ab.toString());
    }
}
