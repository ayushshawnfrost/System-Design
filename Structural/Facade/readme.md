# Façade Pattern

As systems or parts of systems become larger, they also become more complex. This is not necessarily a bad thing – if the scope of a problem is large, it may require a complex solution. Client classes function better with a simpler interaction, however. The façade design pattern attempts to resolve this issue by providing a single, simplified interface for client classes to interact with a subsystem. It is a structural design pattern.

A façade is a wrapper class that encapsulates a subsystem in order to hide the subsystem’s complexity; it acts as a point of entry into a subsystem without adding more functionality in itself. The wrapper class allows a client class to interact with the subsystem through the façade. A façade might be compared metaphorically to a waiter or salesperson, who hides all the extra work to be done in order to purchase a good or service.

Façade design patterns draw on a number of different design principles. Subsystem classes are encapsulated into a façade class. Encapsulation is also demonstrated through information hiding subsystem classes from client classes. This also represents a separation of concerns.

In summary, the façade design pattern:
- **Hides the complexity** of a subsystem by encapsulating it behind a unifying wrapper called a façade class.
- **Removes the need** for client classes to manage a subsystem on their own, which results in less coupling between the subsystem and the client classes.
- **Handles instantiation** and redirection of tasks to the appropriate class within the subsystem.
- **Provides client classes with a simplified interface** for the subsystem.
- **Acts simply as a point of entry** to a subsystem and does not add more functional subsystems.

A façade design pattern should therefore be used if there is a need to simplify the interaction with a subsystem for client classes and if there is a need for a class to instantiate other classes within your system and to provide these instances to another class. Often, façade design patterns combine interface implementation by one or more classes, which then gets wrapped by the façade class. This can be explained through a number of steps:

1. **Design the interface.**
2. **Implement the interface** with one or more classes.
3. **Create the façade class** and wrap the classes that implement the interface.
4. **Use the façade class** to access the subsystem.

Let us examine each of these steps with an example for a bank system.

In the UML diagram below, we can see that a `BankService` class acts as a façade for `Chequing`, `Saving`, and `Investment` classes. As all three accounts implement the `iAccount` interface, the `BankService` class wraps the account interface and classes and presents a simpler "front" for the `Customer` client class.
![image](https://github.com/user-attachments/assets/ad4280b6-4956-4fa5-8193-8e06d1a8d115)
