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
    private static int totalMessagesSent = 0;
    
    public Message(int messageNumber) {
        this.messageNumber = messageNumber;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = generateMessageHash();
        this.messageID = createMessageID();
    }
    
    private String createMessageID(){
        Random random = new Random ();
         messageID = String.valueOf(random.nextInt(10));
        return messageID != null && messageID.length() == 10;
    }
        
    public boolean checkMessageID(){
      return messageID.length() == 10;
    }
    
    public String generateMessageHash(){
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
                totalMessagesSent++;
                return"Message successfully sent";
            case 2:
                return"Press 0 to delete the message";
            case 3:
                storeMessage(messageID, recipientCell, messageText);
                return"Message successfully stored";
            default:
                return"Invalid option. Please choose option 1, 2, or 3";
        }
    }
    //we are checking if the message length is correct or not and returning the response messages.
    public String checkMessageLength(int messageNumber, String recipientCell, String messageText){
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
        return totalMessagesSent;
    }
    
    public void storeMessage(String messageID, String recipientCell, String messageText) {  
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

