# Ddecorator Design Pattern

Ek interface bana lo with some method for the core product (Pizza)
Fir ek base class bana lo uski for example base pizza
fir ek abstract decorator class bana lo implementing core product (PizzaDecorator)
fir concrete class banao saare toppings ki like sauce, origano etc. implementing the decoratoror abstract class. and call super in their constructor
in th emain class first make the object of base class with the refrence of core prodyct (Pizza)
further pass this base product to the new Topping(baseProduct) to decorate the core Product

## Applicability

 Use the Decorator pattern when you need to be able to assign extra behaviors to objects at runtime without breaking the code that uses these objects.

 The Decorator lets you structure your business logic into layers, create a decorator for each layer and compose objects with various combinations of this logic at runtime. The client code can treat all these objects in the same way, since they all follow a common interface.

 Use the pattern when it’s awkward or not possible to extend an object’s behavior using inheritance.

 Many programming languages have the final keyword that can be used to prevent further extension of a class. For a final class, the only way to reuse the existing behavior would be to wrap the class with your own wrapper, using the Decorator pattern.

## How to Implement

Make sure your business domain can be represented as a primary component with multiple optional layers over it.

Figure out what methods are common to both the primary component and the optional layers. Create a component interface and declare those methods there.

Create a concrete component class and define the base behavior in it.

Create a base decorator class. It should have a field for storing a reference to a wrapped object. The field should be declared with the component interface type to allow linking to concrete components as well as decorators. The base decorator must delegate all work to the wrapped object.

Make sure all classes implement the component interface.

Create concrete decorators by extending them from the base decorator. A concrete decorator must execute its behavior before or after the call to the parent method (which always delegates to the wrapped object).

The client code must be responsible for creating decorators and composing them in the way the client needs.

## Pros and Cons
 You can extend an object’s behavior without making a new subclass.
 
 You can add or remove responsibilities from an object at runtime.
 
 You can combine several behaviors by wrapping an object into multiple decorators.
 
 Single Responsibility Principle. You can divide a monolithic class that implements many possible variants of behavior into several smaller classes.
 
 It’s hard to remove a specific wrapper from the wrappers stack.
 
 It’s hard to implement a decorator in such a way that its behavior doesn’t depend on the order in the decorators stack.
 
 The initial configuration code of layers 

 ### Decorator lets you change the skin of an object, while Strategy lets you change the guts.
https://refactoring.guru/design-patterns/decorator

```java

 interface Pizza {
    String getDescription();
    double getCost();
}

 BasePizza implements Pizza{

    String getDescription(){
       return "This is a base Pizza";
    }
    double getCost(){
        return 4.0;
    }
}

 abstract class PizzaDecorator{
    protected Pizza basePizza;

    public PizzaDecorator(Pizza newPizza){
      this.basePizza=newPizza;
    }

    String getDescription(){
      return basePizza.getDescription();
    }

    double getCost(){
      return basePizza.getCost();
    }
}

class Mozzarella extends PizzaDecorator{

  public Mozzarella(Pizza newPizza){
      super(newPizza);
  }
  
    String getDescription(){
      return basePizza.getDescription()+ "Mozzarella";
    }

    double getCost(){
      return basePizza.getCost()+2;
    }
}

class Solution{
  public static void main(String[] args){
    Pizza myPizza=new Mozzarella(new BasePizza);

    System.out.print(myPizza.getDescription());
    System.out.print(myPizza.getCost()); 
  }
}

```
