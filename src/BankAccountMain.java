import java.util.*;



public class BankAccountMain {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<BankAccount> userBankAccounts = new ArrayList();
    static Random createAccountNum = new Random();
    static boolean custHasAcct; 


static void greeting(){
    System.out.println("Hello. Welcome to the Bank of Taylortown.\nDo you need to create an account today? (yes or no)");

}
    
static void determineCustomerStatus(){
    if(scanner.nextLine().equalsIgnoreCase("yes")){
        custHasAcct = false;
        createNewAccount();
    } else {
        goToMainMenu();
    }

}

static void goToMainMenu(){
    System.out.println("Please enter your account number");
    int userAccountNum = scanner.nextInt();
    int index = -1;
    
    for (int i = 0; i < userBankAccounts.size(); i++) {
        BankAccount acc = userBankAccounts.get(i);
        if (userAccountNum == acc.getAccountNumber()) {
            index = i;
            custHasAcct = true;}}
            
            if (custHasAcct) {
                mainMenu(userBankAccounts.get(index));
            } else {
                System.out.println("Sorry, we couldn't find your account number, try again");
            }
        }


static void mainMenu(BankAccount acc){
    System.out.println("Hello " + acc.getName());
    System.out.println("What would you like to do today?");
    System.out.println(" 1. To check account balance \n 2. To make a withdrawal \n 3. To make a deposit \n 4. To make a transfer to another account \n 0. To Exit");
    int response = scanner.nextInt();

    
    while (response != 0) {
        
        if (response == 1) {
            System.out.println("Account balance: "+acc.getAccountBalance());
            break;

        } else if (response == 2) {
            System.out.println("How much would you like to withdraw?");
            double withdrawAmount = scanner.nextDouble();
            acc.withdrawal(withdrawAmount);
            System.out.println("$" + withdrawAmount + " has been taken out.");
            System.out.println("Account balance: "+acc.getAccountBalance());
            break;

        } else if (response == 3) {
            System.out.println("How much would you like to deposit?");
            double depositAmount = scanner.nextDouble();
            acc.deposit(depositAmount);
            System.out.println("$" + depositAmount + " has been added to your account.");
            System.out.println("Account balance: "+acc.getAccountBalance());
            break;
    
        } else if (response == 4) {
            System.out.println("Please enter the account number to transfer to ");
            int accountToTransferTo = scanner.nextInt();

            BankAccount toTransferTo = new BankAccount();
           
            boolean isAccountHolder = false;
            int index = -1;

            for (int i = 0; i < userBankAccounts.size(); i++) {
            BankAccount accs = userBankAccounts.get(i);
                    if (accountToTransferTo == accs.getAccountNumber()) {
                    toTransferTo = accs;
                    isAccountHolder = true;
                    index = i;
                } if (isAccountHolder) {
                    System.out.println("How much would you like to transfer?");
                    double transferAmount = scanner.nextDouble();

                    acc.transfer(toTransferTo, transferAmount);
                    System.out.println(acc.getName() + " moved " + transferAmount + " and now has " + acc.getAccountBalance());
                    System.out.println(toTransferTo.getName() + " was given " + transferAmount + " and now has " + toTransferTo.getAccountBalance());
                    System.out.println("Thank you for your visit.");
                    
                    break;
                    
                }}break;
            }
            else {System.out.println("Thank you for your visit. Goodbye.");
                break;}}
            
}



static void createNewAccount(){
    if (!custHasAcct){
        System.out.println("Okay. Let's create a new account.\nWhat will be the name on the account?");
        String newCustName = scanner.nextLine();
        System.out.println("\nWelcome " + newCustName + "!\nHow much would you like to deposit today?" );
        double newCustaccountBalance = scanner.nextDouble();
        System.out.println("\nOne moment while I create your account number...\n");
        int newCustAccountNumber = createAccountNum.nextInt(1000);
        userBankAccounts.add(new BankAccount(newCustaccountBalance , newCustName, newCustAccountNumber));
        custHasAcct = true;
        System.out.println("Here is your account info: ");
        userBankAccounts.get(userBankAccounts.size() - 1).accountDetails();
        System.out.println("\nGoing to Main Menu...\n\n");
        mainMenu(userBankAccounts.get(userBankAccounts.size() - 1));
    }
}

    
    public static void main(String[] args) throws Exception {

    
       
    //Code below creates adds account holders to the Arraylist    
        userBankAccounts.add(new BankAccount(500 , "Josh", 654));
        userBankAccounts.add(new BankAccount(5000 , "Jane", 259));
        userBankAccounts.add(new BankAccount(300 , "Peter", 159));
        userBankAccounts.add(new BankAccount(1500 , "Sam", 194));
        userBankAccounts.add(new BankAccount(7500 , "John", 178));
        
        
        
        
        

      
        greeting();
        determineCustomerStatus();
        
       
        
    }
}
