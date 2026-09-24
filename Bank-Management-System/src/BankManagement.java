import java.util.*;

class BankManagement{
    static int nextAccountNumber = 100000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int choice1;
        HashMap<Integer, Account> acc = new HashMap<>();
        
        
        do{
            System.out.println("==========WELCOME TO OUR BANK========");
            System.out.println("Enter your choice: ");
            System.out.println("1. Create a new Account");
            System.out.println("2. Have an existing account");
            System.out.println("3. Exit");
            choice1 = in.nextInt();
            switch (choice1) {
                case 1:
                    
                        
                        System.out.println("Enter your name");
                        String name = in.nextLine();
                        String phonenumber;
                        while(true) {
                            System.out.println("Enter your phone number");
                            phonenumber = in.next();

                            if(phonenumber.length() == 10)
                                break;

                            System.out.println("Enter 10 digits phone number");
                        }

                        
                        int pin = 0;
                        while(true) {
                            System.out.println("Enter your PIN");
                            pin = in.nextInt();

                            int npin = pin;
                            int n = 0;

                            while(npin != 0) {
                                n++;
                                npin /= 10;
                            }

                            if(n == 6)
                                break;

                            System.out.println("Enter 6 digits PIN");
                        }
                        Account a = new Account(name, pin, phonenumber, nextAccountNumber);
                        acc.put(nextAccountNumber, a);
                        nextAccountNumber++;
                        System.out.println("Your account number is: " + a.getaccountNumber());
                                
                        break;
                    

                case 2:
                        System.out.println("Enter account number: ");
                        int accn = in.nextInt();
                        System.out.println("Enter your pin: ");
                        int bpin = in.nextInt();
                        int choice;

                        Account account = acc.get(accn);
                        if (account == null) {
                            System.out.println("Account not found");
                            break;
                        }
                        int cnt = 3;

                        while (cnt != 0) {

                            if (account.getpin() == bpin) {
                                do{
                                    System.out.println("1. Deposit Money");
                                    System.out.println("2. Withdraw Money");
                                    System.out.println("3. Show Balance");
                                    System.out.println("4. Show Transactions");
                                    System.out.println("5. Send Money");
                                    System.out.println("6. Log Out");
                                    System.out.println("Enter choice");
                                    choice = in.nextInt();

                                    switch (choice) {
                                        case 1:
                                            {
                                                System.out.println("Enter amount: ");
                                                double amount = in.nextDouble();
                                                System.out.println("Enter your pin: ");
                                                bpin = in.nextInt();

                                                account = acc.get(accn);

                                                if (account == null) {
                                                    System.out.println("Account not found");
                                                    break;
                                                }

                                                cnt = 3;

                                                while (cnt != 0) {

                                                    if (account.getpin() == bpin) {
                                                        if (amount <= 0) {
                                                            System.out.println("Amount must be greater than 0.");
                                                            break;
                                                        }

                                                        account.deposit(amount);
                                                        System.out.println("Deposit successful");
                                                        System.out.println();
                                                        break;
                                                    }

                                                    cnt--;

                                                    if (cnt > 0) {
                                                        System.out.println("Invalid Pin. Try again!");
                                                        bpin = in.nextInt();
                                                    } else {
                                                        System.out.println("Too many incorrect attempts.");
                                                    }
                                                }
                                                break;
                                            }
                                        case 2:
                                            {    
                                                System.out.println("Enter amount: ");
                                                double amount = in.nextDouble();
                                                System.out.println("Enter your pin: ");
                                                bpin = in.nextInt();

                                                account = acc.get(accn);

                                                if (account == null) {
                                                    System.out.println("Account not found");
                                                    break;
                                                }

                                                cnt = 3;

                                                while (cnt != 0) {

                                                    if (account.getpin() == bpin) {
                                                        if (amount <= 0) {
                                                            System.out.println("Amount must be greater than 0.");
                                                            break;
                                                        }

                                                        if (account.showbalance() < amount) {
                                                            System.out.println("Insufficient Balance.");
                                                            break;
                                                        }

                                                        account.withdraw(amount);
                                                        System.out.println("Withdraw successful");
                                                        System.out.println();
                                                        break;

                                                    }

                                                    cnt--;

                                                    if (cnt > 0) {
                                                        System.out.println("Invalid Pin. Try again!");
                                                        bpin = in.nextInt();
                                                    } else {
                                                        System.out.println("Too many incorrect attempts.");
                                                    }
                                                }
                                                break;

                                            }
                                        
                                        case 3:
                                            {
                                                System.out.println("Enter your pin: ");
                                                bpin = in.nextInt();

                                                account = acc.get(accn);

                                                if (account == null) {
                                                    System.out.println("Account not found");
                                                    break;
                                                }

                                                cnt = 3;

                                                while (cnt != 0) {

                                                    if (account.getpin() == bpin) {
                                                        System.out.println("Your balance is: "+account.showbalance());
                                                        System.out.println();
                                                        break;
                                                    }

                                                    cnt--;

                                                    if (cnt > 0) {
                                                        System.out.println("Invalid Pin. Try again!");
                                                        bpin = in.nextInt();
                                                    } else {
                                                        System.out.println("Too many incorrect attempts.");
                                                    }
                                                }
                                                break;
                                            }

                                        case 4:
                                            {
                                                System.out.println("Enter your pin: ");
                                                bpin = in.nextInt();

                                                account = acc.get(accn);
                                                if (account == null) {
                                                    System.out.println("Account not found");
                                                    break;
                                                }

                                                cnt = 3;

                                                while (cnt != 0) {

                                                    if (account.getpin() == bpin) {
                                                        account.personaldata();
                                                        account.showTransactions();
                                                        System.out.println();
                                                        break;
                                                    }

                                                    cnt--;

                                                    if (cnt > 0) {
                                                        System.out.println("Invalid Pin. Try again!");
                                                        bpin = in.nextInt();
                                                    } else {
                                                        System.out.println("Too many incorrect attempts.");
                                                    }
                                                }
                                                break;
                                            }
                                            
                                        case 5:
                                            {
                                                System.out.println("Enter receiver's account number: ");
                                                int raccn = in.nextInt();
                                                Account receiver = acc.get(raccn);

                                                System.out.println("Enter amount to send");
                                                double amount = in.nextDouble();
                                                System.out.println("Enter your pin: ");
                                                bpin = in.nextInt();
                                                if (receiver == null) {
                                                    System.out.println("Account not found");
                                                    break;
                                                }

                                                cnt = 3;

                                                while (cnt != 0) {

                                                    if (account.getpin() == bpin) {
                                                        if (account.sendMoney(amount, receiver)) {
                                                            System.out.println("Money Transferred Successfully");
                                                        }
                                                        break;
                                                    }

                                                    cnt--;

                                                    if (cnt > 0) {
                                                        System.out.println("Invalid Pin. Try again!");
                                                        bpin = in.nextInt();
                                                    } else {
                                                        System.out.println("Too many incorrect attempts.");
                                                    }
                                                }
                                                break;
                                            }

                                        case 6:
                                            {
                                                System.out.println("Thank you");
                                                break;
                                            }
                                        default:
                                            System.out.println("Invalid choice");
                                            break;

                                        
                                    }
                                    
                                }while(choice!=6);
                                break;
                            }

                            cnt--;

                            if (cnt > 0) {
                                System.out.println("Invalid Pin. Try again!");
                                bpin = in.nextInt();
                            } else {
                                System.out.println("Too many incorrect attempts.");
                            }
                        }
                        break;
                        
                    
                    case 3: System.out.println("Thank You for visiting our bank"); break;

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }while(choice1 != 3);

        
    }
}

class Account{
    private String name;
    private  int pin;
    private  String phonenumber;
    private double balance;
    private int accountnumber;

    private ArrayList<String> transactions = new ArrayList<>();


    Account(String name, int pin, String phonenumber, int nextAccountNumber){
        this.name = name;
        this.pin = pin;
        this.phonenumber = phonenumber;
        accountnumber = nextAccountNumber;
    }

    void personaldata(){
        System.out.println("Account Number: "+accountnumber);
        System.out.println("Name: "+ name);
        System.out.println("Phone number: "+phonenumber);
        System.out.println("Balance: "+balance);
    }

    int getaccountNumber(){
        return accountnumber;
    }

    int getpin(){
        return pin;
    }

    void deposit(double amount){
        balance += amount; 
        transactions.add("Deposited: " + amount);
    }

    void withdraw(double amount){
        balance -= amount;
        transactions.add("Withdrawn: " + amount);
    }

    double showbalance(){
        return balance;
    }

    boolean sendMoney(double amount, Account receiver) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return false;
        }

        if (this == receiver) {
            System.out.println("You cannot send money to your own account.");
            return false;
        }

        if (this.balance < amount) {
            System.out.println("Insufficient Balance.");
            return false;
        }

        this.balance -= amount;
        receiver.balance += amount;

        this.transactions.add(
            "Sent: " + amount + " to Account: " + receiver.accountnumber
        );

        receiver.transactions.add(
            "Received: " + amount + " from Account: " + this.accountnumber
        );
        return true;
    }

    void showTransactions() {
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
