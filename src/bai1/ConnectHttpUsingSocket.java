/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai1;

import java.io.*; 
 import java.net.Socket;
/**
 *
 * @author phamv
 */
public class ConnectHttpUsingSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("localhost:81", 80); 
        //Gửi yêu cầu 
        OutputStream os = socket.getOutputStream(); 
        PrintWriter out=new PrintWriter(os,true); 
        out.println("GET / HTTP/1.0"); 
        out.println(); 
        out.flush(); 
        //Nhận dữ liệu
        InputStream is = socket.getInputStream(); 
        int len=0; 
        byte []buffer=new byte[4086]; 
        while((len=is.read(buffer))!=-1) 
        { 
            String data=new String(buffer,0,len); 
            System.out.println(data); 
        } 
        socket.close(); 
    }
    
}
