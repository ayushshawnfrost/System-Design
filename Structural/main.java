// Step 1: Design the Interface
// First, create an interface that will be implemented by the
// different account classes, but will not be known to the
// Customer class.

public interface IAccount {
    public void deposit(BigDecimal amount);
    public void withdraw(BigDecimal amount);
    public void transfer(BigDecimal amount);
    public int getAccountNumber();
}

// Step 2: Implement the Interface with one or more
// classes
// Implement the interface with classes that will be wrapped with
// the façade class. Note that in this simple example, only one
// interface is being implemented and hidden, but in practice, a
// Design Patterns | 22
// façade class can be used to wrap all the interfaces and classes
// for a subsystem.

public class Chequing implements IAccount {…}
public class Saving implements IAccount {…}
public class Investment implements IAccount {…}


// Step 3: Create the façade class and wrap the
// classes that implement the interface
// The BankService class is the façade. Its public methods are
// simple to use and show no hint of the underlying interface and
// implementing classes. The information hiding principle is
// used here to prevent client classes from “seeing” the account
// objects, and how these accounts behave – note that access
// modifiers for each Account have been set to private.


public class BankService {
    private Hashtable < int, IAccount > bankAccounts;
    public BankService() {
        this.bankAccounts = new Hashtable < int, IAccount >
    }
    public int createNewAccount(String type, BigDecimal initAmount) {
        IAccount newAccount = null;
        switch (type) {
            case "chequing":
                newAccount = new Chequing(initAmount);
                break;
            case "saving":
                newAccount = new Saving(initAmount);
                break;
            case "investment":
                newAccount = new Investment(initAmount);
                break;
            default:
                System.out.println("Invalid account type");
                break;
        }
        if (newAccount != null) {
            this.bankAccounts.put(newAccount.getAccountNumber(),
                newAccount);
            return newAccount.getAccountNumber();
        }
        return -1;
    }
    public void transferMoney(int to, int from, BigDecimal amount) {
        IAccount toAccount = this.bankAccounts.get(to);
        IAccount fromAccount = this.bankAccounts.get(from);
        fromAccount.transfer(toAccount, amount);
    }
}


// Step 4: Use the façade class to access the
// subsystem
// With the façade class in place, the client class can access
// accounts through the methods of the BankService class. The
// BankService class will tell the client what type of actions it will
// allow the client to call upon and then


public class Customer {
    public static void main(String args[]) {
        BankService myBankService = new BankService();
        int mySaving = myBankService.createNewAccount("saving",
            new BigDecimal(500.00));
        int myInvestment =
            myBankService.createNewAccount("investment", new BigDecimal(1000.00));
        myBankService.transferMoney(mySaving, myInvestment, new BigDecimal(300.00));
    }
}
