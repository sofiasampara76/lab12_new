package ua.edu.ucu.apps.Task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    void testProcessValidAmount() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.process(155));
    }

    @Test
    void testProcessExactBanknotes() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.process(100));
        assertDoesNotThrow(() -> atm.process(50));
        assertDoesNotThrow(() -> atm.process(5));
    }

    @Test
    void testProcessCombinationBanknotes() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.process(135)); // 1x100, 1x50, 1x5
    }

    @Test
    void testProcessInvalidAmount() {
        ATM atm = new ATM();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> atm.process(3));
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    void testProcessZeroAmount() {
        ATM atm = new ATM();
        assertDoesNotThrow(() -> atm.process(0));
    }
}
