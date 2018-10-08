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
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class No3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        // TODO code application logic here
        String jaringan = "192.168.1.";
        for (int i = 65; i <= 255; i++) {
            String ip=jaringan+i;
            InetAddress ia = InetAddress.getByName(ip);
            if(ia.isReachable(3000)){
                System.out.println(ia.getHostAddress() +"Reacable");
            }else{
                System.out.println(ia.getHostAddress() +"unReacable");
            }
        }
    }
    
}
