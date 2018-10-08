/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_1;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 *
 * @author ErwindKristian
 */
public class GetMac {

    public String getMac() throws Exception {
        String ma = null;
        //mendapatkan ip localhost
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        NetworkInterface ni = NetworkInterface.getByInetAddress(address);
        if (ni != null) {

            byte[] mac = ni.getHardwareAddress();
          
            for (int i = 0; i < mac.length; i++) {
              //  System.out.println(mac[i]);
            }

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < mac.length; j++) {
                sb.append(String.format("%02x%s", mac[j], (j < mac.length - 1) ? "-" : ""));
            }
            ma = sb.toString();
        }

        return ma;
    }

    public static void main(String[] args) throws Exception {
        GetMac gm = new GetMac();
        String mc = gm.getMac();
        System.out.println(mc);
    }
}
