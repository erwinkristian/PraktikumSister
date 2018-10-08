/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_5;

import static Praktikum05.pesanBerulang_Server.SERVICE_PORT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author ErwindKristian
 */
public class Server_TCP {
    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) throws SocketException, IOException {
        try {
            ServerSocket ss = new ServerSocket(SERVICE_PORT);
            System.out.println(" service started");
            for (;;) {
                Socket nextClient = ss.accept();

                System.out.println("Received request from : \n "
                        + "Alamat \t : " + nextClient.getInetAddress() + " : "
                        + "Port   \t : " + nextClient.getPort());

                BufferedReader br = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
                String pesan_dari_client = br.readLine();
                System.out.println("Data Client \t : " + pesan_dari_client);
                SerializationDemo sd = new SerializationDemo();
                sd.serialize(pesan_dari_client, "praktikum5.ser");

                OutputStream os = nextClient.getOutputStream();
                PrintStream ps = new PrintStream(os);
                ps.println("Data telah diterima oleh Server");
                System.out.println("");

                os.flush();
                os.close();
                nextClient.close();
            }
        } catch (BindException be) {
            System.out.println("Error " + be);
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }

    }
}
