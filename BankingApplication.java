import java.util.*;
import java.lang.*;

public class BankingApplication {
    public static void main (String args[]) {
        //Scanner sc = new Scanner (System.in);
        BankAccount ob = new BankAccount("ABC", "ABC000D123");
        ob.showMenu();
        //sc.close();
    }
}

class BankAccount {
    int bal, prev_trans;
    String custName, custId;
    BankAccount(String custName, String custId) {
        this.custName = custName;
        this.custId  = custId;
    }
    void deposit(int amt) {
        if (amt != 0) {
            bal = bal + amt;
            prev_trans = amt;
        }
    }
    void withdraw(int amt) {
        if (amt != 0) {
            bal = bal - amt;
            prev_trans = - amt;
        }
    }
    void getPrevTrans() {
        if(prev_trans > 0){
            System.out.println(prev_trans+"  rupees  is deposited.");
        }
        else if(prev_trans < 0) {
            System.out.println(Math.abs(prev_trans)+" rupees is withdrawn.");
        }
        else{
            System.out.println("No transaction occured.");
        }
    }
    void showMenu() {
        char option = '\0';
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to our Branch, "+custName);
        System.out.println("Your Customer Id is "+custId);
        System.out.println("\n");
        System.out.println("YOUR OPTIONS:");
        System.out.println("A. Check you account balance.");
        System.out.println("B. Deposite amount");
        System.out.println("C. Withdraw amount");
        System.out.println("D. See the previous transaction.");
        System.out.println("E. Close/Exit");

        do{
            System.out.println("----------------***-----------------***-----------------");
            System.out.println("Enter an option you have choose");
            // System.out.println(----------**------------------------**---------------------);
            option = scan.next().charAt(0);
            System.out.println("\n");

            switch(option) {
                case 'A':
                    System.out.println("Your account balance is:");
                    System.out.println(bal);
                    System.out.println('\n');
                    break;
                case 'B':
                    System.out.println("Enter the amount to deposit:");
                    int amt1 = scan.nextInt();
                    deposit(amt1);
                    System.out.println('\n');
                    break;
                case 'C':
                    System.out.println("Enter the amount to withdraw:");
                    int amt2 = scan.nextInt();
                    withdraw(amt2);
                    System.out.println('\n');
                    break;
                case 'D':
                    //System.out.println("Enter the amount to deposit:");
                    getPrevTrans();
                    System.out.println('\n');
                    break;
                default:
                    System.out.println("Invalid Option !! Try again.");
            }
        }while(option != 'E');
        System.out.println("Thank you for using our Netbanking Service.");
    }   
    //scan.close();
}
