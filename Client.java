import java.rmi.*;
import java.util.Scanner;

public class Client
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
    System.out.print("1. Use account.\n2. Create account\n3. Quit\n");
    System.out.print("Please enter a command: ");
    int command = in.nextInt();

    switch(command){
      case 1:
        accountOperations(); break;
      case 2:
        createNewAccount(); break;
      case 3:
        System.out.println("Thank you for using our Bank! See you soon.");
        System.exit(0); break;
      default:
        System.out.println("Invalid command! Shutting down...");
        System.exit(1); break;
    }
  }

  private void accountOperations(){
    try{
      int bal = this.server.balance();
      System.out.printf("Your account balance is £%d\n", bal);
      bal = this.server.deposit(200);
      System.out.printf("Your account balance is £%d\n", bal);
      bal = this.server.withdraw(123);
      System.out.printf("Your account balance is £%d\n", bal);
    } catch(Exception ex){
      System.err.print("Exception Occured: " + ex);
    }
  }

  private void createNewAccount(){
    AccountFactory af = new AccountFactory();
    try{
      this.server = af.newAccount();
    } catch(Exception ex){
      System.err.print("Exception Occured: " + ex);
    }
  }
}
