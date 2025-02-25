package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    public static final int ATM_FEE = 1;
    private final BankAccount bankAccount;

	public SimpleBankAccountWithAtm(AccountHolder accountHolder, int balance) {
        this.bankAccount = new SimpleBankAccount(accountHolder, balance);
	}

    @Override
    public AccountHolder getHolder() {
        return this.bankAccount.getHolder();
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
        final double withdrawAmount = amount + ATM_FEE;
        if (withdrawAmount > this.getBalance()) {
            throw new IllegalStateException("Can't withdraw an amount more than the balance");
        }

        this.bankAccount.withdraw(userID, amount + ATM_FEE);
    }

}
