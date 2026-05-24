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
        
        System.out.println("=============================");
        System.out.println(    "WELCOME TO CHATAPP."    );
        System.out.println("=============================");
        
        //user registration process for the chat app
        System.out.println("\n=== USER REGISTRATION ===");
        
        System.out.println("Enter your first name: ");
        String firstName = input.nextLine();
        
        System.out.println("Enter your last name: ");
        String lastName = input.nextLine();
        
        while(true){
            
            System.out.println("Enter a username(must contain an underscore(_) and be 5 characters max): ");
            String username = input.nextLine();
            
            if(login.checkUserName(username)){
                System.out.println("Username successfully captured.");
                
                break;
                
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }
        
        while(true){
            
            System.out.println("Enter a password( must contain a minimum of 8 characters, 1 capital letter, 1 number, and 1 special): ");
            String password = input.nextLine();
            
            if(login.checkPasswordComplexity(password)){
                System.out.println("Password successfully captured.");
                
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }
        
        while(true){
            System.out.println("Enter your South African phone number (must include an international code e.g. +27875678907): ");
            String phoneNumber = input.nextLine();
            
            if(login.checkCellPhoneNumber(phoneNumber)){
                System.out.println("Cell phone number successfully added.");
                
                break;
            } else{
                System.out.println("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
            }
        }
        String response = login.registerUser(username, password, phoneNumber, firstName, lastName);
        
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
            System.out.println("\nWelcome to ChatApp.");
            
            boolean running = true;
            int totalMessagesSent = 0;
            /*
             an object of the message class is being created, 
             so we can call its methods
            */
            
            while(running) {
                System.out.println("\n--------------------------------------");
                //display the menu choices to the user
                System.out.println("Please choose an option: ");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                
                //We are prompting the user to enter their option(1, 2 or 3)
                System.out.println("Enter your choice: ");
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
                        
                            System.out.println("\n=== Message " + messageNumber + " of " + numMessages + " ===");
                            
                            //we are prompting the user to enter the number of the person or people they sending messages to
                            System.out.println("Enter recipient cell phone number(e.g. +27678907890): ");
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
                                
                            System.out.println("\n------ MESSAGE DETAILS ------");
                            String Results = msg.printMessage();
                                System.out.println(Results);
                                
                            String Result = msg.sentMesssage();
                                System.out.println(Result);
                        }
                        System.out.println("\n=====================================================");
                        System.out.println("Total messages sent: " + msg.returnTotalMessages());
                        
                        System.out.println("\n=== ALL SENT MESSAGES ===");
                        System.out.println("-------------------------------------");
                        String Results = msg.printMessage();
                        System.out.println(Results);
                        break;
                     case 2: 
                        System.out.println("Comming Soon.");
                        break;
                    case 3:  
                        System.out.println("Thank you for using QuickChat. Goodbye!");
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
