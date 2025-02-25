
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

class SimpleBankAccountWithAtmTest {

    private static final int BASIC_WITHDRAW_AMOUNT = 30;
    private static final int BASIC_DEPOSIT_AMOUNT = 100;
    AccountHolder accountHolder;
    AccountHolder accountHolder2;
    BankAccount atmBankAccount;

    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.accountHolder2 = new AccountHolder("Luigi", "Verdi", 2);
        this.atmBankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.atmBankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        this.atmBankAccount.deposit(this.accountHolder.getId(), BASIC_DEPOSIT_AMOUNT);
        assertEquals(BASIC_DEPOSIT_AMOUNT - SimpleBankAccountWithAtm.ATM_FEE, this.atmBankAccount.getBalance());
    }

    @Test
    void testDepositAmountLessToAtmFee() {
        assertThrows(
            IllegalStateException.class,
            () -> this.atmBankAccount.deposit(this.accountHolder.getId(), 0)
        );
    }

    @Test
    void testWrongDeposit() {
        this.atmBankAccount.deposit(this.accountHolder.getId(), BASIC_DEPOSIT_AMOUNT);
        this.atmBankAccount.deposit(this.accountHolder2.getId(), BASIC_DEPOSIT_AMOUNT);
        assertEquals(BASIC_DEPOSIT_AMOUNT - SimpleBankAccountWithAtm.ATM_FEE, this.atmBankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final double expectedBalance = BASIC_DEPOSIT_AMOUNT - BASIC_WITHDRAW_AMOUNT - SimpleBankAccountWithAtm.ATM_FEE * 2;
        this.atmBankAccount.deposit(this.accountHolder.getId(), BASIC_DEPOSIT_AMOUNT);
        this.atmBankAccount.withdraw(this.accountHolder.getId(), BASIC_WITHDRAW_AMOUNT);
        assertEquals(expectedBalance, this.atmBankAccount.getBalance());
    }

    @Test
    void testWithdrawAmountMoreThanBalance() {
        this.atmBankAccount.deposit(this.accountHolder.getId(), BASIC_DEPOSIT_AMOUNT);
        assertThrows(
            IllegalStateException.class,
            () -> this.atmBankAccount.withdraw(this.accountHolder.getId(), BASIC_DEPOSIT_AMOUNT)
        );
    }

    @Test
    void testWrongWithdraw() {
        this.atmBankAccount.deposit(this.accountHolder.getId(), BASIC_DEPOSIT_AMOUNT);
        this.atmBankAccount.withdraw(this.accountHolder2.getId(), BASIC_WITHDRAW_AMOUNT);
        assertEquals(BASIC_DEPOSIT_AMOUNT - SimpleBankAccountWithAtm.ATM_FEE, this.atmBankAccount.getBalance());
    }

    @Test
    void testAtmBankAccountHolder() {
        assertAll(
            () -> assertSame(this.accountHolder, this.atmBankAccount.getHolder()),
            () -> assertNotEquals(this.accountHolder2, this.atmBankAccount.getHolder())
        );
    }
}
