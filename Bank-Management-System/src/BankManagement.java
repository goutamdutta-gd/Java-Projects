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
                        String name = in.next();
                        System.out.println("Enter your phone number");
                        int phonenumber = in.nextInt();
                        System.out.println("Enter your pin");
                        int pin = in.nextInt();
                        Account a = new Account(name, pin, phonenumber, nextAccountNumber);
                        acc.put(nextAccountNumber, a);
                        nextAccountNumber++;
                        System.out.println("Your account number is: " + a.getaccountNumber());
                                
                        break;
                    

                case 2:
                    
                        int choice;
                        do{
                            System.out.println("1. Deposit Money");
                            System.out.println("2. Withdraw Money");
                            System.out.println("3. Show Balance");
                            System.out.println("4. Show Transactions");
                            System.out.println("5. Log Out");
                            System.out.println("Enter choice");
                            choice = in.nextInt();

                            switch (choice) {
                                case 1:
                                    {
                                        System.out.println("Enter account number: ");
                                        int accn = in.nextInt();
                                        System.out.println("Enter your pin: ");
                                        int bpin = in.nextInt();
                                        System.out.println("Enter amount: ");
                                        double amount = in.nextDouble();

                                        Account account = acc.get(accn);

                                        if (account == null) {
                                            System.out.println("Account not found");
                                            break;
                                        }

                                        int cnt = 3;

                                        while (cnt != 0) {

                                            if (account.getpin() == bpin) {
                                                if (amount <= 0) {
                                                    System.out.println("Amount must be greater than 0.");
                                                    break;
                                                }

                                                account.deposit(amount);
                                                System.out.println("Deposit successful");
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
                                        System.out.println("Enter account number: ");
                                        int accn = in.nextInt();
                                        System.out.println("Enter your pin: ");
                                        int bpin = in.nextInt();
                                        System.out.println("Enter amount: ");
                                        double amount = in.nextDouble();

                                        Account account = acc.get(accn);

                                        if (account == null) {
                                            System.out.println("Account not found");
                                            break;
                                        }

                                        int cnt = 3;

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
                                        System.out.println("Enter account number: ");
                                        int accn = in.nextInt();
                                        System.out.println("Enter your pin: ");
                                        int bpin = in.nextInt();

                                        Account account = acc.get(accn);

                                        if (account == null) {
                                            System.out.println("Account not found");
                                            break;
                                        }

                                        int cnt = 3;

                                        while (cnt != 0) {

                                            if (account.getpin() == bpin) {
                                                System.out.println("Your balance is: "+account.showbalance());
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
                                        System.out.println("Enter account number: ");
                                        int accn = in.nextInt();
                                        System.out.println("Enter your pin: ");
                                        int bpin = in.nextInt();

                                        Account account = acc.get(accn);
                                        if (account == null) {
                                            System.out.println("Account not found");
                                            break;
                                        }

                                        int cnt = 3;

                                        while (cnt != 0) {

                                            if (account.getpin() == bpin) {
                                                account.personaldata();
                                                account.showTransactions();
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
                                        System.out.println("Thank you");
                                        break;
                                    }
                                default:
                                    System.out.println("Invalid choice");
                                    break;

                                
                            }
                            
                        }while(choice!=5);
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
    private  int phonenumber;
    private double balance;
    private int accountnumber;

    private ArrayList<String> transactions = new ArrayList<>();


    Account(String name, int pin, int phonenumber, int nextAccountNumber){
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

    void showTransactions() {
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
