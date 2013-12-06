@SuppressWarnings("serial")
public class NoSuchAccountException extends Exception {
  public NoSuchAccountException(int accountNumber){
    super(String.format("An account with the account numner %d does not exist", accountNumber));
  }
}

