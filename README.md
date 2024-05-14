# Queue Management System

More explanations can be found [here](</Documentation resources/Documentation.pdf>).

## Contents

- [Assignment Objectives](#Assignment-Objectives)
- [Problem Analysis](#Problem-analysis)
- [Design](#Design)
- [Implementation](#Implementation)
- [Results](#Results)
- [Conclusions](#Conclusions)
- [References](#References)
- [Pictures](#Pictures)

## Assignment Objective

Consider an application Orders Management for processing client orders for a warehouse. Relational databases should be used to store the products, the clients, and the orders. The application should be designed according to the layered architecture pattern and should use (minimally) the following classes: 
-	Model classes – represent the data models of the application.
-	Business Logic classes – contain application logic.
-	Presentation classes – GUI related classes.
-	Data access classes – classes that contain access to the database.

***Note**: Other classes and packages can be added to implement the functionality of the application.*


## Problem analysis

The assignment asks to implement an application that manages a simple warehouse. It replicates a real-life scenario: any on-line shop must keep track of what products it sells, the available quantity, the clients that regularly buy, their order, and a history of the bills that have been issued. This kind of work is predisposed to creating errors if it is handled by people because of the several things one should keep in mind. However, it is possible to simplify it if an application is designed. A graphical user interface helps even more with the management due to the intuitive interaction between it and an unspecialized user. These are the main guidelines I followed while implementing this assignment. I tried to create an intuitive graphical user interface that does not require computer science knowledge.

The assignment aims to familiarize one with the layered architecture and the reflection techniques provided by the Java programming language. In addition to this, one must work with a relational database management system to ensure data preservation. I chose PostgreSQL.

To store the data (clients, orders, bills, and products), I designed a simple relational database composed of four tables: client, order, log, and product. Each table has a primary key called ‘id’. The order table has two foreign keys to the product and client tables because the order is implemented as a one-to-one relation between one client and one product. For simplicity only one product can be part of one specific order, placed by one client, however, the same client can place multiple orders that request different products. This does not resemble a real-life scenario, where one order houses multiple products, but such a functionality is not requested by the text of the assignment.

The client relation has four fields: a name, a phone number, an address, and an id (unique identification number). These fields are not exhaustive for a client entity, but model accurately what information a shop may require for each person that wants to buy something from them (supposing the shop ships orders remotely).

The product relation has four fields, too: a product name, a stock, a price per unit, and an id (unique identification number). The fields store only the relevant information that one requires to know when products are inside the warehouse: how they are called, how much of each product is available to sell and what price one unit of that product costs.

The order relation has four fields: a client id, a product id, a quantity, and an id (unique identification number). The first two fields are linked to the client and product tables by means of foreign keys. For each order that is placed, an entry in the log table is generated, that the assignment calls bill. The log is linked to the id field in the order table (also, by means of a foreign key) and it stores the amount of money the order is worth. The order stores the quantity the client wants to buy of a certain product and when the order is placed, the price of the order is computed and, together with the id of the related order, stored in the log table.

The database used while developing this project is stored in the form of an SQL dump file available [here](</Documentation resources/warehouse_dump_file.sql>).

The application is developed and designed to run in a Java Integrated Development Environment such as IntelliJ Idea, Eclipse IDE etc. Once the project is run a pop-up window will appear which is called the Start Panel (housed inside the Main Frame of the application). Four buttons redirect the user to the specific view that executes the create, read, update, and delete operations on the database. The product, the client and the log views have the same structure: on the left side there are buttons that open the input panels for the CRUD operations. In the right part of the window there is the place where input data is inserted, if necessary. In the lower part of the window the BACK button redirects the user to the starting view, while the EXECUTE button executes the SQL statement. If the data does not comply with the expected format, the execution of the statements fail, and warnings are displayed in the console. If the execution is successful an info message is displayed in the console, as well. The order view is somewhat special because the panel where the order can be created contains two selectors that let the user choose only between existing clients and products. However, a quantity input field is provided. All input fields must respect hard-coded regex patterns.

***NOTE**: At any time, the application can be closed if the close button (X) in the top right corner is pressed.*

The user diagram describes the dependencies between the user’s interactions and the system represented by the Warehouse Management System Application. The user can manage the database as described in the above paragraphs.

<p align="center">
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/cab64bf6-6180-4b30-874f-584602e3b1e2" alt="Use_case_diagram"/>
</p>

## Design

The application tries to follow the layered architecture pattern. Four packages have been developed: presentation, business logic, model, data access. Each package represents a layer, and each one is independent of the others. This aspect favors the modularity and the portability of the application: any layer can be redesigned using different technologies without affecting the other layers if the connections between them are preserved. Further development capabilities are enhanced as well.

The presentation package contains all the components of the graphical user interface. The package contains two directories: utility and classes. The utility directory contains classes that are responsible for the swapping between views, sending requests to the business logic layer, and general color palette. The classes are not redundant or exhaustive and some could be merged by means of reflection or generics. In the classes directory the view objects are placed. These are what the user can see and interact with. To me, their design is intuitive and simple. The structure of the GUI is based on a main frame, that houses more panels due to a card layout. Each such panel is created by smaller panels that store different components such as the operation buttons, the back button, the main panel. The layout of the main panel is also a card layout enabling the application to work in a single window. However, based on the input data a pop-up window may appear and indicate that the operation failed and the cause of failure.

The business logic layer stores immutable classes, one for each relation in the database (implemented as Java records). In addition to these, in the utility director regex-based validators are placed. Multiple types of validators have been created: id validator, person name validator, address validator, phone number validator etc. They are used to check the input data that is coming from the presentation layer. If these input strings represent valid fields of a database relation they are stored into such objects. Following this, they are converted into entities or data transfer objects. 

The data transfer objects are part of the model package. They represent immutable classes (Java records) that store data that complies with a database relation format (client, order, product, or bill). The difference between them and the classes instantiated in the business layer package is that the model records store data in the desired format (integer, string, Boolean etc.). The classes in the business layer package store data as valid strings.

The data access package contains a utility directory where the connection to the database object is stored, an enumeration of the possible SQL queries that are used and an abstract class that implements those general CRUD operations/queries. The other directory, called classes, stores the specific data abstract object, one for each database relation. Here specific queries such as find by id (that is not required to be implemented for all database tables). Other specific queries related to one specific database relation can be instantiated in these DAO classes.

The class diagram is available [here](</Documentation resources/class_diagram.png>).

<p align="center">
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/682a9f40-02bc-4691-8762-270db7aba63f" alt="Package_diagram"/>
</p>

## Implementation

The implementation of the classes and of the main methods is discussed in the Javadoc files that are available [here](</Documentation resources/Javadoc>).

## Results

I have tested the functionality of each operation multiple times. No errors have appeared.

## Conclusions

This assignment proved to be a bit challenging for me because I have never worked before with threads before. The main issue I had was to keep track of the independently running threads especially because I had to adapt the classical way to debug (in console) I am used to so that I could handle and understand the parallel evolution of the program. Another challenge was to break down the application itself into independent modules that can perform more general tasks or are (more or less) open to extension while keeping it simple and easy to understand. I got more familiar to layouts, panels, how they interact and how a more complex window can be designed. I have used group buttons for the first time and tried frame by frame generation. I practiced the decomposition of classes into subclasses and aimed the design short and effective methods that are more suitable to the Java style.

The final application is not the best it can be for sure. I consider its main defects to be the graphical user interface implementation (the code is a bit chaotic). However, the GUI looks decent, is practical and does its job. The backend structure could be optimized as well.

Other further developments:
- Improved class design for the GUI.
- Improved and simplified inter-class connections.
- Improved, simplified, and more specialized intra-class connections.
- New possible strategies for implementation.
- Cleaner, more explicit code style.

## References

- [Unified Modeling Language](https://en.wikipedia.org/wiki/Unified_Modeling_Language)
- [Use Case Diagrams | Unified Modeling Language (UML)](https://www.geeksforgeeks.org/use-case-diagram/)
- [Draw.io](https://app.diagrams.net/)
- [RegExr: Learn, Build, & Test RegEx](https://regexr.com/)
- [regex101: build, test, and debug regex](https://regex101.com/)
- [Regular expression - Wikipedia](https://en.wikipedia.org/wiki/Regular_expression)
- [Use Case Diagram Tutorial](https://creately.com/guides/use-case-diagram-tutorial/)
- [A Visual Guide to Layout Managers](https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#border)
- [Fundamental Programming Techniques lectures, laboratories, and support materials](https://dsrl.eu/)
- [Java Thread Pool Example using Executors and ThreadPoolExecutor](https://www.javacodegeeks.com/2013/01/java-thread-pool-example-using-executors-and-threadpoolexecutor.html)
- [java.util.Timer.schedule() Method](https://www.tutorialspoint.com/java/util/timer_schedule_period.htm)
- [Lesson: Concurrency (The Java™ Tutorials > Essential Java Classes)](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
- [Runnable vs. Callable in Java](https://www.baeldung.com/java-runnable-callable)
- [Introduction to JDBC](https://www.baeldung.com/java-jdbc)
- [Layers of a Standard Enterprise Application](https://dzone.com/articles/layers-standard-enterprise)
- [Introduction to JavaDoc](https://www.baeldung.com/javadoc)
- [Java 14 Record Keyword](https://www.baeldung.com/java-record-keyword)
- [PostgreSQL | IntelliJ IDEA Documentation](https://www.jetbrains.com/help/idea/postgresql.html)
- [Setting up the JDBC Driver | pgJDBC](https://jdbc.postgresql.org/documentation/setup/)
- [Reflection](https://www.geeksforgeeks.org/reflection-in-java/)
- [Guide to Java reflection](https://www.baeldung.com/java-reflection)
- [Java records](https://www.geeksforgeeks.org/what-are-java-records-and-how-to-use-them-alongside-constructors-and-methods/)
- Paul Deitel, Harvey Deitel, Java How to program (10th edition), Publisher: Pearson Education, Inc., Upper Saddle River, NJ, United States, ISBN: 978-0-13-380780-6, Published: 2015
- Ștefan Tanasă, Ștefan Andrei, Cristian Olaru, Java: de la 0 la expert (2nd edition), Publisher: Polirom, Iași, Romania, ISBN: 978-973-46-2405-8, Published: 2011

## Pictures

<p align="center">
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/1638ae0d-c47c-4861-a9a4-98fa914256bc" alt="App_image_1"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/94a7c6a6-efae-4d12-8504-b0d83351ba1d" alt="App_image_2"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/0ad35fdf-093e-4f66-9614-ae274ba1d9e8" alt="App_image_3"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/39f1e3f2-093a-4498-b53f-aed2357805cb" alt="App_image_4"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/640bc578-7a0e-4c84-a870-6baece89363d" alt="App_image_5"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/433390c2-97ba-493c-8260-4cfb9e4bf90d" alt="App_image_6"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/bacec324-e83e-4ac2-af50-c2cb95fb871b" alt="App_image_7"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/1657e701-8561-4e83-91d9-75dbd1f03b22" alt="App_image_8"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/227c8f87-ac1f-4ff8-96cc-63c669d1a084" alt="App_image_9"/>
  <img src="https://github.com/l7aur/Warehouse-Management-System/assets/81981519/2f06bf47-d365-45c1-94a6-805a5038ccf8" alt="App_image_10"/>
</p>
