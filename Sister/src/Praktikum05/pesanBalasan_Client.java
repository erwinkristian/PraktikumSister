/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author LAB_TI
 */
public class pesanBalasan_Client {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try {
            for (;;) {
                String hostname = "localhost";
                Socket daytime = new Socket(hostname, SERVICE_PORT); //Membuat Koneksi
                System.out.println("COnnection Established");

                daytime.setSoTimeout(2000);

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String kata = br.readLine();
                System.out.println("Data yang diinputkan : " + kata);

                //proses nulis
                OutputStream os = daytime.getOutputStream();
                PrintStream ps = new PrintStream(os);
                //nulis ke server
                ps.println(kata);//Perlu Println biar datanya kebanya jangan print

                
                
                BufferedReader br1 = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
                System.out.println("Result \t : " + br1.readLine());
                System.out.println("");

                
                
                
                os.flush();
                os.close();
                daytime.close();
            }
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}
