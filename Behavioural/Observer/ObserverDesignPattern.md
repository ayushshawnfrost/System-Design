# Observer Design Pattern

The Observer Design Pattern is a behavioral design pattern that establishes a one-to-many dependency between objects, so that when one object (the subject) changes its state, all its dependent objects (observers) are automatically notified and updated. This pattern is commonly used to implement distributed event-handling systems where the subject maintains a list of observers and notifies them when an event of interest occurs.

Key Components:
Subject:

The object that holds the state and is being observed. It has a list of observers and methods to add, remove, or notify them of state changes.
Observers:

The objects that are interested in being notified about changes in the subject's state. Observers register themselves with the subject.
ConcreteSubject:

A specific subject that implements the logic to notify the observers when its state changes.
ConcreteObservers:

Specific observers that react to updates from the subject.
Structure:
Subject:

Methods: attach(observer), detach(observer), notify()
Observer:

Method: update()
ConcreteSubject: Implements the notify() method to alert all registered observers.

ConcreteObserver: Implements the update() method to respond to changes in the subject.

Example:
Consider a weather station system where multiple devices (like phone apps, computers, and displays) want to know when the weather changes. The weather station (subject) will notify all devices (observers) whenever there is an update.


```java
// Subject
public class Subject{
  private List<Observer> observers;
  int temprature;
  
  public Subject(){
    this.observer=new ArrayList<>();
  }

  void subscribe(Observer ob){
    observers.add(ob);
  }
  void unSubscribe(Observer ob){
    observer.remove(ob);
  }
  void setTemprature(int temp){
    temprature=temp;
    notifyAll();
  }
  void notifyAl(){
    for(Observer ob: observers){
      ob.update(temprature);
    }
  }
}

```

```java
// Observer Interface

public interface Observer{
  void update(int temprature);
}
```

```java
// concrete observer

public MobileObserver implements Observer{
  void update(int temperature){
    System.out.println("Mobile: the current temprature is ");
  }
}

public DesktopObserver implements Observer{
  void update(int temperature){
    System.out.println("Desktop: the current temprature is ");
  }
}
```

```java
// main

Subject sub=new Subject();
Observer mobile =new MobileObserver();
Observer desktop=new DesktopObserver();

sub.subscribe(mobile);
sub.subscribe(desktop);

sub.setTemprature(30);
sub.setTemprature(40);

```

## Key Benefits:

### Loose Coupling: Observers and subjects are loosely coupled. Observers only know that the subject exists and do not need to know the implementation details.
### Open/Closed Principle: New observers can be added without modifying the subject.

## When to Use:

### When changes in one object need to be reflected across multiple other objects without tight coupling.
### When an object should notify many other objects without being aware of them.
### Common real-world examples include event listeners in GUIs, news feeds, and stock market tickers.
