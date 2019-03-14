# CPSC219-G17-Goodluck
Configuring/Installing: 

to configure/install the program simply download and compile all .java files (you do not need to compile the .fxml files, they are ready immediately after download) not from the repository in a single folder which has no other files within it. Make sure you have cleared all previous versions of the program from that file directory before use. You must have the Java JDK installed on your PC to use this program

Operating the Program:
To use the program in its current state you must launch it from the command prompt console using the "java" command. Use "java" to launch the program from the file "EmployeeManagement" (do not include " symbols in the command or filename). 

To begin using the program you must input your full name. If you have already registered with the system you will be prompted to enter your password. If you are using this program for the first time, you will have to register an account which creates a text file in the folder. Simply enter your password to access the main menu and if you do not have a registered account, you will be prompted to create password (use no spaces in this password) for the account. Choosing your password will register your new account. 

The main menu will display all "tool" options. Simply enter an option into the console to use it. "COUNT" will count the number of employees and print that number to the console. "ADD" will allow you to add new employee names to the list of employees by appending the names to your account file. "VIEW" allow you to view the list of all employee names.

To exit any tool simply enter "/back" when prompted for input within the tool. This will return you to the main menu. Once in the main menu entering "x" or "X" will exit the program.

The Gui is currently for demonstration usage only. It does not require a correct password or username to function, and does not check if the user is an administrator. Checking the adminstrator radio button allows the program to decide whether to allow you to access basic functions only, or all functions. The Quit button will immediately end the program. To run it, compile Main.java, and Controller.Java, then run Main.class.

File Manifest:
Upon installation, assuming you have registered no new accounts you should have the following files

Main.Java

Controller.Java

Login.fxml

Screen1.fxml

Screen2.fxml

EmployeeManagement.Java

ReadFile.Java

MenuTools.Java

EmployeeManagement.Class

ReadFile.Class

MenuTools.Class

EncryptDecrypt.java

NOTES:

The EncryptionDecryption class is functional in its ability to encrypt and decrypt data from text files and print the data as string back into the textfiles. Currently the Encryption System is set to read a file name "JohnCena.txt", with further work it will take in a file name from the main method and encrypt all files created. To run the Encryption just create a File called JohnCena with data inside  in the same folder and run the EncryptionDecryption Class. The Main Method inside the class will run the process
