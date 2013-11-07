import java.rmi.*;

public class Client
{
  public static void main(String[] args)
  {
    try
    {
      BankServer server = (BankServer) Naming.lookup("// myMachine /ATM ");
      int bal = server.balance();
      System.out.println (bal +" pounds in your account .");
    }
    catch ( Exception e)
    {;}
  }
}
