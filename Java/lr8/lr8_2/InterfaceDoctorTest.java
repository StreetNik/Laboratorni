package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class InterfaceDoctorTest {
    @Test
    void test1(){
        Apointment doc = new Apointment("Name", "Stom", LocalDate.parse("2022-04-01"), "d", 5);
        int expected = doc.lengthOfName();
        int actual = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    void test2(){
        ArrayList<Apointment> arr = new ArrayList<Apointment>();
        String name = "Name";
        arr.add(new Apointment("Name", "Stom", LocalDate.parse("2022-04-01"), "d", 5));
        arr.add(new Apointment("Name1", "Stom", LocalDate.parse("2022-04-01"), "d", 6));
        arr.add(new Apointment("Name2", "Stom", LocalDate.parse("2022-04-01"), "d", 7));

        int sum = 0;

        for(Apointment o : arr){
            if(o.getName().equals(name)){
                sum+=o.getVisitors();
            }
        }

        int expected = sum;
        int actual = 5;

        Assert.assertEquals(expected, actual);
    }

}