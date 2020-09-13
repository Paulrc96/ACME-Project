#ACME Excercise

Hi There IOET, this is my solution for the exercise "The company ACME" 

##Technical Data.
This excercise was made with the programing language JAVA. Besides, i used the architecnonical style MVC in order to keep the design of the project clean and order, this allow me resolve the exercise with the handling of objects.  At the same time for make unit tests i used JUnit library.

##Solution.
The excercise have a input of an .txt file with the data of the employees, for this was build a class where is the   methods for read a .txt file and return like a String. Likewise, this string it divide through the discriminant “;” in order to know when beggins the other employee and know how many employees are.

Once divide the employees, it divide the name from the schedule individual and this enter in a ArrayList of objects “Schedule” where it enter the name of the employee, the arrive time, departure time and the hours what he work in a method what calculate the range of hours what the employee worked.

In order to know the hours to pay what the employee worked with the proposed data of the excercise, it used a method where put the previously list builded plus an Array of “PayDay” Objects where its initialized with the values of the hours and the value to pay. This will allow to know how much has to pay the employee  depend the range of hours what he worked.

Finally, in order to know the total result to pay, i created another method where i put the same Array of objects “Schedule” plus an Array of range of hours who it build in the past stage. From this way to classify the days what the employee worked and calculate the total result.

##Methodology.
This excercise has an aprroach so that every method has to be distributed as much as possible in order to get an easy maintenance in face of errors and have a reuse of the methods when it whant implement new functionalities. This way of programming will allow to used this code in web programming.

##Instruccions for start the Program Locally 
* Requirements:
    * Java JDK v8.0 
    * Neatbeans IDE O Eclipse.

* Running and testing the Program: 
    *  For run the program, download or clone the project from the repository. From the IDE selected, select the option open project and choose the location where the project is downloaded, then exececute the project from the main class.
    * To execute the unit test by JUnit, enter in the folder ACME.Test and select a file to start, followed by click in execute JUnit Test.
