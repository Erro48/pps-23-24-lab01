package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private final int ATM_FEE = 1;
    private final BankAccount bankAccount;

	public SimpleBankAccountWithAtm(AccountHolder accountHolder, int balance) {
        this.bankAccount = new SimpleBankAccount(accountHolder, balance);
	}

    @Override
    public AccountHolder getHolder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHolder'");
    }

    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        final double depositAmount = amount - ATM_FEE;
        if (depositAmount < 0) {
            throw new IllegalStateException("Can't deposit an amount less than the fee");
        }

        this.bankAccount.deposit(userID, depositAmount);
    }

    @Override
    public void withdraw(int userID, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
    }

}
