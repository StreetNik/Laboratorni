package com.company;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class task1Test {
    @org.junit.jupiter.api.Test
    void z1() {
        int[] testarr =  new int[]{1, 2, 3, 4, 5, 6, 7, 8 , 9, 0};
        int expected = task1.Z1(testarr);
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void z2() {
        int[] testarr =  new int[]{1, 2, 3, 4, 5, 6, 7, 8 , 9, 0};
        int expected = task1.Z2(testarr);
        int actual = 44;
        Assert.assertEquals(expected, actual);
    }
}
