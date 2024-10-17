# Stratergy Design Pattern

The Strategy Design Pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime. Instead of implementing a single algorithm directly, the code receives runtime instructions on which in a family of algorithms to use. This allows algorithms to be interchangeable and lets you change the behavior of a class by changing its algorithm without altering the client code that uses it.

## Key Components of the Strategy Pattern:

**Strategy Interface (Strategy):** This defines a common interface for all algorithms. Each concrete strategy will implement this interface and provide its own version of the algorithm.

**Concrete Strategies (ConcreteStrategy):** These are different implementations of the strategy interface, each containing its own algorithm or behavior.

**Context:** This is the class that utilizes a strategy. It is configured with an instance of the strategy interface and delegates execution to that strategy at runtime.

Example:
Let’s say you’re developing a payment system where a user can pay using a credit card, PayPal, or cryptocurrency. The strategy pattern allows the system to switch between these payment methods easily.


```java

class ShopingCart{
// Context:
  private PaymentStratergy ps;

  public ShoopingCart(PaymentStratergy ps){
    this.ps=ps;
  }

  public void checkout(int amount){
    ps.pay(amount);
  }

}
```

```java
// Strategy Interface:
interface PaymentStratergy{
  void pay(int amount);
}
```

```java
// Concrete Stratergy
class PayPal implements PaymentStratergy{
  void pay(int amount){
    System.out.println("I am using payPal to pay");
  }
}
```

```java
// Concrete Stratergy
class CreditCard implements PaymentStratergy{
  void pay(int amount){
    System.out.println("I am using Credit Card to pay");
  }
}
```

```java
class Solution {

public static void main(String[] args){
  ShoppingCart cart=new ShoppingCart(new PayPal())
  
  cart.checkout(200);
}
}
```



### Key Benefits:
  Open/Closed Principle: You can add new strategies without changing the existing code.
  Encapsulation: Each algorithm is encapsulated in its own class, making the system easier to understand and maintain.
  Flexibility: Allows switching algorithms at runtime.

### When to Use:
  When you have multiple algorithms for a specific task and want to choose one dynamically.
  When you want to avoid conditional statements (like if-else or switch) to select different behaviors.
