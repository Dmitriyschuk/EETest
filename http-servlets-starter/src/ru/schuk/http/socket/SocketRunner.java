package ru.schuk.http.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLOutput;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = Inet4Address.getByName("localhost");
        //tcp
        try (Socket socket = new Socket(inetAddress, 7777);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
            outputStream.writeUTF("Hello world!");
            System.out.println("Response from server " + inputStream.readUTF());
//            byte[] response = inputStream.readAllBytes();
//            System.out.println(response.length);

            String tmp = "";

//            while (inputStream.available()>0){
//                System.out.println(inputStream.available());
//                byte b = inputStream.readByte();
//                System.out.println(b);
//            }
//            for (byte b:response
//                 ) {
//                System.out.print((char) b);
//            }
//        }
        }
    }
}
