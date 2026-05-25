# Chat Application Part 2

## Student Information
 Name: Linothando Tube
 Student Number: ST10533499
 Module: PROG5121

---

## Project Information
 The project now contains five classes:
  Login.java,
  Main.java,
  LoginTest.java,
  Message.java, and
  MessageTest.java.

---

## Features
 Username Validation
 We are checking if the username meets the required rules.
 The username must:
  contain an underscore (_) and 
  must not be longer than five characters.
 If the username does not meet the requirements, an error message gets displayed.
 
## Password Validation
 We are checking if the password meets the complexity requirements.
 The password must at least be 8 characters,
   contain a capital letter,
   a number, and a special character.
 If the password is incorrectly entered, an error message gets displayed.

## Cell Phone Number Validation
 We are checking if the cell phone number is correctly formatted.
 The number must:
  start with an international code +27, and 
  contain a total of 12 characters.
 If the number is invalid, an error message gets displayed and the user gets asked to re-enter the phone number.

---

## Message Features
 ### Message ID Generation
   It is a unique 10-digit message ID that gets automatically generated for every message sent.

 ### Message Length Validation
   Checks whether the message contains 250 characters or less.
   If yes, a success message for having the correct lenghth gets displayed.
   If invalid, the system displays how many characters has exceeded the limit.
   
 ### Message Hash Creation
   A message hash is automatically created using:
   the first 2 digits of the message ID,
   the message number, and
   the first and last words of the message
   The hash is displayed in uppercase format.

 ### Send Message Options
   Users can choose from the following options:
    Send Message,
    Disregard Message, and 
    Store Message to send later
   Depending on the user's option, the application displays the correct response message.

 ### Total Messages Sent
   The application keeps track of the total number of successfully sent messages.

### Display Sent Messages
  All sent messages are stored in an ArrayList and displayed back to the user after sending them.

 ### Store Messages in the JSON File
   Selected messages for storage gets saved into the messages.json file using the org.json library.
   Stored information includes:
      Message ID,
      Recipient Cell Number, and 
      Message Text
      
 ### Message Testing
   The MessageTest.java class was created to test if the message class works properly.
   The following methods were tested:
      checkMessageLength(),
      checkRecipientCell(),
      createMessageHash(),
      checkMessageID(), and
      sentMessage()

