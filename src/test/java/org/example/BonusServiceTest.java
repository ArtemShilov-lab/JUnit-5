package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    public void shouldCalculateRegisteredBonus() {
        BonusService service = new BonusService();

        long amount = 1_000;
        boolean registered = true;

        long actual = service.calculate(amount, registered);

        assertEquals(30, actual);
    }

    @Test
    public void shouldLimitRegisteredBonus() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;

        long actual = service.calculate(amount, registered);

        assertEquals(500, actual);
    }

    @Test
    public void shouldCalculateUnregisteredBonus() {
        BonusService service = new BonusService();

        long amount = 1_000;
        boolean registered = false;

        long actual = service.calculate(amount, registered);

        assertEquals(10, actual);
    }

    @Test
    public void shouldLimitUnregisteredBonus() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;

        long actual = service.calculate(amount, registered);

        assertEquals(500, actual);
    }
}