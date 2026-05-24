/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

import java.util.Random;
import org.json.JSONObject;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipientCell;
    private String messageText;
    private String messageHash;
    
    private static int totalMessages = 0;
    
    public Message( int messageNumber, String recipientCell, String messageText) {
        this.messageNumber = messageNumber;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageID = createMessageID();
        this.messageHash = createMessageHash();
    }
    
    private String createMessageID(){
        Random random = new Random ();
        long id = (long) random.nextInt(1000000000) + 1000000000;
        return String.valueOf(id);
         
    }
    
    public String createMessageHash(){
        //Taking the first two characters of the message ID
        String idPart = messageID.substring(0, 2);
        
        //In order to find the first and last words, we must split the message into words.
        String[] words = messageText.split(" ");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "");
        
        //combine the idPart, messageNumber, firstWord and lastWord together, to form a message hash
        String hash = idPart + ":" + messageNumber + ":" + firstWord + lastWord;
        //return everything in capital letters
        return hash.toUpperCase();
    }
    
     public String checkRecipientCell(){
        
        if(recipientCell.startsWith("+27") && recipientCell.length() <=12){
            return"Cell phone number successfully captured.";
        }else{
            return"Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
    
    public String sentMesssage() {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nWhat would yoou like to do with your message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");
        
        int option = input.nextInt();

        
        switch(option) {
            case 1:
                totalMessages++;
                return"Message successfully sent";
            case 2:
                return"Press 0 to delete the message";
            case 3:
                storeMessage();
                System.out.println("Mesage saved to messages.json.");
                return"Message successfully stored";
            default:
                return"\nInvalid option. Please choose option 1, 2, or 3";
        }
    }
    //we are checking if the message length is correct or not and returning the response messages.
    public String checkMessageLength(){
        if (messageText.length() > 250){
            int over = messageText.length() - 250;
            return "Message exceeds 250 characters by X" + over + "; please reduce the size.";
        }else{
            return"Message ready to send.";
        }
    }
     
    public String printMessage() {
        return "Message ID: " + messageID + "\n" +
                "Message Hash: " + messageHash + "\n" +
                "Recipient: " + recipientCell + "\n" +
                "Message: " + messageText;
    }
    
    public int returnTotalMessages() {
        return totalMessages;
    }
    
    //JSON library used: org.json
    //Source: https://mvnrespository.com/artifact/org.json/json 
    public void storeMessage() {  
        JSONObject obj = new JSONObject();
            obj.put("messageID", this.messageID); 
            obj.put("recipientCell", this.recipientCell); 
            obj.put("messageText",   this.messageText); 

        try (java.io.FileWriter fw = new java.io.FileWriter("messages.json", true)) {
            fw.write(obj.toString());
        } catch (IOException e){
            System.out.println("Error storing message: " + e.getMessage());
        }
   } 

}

