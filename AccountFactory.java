import java.rmi.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

class AccountFactory
{
  public static HashMap<Integer, BankServer> accountsTable = new HashMap<Integer, BankServer>();

  public static BankServer newAccount() throws RemoteException {
    int accountNumber = Math.abs(new Random().nextInt());
    BankServer s = new BankServerImpl(accountNumber);
    accountsTable.put(accountNumber, s);
    return s;
  }

  public static BankServer getAccount(int accountNumber) throws NoSuchAccountException {
    if(accountsTable.containsKey(accountNumber))
      return accountsTable.get(accountNumber);
    else
      throw new NoSuchAccountException(accountNumber);
  }

  /* private static HashMap<Integer, BankServer> getAccounts(){ */
  /*   return accountsTable; */
  /* } */
}
