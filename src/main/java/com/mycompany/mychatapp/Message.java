/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

import java.util.Random;
import org.json.JSONObject;
import java.io.IOException;
import java.io.FileWriter;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipientCell;
    private String messageText;
    private String messageHash;
    
    private static String[] sentMessages;
    private static int messageIndex = 0;
    private static int totalMessages = 0;
    
    public Message( int messageNumber, String recipientCell, String messageText) {
        this.messageNumber = messageNumber;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageID = createMessageID();
        this.messageHash = createMessageHash();
        if (sentMessages == null) {
            sentMessages = new String[totalMessages];
        }
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
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
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
        System.out.println("What would yoou like to do with your message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");
        
        int option = 0;
        
        switch(option) {
            case 1:
                sentMessages[messageIndex] = printMessage();
                messageIndex++;
                totalMessages++;
                return"Message successfully sent";
            case 2:
                return"Press 0 to delete the message";
            case 3:
                storeMessage(messageID, messageHash, recipientCell, messageText);
                return"Message successfully stored";
            default:
                return"Invalid option. Please choose option 1, 2, or 3";
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
    
    public static String getAllSentMessages() {
        if (messageIndex ==0) {
            return "No message sent yet.";
        }
        String result = "";
        for (int i = 0; i < messageIndex; i++){
            result += sentMessages[i] + "\n===========\n";
        }
        return "";
    }
    
    public void storeMessage(String messageID, String messageHash, String recipientCell, String messageText) {  
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

