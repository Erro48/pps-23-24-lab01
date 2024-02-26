
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

class SimpleBankAccountWithAtmTest {

    AccountHolder accountHolder;
    BankAccount atmBankAccount;

    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.atmBankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.atmBankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        this.atmBankAccount.deposit(this.accountHolder.getId(), 100);
        assertEquals(99, this.atmBankAccount.getBalance());
    }

    @Test
    void testDepositAmountLessToAtmFee() {
        assertThrows(
            IllegalStateException.class,
            () -> this.atmBankAccount.deposit(this.accountHolder.getId(), 0)
        );
    }

}
