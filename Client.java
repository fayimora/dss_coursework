import java.rmi.*;

public class Client
{
  private BankServer server;
  public static void main(String[] args)
  {
    String hostname = args[0];
    String port = args[1];
    String fullAddress = String.format("%s:%s", hostname, port);
    String URL = String.format("//%s/ATM", fullAddress);

    System.out.println("Connection URL is " + URL);
    try {
      BankServer server = (BankServer) Naming.lookup(URL);
      Client client = new Client(server);
      client.doShenanigans();
    } catch (Exception e) {
      System.err.printf("Error has occured: %s\n", e);
    }
  }

  public Client(BankServer server){
    this.server = server;
  }

  private void doShenanigans() throws RemoteException {
    int bal = this.server.balance();
    System.out.printf("Your account balance is £%d\n", bal);
    bal = this.server.deposit(200);
    System.out.printf("Your account balance is £%d\n", bal);
    bal = this.server.withdraw(123);
    System.out.printf("Your account balance is £%d\n", bal);
  }
}
