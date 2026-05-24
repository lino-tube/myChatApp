/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//this is where all my programs will be stored


//imports the Scanner class so we can take input from the user
import java.util.Scanner;

/**
 *
 * @author Student
 */

//the programm will now be interacting with user
public class Main {
    public static void main(String[] args) {
    
        //the scanner will allow the user to enter their details
        Scanner input = new Scanner(System.in);
        
        /*
         an object of the login class is being created, 
         so we can call its methods
        */
        Login login = new Login();
        
        //user registration process for the chat app
        System.out.println("=== USER REGISTRATION ===");
        
        System.out.println("Enter a username: ");
        String username = input.nextLine();
        
        System.out.println("Enter a password: ");
        String password = input.nextLine();
        
        System.out.println("Enter your South African phone number (+27...): ");
        String phoneNumber = input.nextLine();
        
        //registerUser method gets called and the message it returns gets stored
        String response = login.registerUser(username, password, phoneNumber);
        
        //registration message is being shown
        System.out.println(response);
        
        //user login process for the chat app 
        System.out.println("\n=== USER LOGIN ===");
        
        System.out.println("Enter your username: ");
        String loginUsername = input.nextLine();
        
        System.out.println("Enter your password: ");
        String loginPassword = input.nextLine();
        
        //loginUser method gets called to check if the details entered matches the stored ones
        boolean loggedIn = login.loginUser(loginUsername, loginPassword);
        
        String loginMessage = login.returnLoginStatus(loggedIn);
        System.out.println(loginMessage);
        
        if(loggedIn) {
            //if the user has logged in successfully, we welcome them to the chatapp
            System.out.println("=============================");
            System.out.println(    "WELCOME TO QUICKCHAT."    );
            System.out.println("=============================");
            
            boolean running = true;
            int totalMessagesSent = 0;
            /*
             an object of the message class is being created, 
             so we can call its methods
            */
            
            while(running) {
                //display the menu choices to the user
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                
                //We are prompting the user to enter their option(1, 2 or 3)
                System.out.println("Choose an option: ");
                //reads the user input 
                int choice = input.nextInt();
                input.nextLine();
                
                Message msg = null;
                
                switch(choice) {
                    case 1:
                        //we asking the user to enter how mny messages they wish to send.
                        System.out.println("\nHow many messages would you like to send?");
                        int numMessages = input.nextInt();
                        input.nextLine();
                        
                        ////loops according to the number of messages the user will be sending
                        for(int i = 0; i < numMessages; i++){
                            int messageNumber = i + 1;
                        
                            System.out.println("\n=== Message " + messageNumber + " of " + numMessages + "===");
                            
                            //we are prompting the user to enter the number of the person or people they sending messages to
                            System.out.println("Enter recipient cell phone number: ");
                            String recipientCell = input.nextLine();
                            
                            //we are prompting the user to type the message they want to send
                            System.out.println("Enter your message(max 250 characters): ");
                            String messageText = input.nextLine();
                           
                            msg = new Message(messageNumber, recipientCell, messageText);
                            
                            System.out.println(msg.checkMessageLength());
                            
                            if (messageText.length() > 250){
                                
                                System.out.println(msg.checkRecipientCell());
                                
                                String results = msg.sentMesssage();
                                System.out.println(results);
                            }
                            
                            String result = msg.createMessageHash();
                                System.out.println("\nMessage Hash: " + result);
                                
                            System.out.println("\n------MESSAGE DETAILS------");
                            String Results = msg.printMessage();
                                System.out.println(Results);
                                
                            String Result = msg.sentMesssage();
                                System.out.println(Result);
                        }
                        System.out.println("\n=====================================================");
                        System.out.println("Total messages sent are: " + msg.returnTotalMessages());
                        break;
                     case 2: 
                        System.out.println("Comming Soon.");
                        break;
                    case 3:  
                        System.out.println("Thank you for using QuickChat.");
                        running = false;
                        break;
                    default:
                        System.out.println("Inavlid option, please choose either 1, 2, or 3. ");
                }
            }
        }else{
            //If the user's login failed, we tell them to try again
            System.out.println("Login was unsuccessful, please try again.");
        }
    }
}
