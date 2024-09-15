# Adapter Pattern

Physically, an adapter is a device that is used to connect pieces of equipment that cannot be connected directly. Software systems may also face similar issues: not all systems have compatible software interfaces. In other words, the output of one system may not conform to the expected input of another system. This frequently happens when a pre-existing system needs to incorporate third-party libraries or needs to connect to other systems. The adapter design pattern facilitates communication between two existing systems by providing a compatible interface. It is a structural design pattern.

The adapter design pattern consists of several parts:

1. **Client class**: This class is the part of your system that wants to use a third-party library or external system.
2. **Adaptee class**: This class is the third-party library or external system that is to be used.
3. **Adapter class**: This class sits between the client and the adaptee. The adapter conforms to what the client is expecting to see, by implementing a target interface. The adapter also translates the client request into a message that the adaptee will understand and returns the translated request to the adaptee. The adapter is a kind of wrapper class.
4. **Target interface**: This is used by the client to send a request to the adapter.

Translated into a diagram, the pattern looks as below:


![image](https://github.com/user-attachments/assets/517f69da-a2af-4559-afc3-0e45d7ad11c6)


![image](https://github.com/user-attachments/assets/0d5d4147-dedf-4204-bcfa-0bbfc88a9daf)


---

## Steps to Implement the Adapter Design Pattern:

1. **Design the target interface.**
2. **Implement the target interface** with the adapter class.
3. **Send the request from the client to the adapter** using the target interface.

### Example

Let us examine each of these steps using a specific example.

### Step 1: Design the target interface

Imagine an example where there is a pre-existing web client that we would like to interact with another web service. However, the service only supports JSON objects, and an adapter is needed to convert our Object request into a JSON object.

Here is the UML diagram for this situation:

First, create the target interface that your adapter class will be implementing for your client class to use:

```java
public interface WebRequester {
    public int request(Object);
}
```

### Step 2: Implement the target interface with the adapter class
The adapter class provides the methods that will take the client class’s object and convert it into a JSON object. The adapter should convert any instance of a class that the client can create and send that in a request. The adapter class also transfers the translated request to the adaptee. The client class therefore only needs to know about the target interface of the adapter.

```java
Copy code
public class WebAdapter implements WebRequester {
    private WebService service;
    
    public void connect(WebService currentService) {
        this.service = currentService;
        /* Connect to the web service */
    }
    
    public int request(Object request) {
        Json result = this.toJson(request);
        Json response = service.request(result);
        if (response != null)
            return 200; // OK status code
        return 500; // Server error status code
    }

    private Json toJson(Object input) { ... }
}
```
### Step 3: Send the request from the client to the adapter using the target interface
The web client normally returns an object back to the client. In light of this, the doWork() method should not be modified as it may disrupt other parts of the system. Instead, the Web Client should perform this behavior as normal and add in a send message method, where you can pass in the adapter, the web service, and any message you want to send.

```java
public class WebClient {
    private WebRequester webRequester;
    
    public WebClient(WebRequester webRequester) {
        this.webRequester = webRequester;
    }
    
    private Object makeObject() { … } // Make an Object
    
    public void doWork() {
        Object object = makeObject();
        int status = webRequester.request(object);
        if (status == 200) {
            System.out.println("OK");
        } else {
            System.out.println("Not OK");
        }
        return;
    }
}
```
Main Program
In the main program, the Web Adapter, the Web Service, and the Web Client need to be instantiated. The Web Client deals with the adapter through the Web Requester interface to send a request. The Web Client should not need to know anything about the Web Service, such as its need for JSON objects. The adaptee is hidden from the client by the wrapping adapter class.

```java
Copy code
public class Program {
    public static void main(String args[]) {
        String webHost = "Host: https://google.com\n\r";
        WebService service = new WebService(webHost);
        WebAdapter adapter = new WebAdapter();
        adapter.connect(service);
        WebClient client = new WebClient(adapter);
        client.doWork();
    }
}
```
Although it might be tempting to think that a solution is to simply change an interface so that it is compatible with another one, this is not always feasible, especially if the other interface is from a third-party library or external system. Changing your system to match the other system is not always a solution either, because an update by the vendors to the outside systems may break part of our system.

An adapter is an effective solution. In summary, an adapter is meant to:

Wrap the adaptee and exposes a target interface to the client.
Indirectly change the adaptee’s interface into one that the client is expecting by implementing a target interface.
Translate the client’s request into one that the adaptee is expecting.
Reuse an existing adaptee with an incompatible interface.
