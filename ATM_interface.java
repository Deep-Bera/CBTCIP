
package CipherByte;

import java.util.*;

class atmMenu {
    Scanner sc = new Scanner(System.in);
    int balance;
    int setId = 123456789;
    int setPass = 9876;
    int id, password;
    ArrayList<String> action = new ArrayList<String>();
    ArrayList<Integer> amountArray = new ArrayList<Integer>();

    atmMenu(int id, int pass) {
        this.id = id;
        this.password = pass;
    }

    boolean checkAuthenticity() {
        return id == setId && password == setPass;

    }

    void showMenu() {
        System.out.println("""
                Enter your Choice as\s
                 1: Deposite\s
                 2: Withdraw\s
                 3: Check Balance
                 4: Transaction History\s
                 5: Exit\s""");
        int choice = sc.nextInt();
        if (choice == 1) {
            deposite();
        } else if (choice == 2) {
            withDraw();

        } else if (choice == 3) {
            checkBalance();

        } else if (choice == 4) {
            showTransaction();

        } else if (choice == 5) {
            System.out.println("Thanks for Coming ......Please Visit again..");
            System.exit(0);
        } else {
            System.out.println(" You Have Entered wrong choice ...... please Enter a correct Option");
            showMenu();
        }
    }

    void deposite() {
        System.out.println("Enter How Much Do you Want to deposite ");
        int amount = sc.nextInt();
        balance = balance + amount;
        action.add("Deposited");
        amountArray.add(amount);
        showMenu();
    }


    void withDraw() {
        System.out.println("Enter How Much Do you Want to withdraw ");
        int amount = sc.nextInt();
        if (amount > balance) {
            System.out.println("You don't have enough Balance in Your Account to withdraw this Amount");
            showMenu();
        } else {
            balance = balance - amount;
            System.out.println("Amount Withdrawn Successfully");
            action.add("Withdrawn");
            amountArray.add(amount);
            showMenu();
        }
    }


    void checkBalance() {
        System.out.println("You have : " + balance + " Balance in your Account");
        showMenu();
    }

    void showTransaction() {
        for (int i = 0; i < action.size(); i++) {
            System.out.println("You Have "+ action.get(i) + " Rs : " + amountArray.get(i)+"/-");
        }
        showMenu();
    }

}


public class ATM_interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Id ");
        int id = sc.nextInt();
        System.out.println("Enter Your Password");
        int Pass = sc.nextInt();
        atmMenu menu = new atmMenu(id, Pass);
        if (menu.checkAuthenticity()) {
            menu.showMenu();
        } else {
            System.out.println(" You Have Entered Wrong Id or Password");

        }
    }
}