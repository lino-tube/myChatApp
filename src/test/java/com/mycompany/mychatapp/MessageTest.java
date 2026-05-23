/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.mychatapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Linothando
 */
public class MessageTest {
    
    private Message message1;
    private Message message2;
    
    @Before
    public void setUp(){
     
    }
    @Test
    public void testCheckMessageLength_validMessage_returnsSuccess() {
        Message msg = new Message(1);
        msg.setMessageText("Hi Mike, can you join us for dinner tonight");
        String result = msg.checkMessageLength(1, "+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertEquals("Message ready to send.",result);
    }
    
    @Test
    public void tesChecktMessageLength_over250chars_returnsFailureWithCount() {
        Message msg = new Message(1);
        msg.setMessageTexT("longMessage");
        String result = msg.checkMessageLength(1, "+27718693002", "");
        assertEquals("Message exceeds 250 characters by X[enter number here]; please reduce the size.", result);
    }
    
    @Test                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    public void testCheckMessageLength_exactlyAtLImit_returnSuccess() {
    }
}

