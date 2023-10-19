/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetosdchat;

/**
 *
 * @author backu
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ProjetoSDChat {

    public static void main(String[] args) {

       
       

        Socket socket = null;

       try{
            int serverPort = 5000; // Porta do servidor
            socket = new Socket("localhost", serverPort);
            while (true) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.print("Cliente: ");
            out.writeUTF(scanner.nextLine());
            System.out.println("Servidor: "+ in.readLine());

        }
       }catch(UnknownHostException e){System.out.println("Socket"+e.getMessage());
       }catch(EOFException e){ System.out.println("EOF : "+e.getMessage());
       }catch(IOException e){System.out.println("readLine:"+e.getMessage());
       }finally{if(socket!=null) try{socket.close();}catch(IOException e){System.out.println("close:"+e.getMessage());}}
       
    }
}
