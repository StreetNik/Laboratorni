package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;


class ClientTest {

    @Test
    void Test() {
        LocalDate dat1 = LocalDate.parse("2022-04-01");
        LocalDate dat2 = LocalDate.parse("2022-07-01");

        LocalDate dat3 = LocalDate.parse("2022-04-10");
        LocalDate dat4 = LocalDate.parse("2022-03-01");
        Client testCli = new Client(10, "Test", 5000);
        testCli.makeTransaction(true, 300, dat3);
        testCli.makeTransaction(false, 300, dat3);
        testCli.makeTransaction(true, 300, dat4);

        Assert.assertEquals(testCli.sumCash(dat1, dat2), 300, 0);
    }
}