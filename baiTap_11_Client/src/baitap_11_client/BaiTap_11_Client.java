/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baitap_11_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author ASUS
 */
public class BaiTap_11_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // ket noi toi server
            int port = 99;
            Socket socket = new Socket("localhost", port);
            System.out.println("Complete connecting to the server");

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()) // trong Socket có phương thức để lấy InputStream từ url của socket
                ); // phải bỏ vào một inputStream

                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                Scanner sc = new Scanner(System.in);
                String message;
                while (true) {
                    // gửi tin nhắn:
                    System.out.print("Client: ");
                    message = sc.nextLine();
                    writer.println(message);
                    writer.flush();

                    // nhận tin nhắn
                    message = reader.readLine();
                    System.out.println("Server: " + message);

                }

            } catch (Exception e) {
            }

        } catch (Exception e) {
            System.out.println("Connection Failed!");
        }

    }

}
