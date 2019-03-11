The EncryptDecrypt file contains two methods, which are Encryption and Decryption. I have Tested each method trhough 
through the console and they do work. Only changes that need to be made is to the main method of Employeemanagement class 
so it calls these methods to encrypt or decrypt the text files. I was having trouble doing this.

***************************
The Encrypt/Decrypt methods work by taking in a filename. The encrypt method reads the text and converts all the Text to cipher using
"AES" algorithim and Base 64 encoders. The text is converted to bytes then back to String after the encryption. Using Writer and Printer 
it writes into the specified Textfile as cipher.
The Decrypt methods works similarly but in reverse. It takes the encrypted String converts it to bytes. Then it decrypts these bytes and
converts the result back into string. Using Printers and Writers it writes into the textfile again. *Point noted a change may be made that 
keeps the textfile encrypted, but displays proper decrypted data in the console/GUI. This way the files are always secured. 

I had initally created 2 classes, one for encryption and Decryption each with their own main methods. This way the parent class can call 
on them and they run, but i was having trouble. I will let you guys take a look and let me know what to do. 
