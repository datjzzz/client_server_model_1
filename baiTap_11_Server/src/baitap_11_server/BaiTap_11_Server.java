/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap_11_server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class BaiTap_11_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {

            // Tao serverSocket va lang nghe
            int port = 99;
            ServerSocket serverSocket = new ServerSocket(port);

            // chap nhan ket noi tu 1 client
//            Socket clientSocket = serverSocket.accept();

    // chap nhan  nhieu client:
    while(true){
        Socket clientSocket = serverSocket.accept();
        datAppProcess p = new datAppProcess(clientSocket);
        p.start();
    }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
