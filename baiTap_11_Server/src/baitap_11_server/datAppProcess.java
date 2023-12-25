/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap_11_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class datAppProcess extends Thread {

    private Socket socket;

    public datAppProcess(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Xu ly sau
        // ngat ket noi
        // socket.close();

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()) // trong Socket có phương thức để lấy InputStream từ url của socket
            ); // phải bỏ vào một inputStream

            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);

            while (true) {
                String message;
                // nhận tin nhắn
                message = reader.readLine();
                System.out.println("Client: " + message);

                // gửi tin nhắn:
                System.out.print("Server: ");
                message = sc.nextLine();
                writer.println(message);
                writer.flush();
            }

        } catch (Exception e) {
        }

    }

}
