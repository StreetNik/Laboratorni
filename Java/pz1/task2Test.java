package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class task2Test {

    @Test
    void z1() {
        int[] testarr =  new int[]{1, 2, 3, 4, 5, 6, 7, 8 , 9, 0};
        int[] expected = task2.Z1(testarr);
        int[] actual = new int[]{9, 8};
        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
    }
}
