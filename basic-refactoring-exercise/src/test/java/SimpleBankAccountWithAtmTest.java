
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

class SimpleBankAccountWithAtmTest {


    private static final int BASIC_DOLLAR_AMOUNT = 100;
    AccountHolder accountHolder;
    AccountHolder anotherAccountHolder;
    BankAccount atmBankAccount;

    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.anotherAccountHolder = new AccountHolder("Luigi", "Verdi", 2);
        this.atmBankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.atmBankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        this.atmBankAccount.deposit(this.accountHolder.getId(), BASIC_DOLLAR_AMOUNT);
        assertEquals(99, this.atmBankAccount.getBalance());
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
        this.atmBankAccount.deposit(this.accountHolder.getId(), BASIC_DOLLAR_AMOUNT);
        this.atmBankAccount.deposit(this.anotherAccountHolder.getId(), BASIC_DOLLAR_AMOUNT);
        assertEquals(99, this.atmBankAccount.getBalance());
    }
}
