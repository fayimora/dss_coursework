import java.rmi.*;

public class Client
{
  public static void main(String[] args)
  {
    String hostname = args[0];
    String port = args[1];
    String fullAddress = String.format("%s:%s", hostname, port);
    String URL = String.format("//%s/ATM", fullAddress);

    try {
      BankServer server = (BankServer) Naming.lookup(URL);
      int bal = server.balance();
      System.out.printf("Your account balance is £%d\n", bal);
      bal = server.deposit(200);
      System.out.printf("Your account balance is £%d\n", bal);
      bal = server.withdraw(123);
      System.out.printf("Your account balance is £%d\n", bal);

    } catch (Exception e) {
      System.err.printf("Error has occured: %s\n", e.getMessage());
    }
  }
}
