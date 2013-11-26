import java.rmi.*;
import java.util.Scanner;

public class Client implements TestRMIServer
{
  private BankServer server;

  public static void main(String[] args)
  {
    String hostname = args[0];
    String port = args[1];
    String fullAddress = String.format("%s:%s", hostname, port);
    String URL = String.format("//%s/ATM", fullAddress);
    Scanner in = new Scanner(System.in);

    System.out.println("Connection URL is " + URL);
    try {
      BankServer server = (BankServer) Naming.lookup(URL);
      Client client = new Client(server);
      client.doShenanigans(in);
    } catch (Exception e) {
      System.err.printf("Error has occured: %s\n", e);
    }
  }

  public Client(BankServer server){
    this.server = server;
  }

  private void doShenanigans(Scanner in) throws RemoteException {
    boolean done = false;
    do {
      System.out.print("1. Use account.\n2. Create account\n3. Quit\n");
      System.out.print("Please enter a command: ");
      int command = in.nextInt();

      if(command == 1){
        System.out.print("Account number: ");
        int accNum = in.nextInt();
        accountOperations(accNum);
      }
      else if(command == 2)
        createNewAccount();
      else if(command == 3){
        System.out.println("Thank you for using our Bank! See you soon.");
        done = true;
      }
      else{
        System.out.println("Invalid command! Shutting down...");
        System.exit(-1);
      }
    }while(!done);
  }

  private void accountOperations(int accNum){
    try{
      this.server = AccountFactory.getAccount(accNum);
      int bal = this.server.balance();
      System.out.printf("Your account balance is £%d\n", bal);
      bal = this.server.deposit(200);
      System.out.printf("Your account balance is £%d\n", bal);
      bal = this.server.withdraw(123);
      System.out.printf("Your account balance is £%d\n", bal);
    } catch(Exception ex){
      System.err.println("Exception Occured: " + ex);
    }
  }

  private void createNewAccount(){
    try{
      this.server = AccountFactory.newAccount();
      System.out.printf("Welcome to your new account.\nYour account number is %d\n", this.server.getAccNo());
    } catch(Exception ex){
      System.err.println("Exception Occured: " + ex);
    }
  }

  public String sendString(int length){
    String res = "";
    for (int i=0; i<length; i++) res += "A";
    return res;
  }

  public int lengthOfString(String s){
    return s.length();
  }
}
