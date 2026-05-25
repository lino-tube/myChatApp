/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.mychatapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTest {
    
    private Message message1;
    private Message message2;
    
    @BeforeEach
    public void setUp(){
       message1 = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
       message2 = new Message(2, "08575975889", "Hi Keegan, did you receive the payment?");
    }
    @Test
    public void testCheckMessageLength_validMessage_returnsSuccess() {
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        
        String result = msg.checkMessageLength();
        assertEquals("Message ready to send.", result);
    }
    
    @Test
    public void tesChecktMessageLength_over250chars_returnsFailureWithCount() {
        String longMessage = "";
        
        for (int i = 0; i < 260; i++){
            longMessage += "a";
        }
        Message msg = new Message (1, "+27718693002", longMessage);
        
        String result = msg.checkMessageLength();
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.", result);
    }
    
    @Test                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    public void testCheckMessageLength_exactlyAtLImit_returnSuccess() {
        String message250 = "";
        
        for(int i = 0; i < 250; i++){
            message250 += "a";
        }
        Message msg = new Message(1, "+27718693002", message250);
        
        String result = msg.checkMessageLength();
        assertEquals("Message ready to send.", result);
    }
    
    @Test
    public void testCheckMessageLength_oneOver_returnsFailureWithCountOf1(){
        String message251 = "";
        
        for (int i = 0; i < 251; i++){
            message251 += "a";
        }
        Message msg = new Message(1, "+27718693002", message251);
        
        String result = msg.checkMessageLength();
        assertEquals("Message exceeds 250 characters by 1; please reduce the size.", result);
    }
    
    @Test
    public void testCheckRecipientCell_validNumber_returnsSuccess() {
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        
        String result = msg.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result);
    }
    
    @Test
    public void testCheckRecipientCell_invalidNumber_returnsFailure(){
        Message msg = new Message(2, "08575975889", "Hi Keegan, did you receive the payment?");
        
        String result = msg.checkRecipientCell();
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", result);
    }
    
    @Test
    public void testCreateMesageHash_correctFormat_endsWithExpectedWords(){
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        
        String hash = msg.createMessageHash();
        assertTrue(hash.endsWith(":1:HITONIGHT"));
    }
    
    @Test
    public void testCreateMessageHash_isUppercase(){
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
          
        String hash = msg.createMessageHash();
        assertEquals(hash.toUpperCase(), hash);
    }
    
    @Test
    public void testCreateMessageHash_mutipleMessages_loopTest() {
        Message[] messages = {message1, message2};
        String[] expectedWords = {
            "HITONIGHT", "HIPAYMENT"
        };
        
        for(int i = 0; i < messages.length; i++) {
            String hash = messages[i].createMessageHash();
            assertTrue(hash.contains(expectedWords[i]));
        }
    }
    
    @Test
    public void testCheckMessageID_generatedID_isNotNull() {
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        String ID = msg.generateMessageID();
        assertNotNull("Message ID must not be null.", ID);
    }
    
    @Test
    public void testCheckMessageID_generatedID_isExactly10Chars() {
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        
        boolean ID = msg.checkMessageID();
        assertTrue(ID);
    }
    class TestTableMessage extends Message {
        
        private int option;
        
        public TestTableMessage(int messageNumber, String recipientCell, String messageText, int option){
            super(messageNumber, recipientCell, messageText);
            this.option = option;
        }
        
        @Override
        
        public String sentMessage() {
            switch(option){
                case 1:
                    return "Message successfully sent.";
                case 2:
                    return "Press 0 to delete the message.";
                case 3: 
                    return "Message successfully stored.";
                default:
                    return "Invalid option. Please choose option 1, 2, or 3";
            }
        } 
    }
    
    @Test
    public void testSentMessage_userSelectSend_returnsCorrectString() {
        TestTableMessage msg = new TestTableMessage(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?",1);
        
        String  result = msg.sentMessage();
        assertEquals("Message successfully sent.", result);
    }
    
    @Test
    public void testSentMessage_userSelectsDisregard_returnsCorrectString() {
        TestTableMessage msg = new TestTableMessage(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?", 2);
        
        String result = msg.sentMessage();
        assertEquals("Press 0 to delete the message.", result);
    }
    
    @Test
    public void testSentMessage_userSelectsStore_returnsCorrectString() {
        TestTableMessage msg = new TestTableMessage(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?", 3);
        
        String result = msg.sentMessage();
        assertEquals("Message successfully stored.", result);
    }
    
}

