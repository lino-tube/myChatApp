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
      
    }
    
    @Test
    public void tesChecktMessageLength_over250chars_returnsFailureWithCount() {

    }
    
    @Test                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    public void testCheckMessageLength_exactlyAtLImit_returnSuccess() {
    }
    
    @Test
    public void testCheckMessageLength_oneOver_returnsFailureWithCountOf1(){
    }
    
    @Test
    public void testCheckRecipientCell_validNumber_returnsSuccess() {
    }
    
    @Test
    public void testCheckRecipientCell_invalidNumber_returnsFailure(){
    }
    
    @Test
    public void testCreateMesageHash_correctFormat_endsWithExoectedWords(){
    }
    
    @Test
    public void testCreateMessageHash_isUppercase(){
    }
    
    @Test
    public void testCreateMessageHash_mutipleMessages_loopTest() {
    }
    
    @Test
    public void testCheckMessageID_generatedID_isNotNull() {
    }
    
    @Test
    public void testCheckMessageID_generatedID_isExactly10Chars() {
    }
    
    @Test
    public void testSentMessage_userSelectSend_returnsCorrectString() {
    }
    
    @Test
    public void testSentMessage_userSelectsDisregard_returnsCorrectString() {
    }
    
    @Test
    public void testSentMessage_userSelectsStore_returnsCorrectString() {
    }
    
}

