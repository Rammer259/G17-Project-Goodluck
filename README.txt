CPSC219-G17-Goodluck
VIEW FULLSCREEN
Configuring/Installing:

to configure/install the program simply download and compile all .java files (you do not need to compile the .fxml files, they are ready immediately after download) not
from the repository in a single folder which has no other files within it. Make sure you have cleared all previous versions of the program from that file directory 
before use. You must have the Java JDK installed on your PC to use this program

Operating the Program: To use the program in its current state you must launch it from the command prompt console using the "java" command. Use "java" to launch the 
program from the file "EmployeeManagement" (do not include " symbols in the command or filename).

To begin using the program you must input your user-name and password as prompted. If you do not have an account use R as prompted to generate a new admin account. Once
you have logged in you will be taken to the main menu.

The main menu will display all "tool" options. Simply enter an option into the console to use it. "COUNT" will count the number of employees and print that number to 
the console. "ADD" will allow you to add new employee names to the list of employees by appending the names to your account file. "VIEW" allow you to view the list of 
all employee names. "SEARCH" will locate the details on a specific employee. "REMOVE" will remove a specific employee. "AVAIL" will check if an employee is currently
scheduled to be working on site.

To exit the system return to the main menu and enter "QUIT" to end your session.

The Gui is currently only partially functional pending a massive program overhaul. It currently only functions for some administrator tools. Employee Tools are 
scheduled to be removed in the next published version. On the admin fuctions page all buttons have associated functions excluding set-shift which is still pending.
"View Employee Manfiest" will print a scripted version of manifest and count functions to the screen. "Add Employee" will allow the user to add an employee, "Remove
Employee" will open the currently non-functional remove function, and will dead-end the program. "Quit" or "Exit" on any page will immediately end the program.

File Manifest: Upon installation, assuming you have registered no new accounts you should have the following files

Controller.java

DataIO.java

Employee.java

EmployeeManagement.java

EmployeeManagementGUI.java

Login.fxml

LoginManager.java

Main.java

Schudule.java (yes we are aware of the mis-spelling)

Screen_Add_Employee.fxml

Screen_Confirm_Add.fxml

Screen_Confirm_Remove.fxml

Screen1.fxml

Screen2.fxml

Testing: There are JUnit tests which are automated tests to determine if the methods will function correctly. Classes include: 

EmployeeTest.java

EmployeeManagementTest.java

LoginManagerTest.java

SchuduleTest.java

Operating the tests: To compile, download JUnit and place the 2 jar files into the same folder as the program itself. From the command
prompt, typing in javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar *.java on Windows will compile everything in the folder. Next typing in 
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore <TestClass>, will run the test for that specific .java file.

NOTES:

You can find this demo in the branch "Version 3" on the project goodluck github.
