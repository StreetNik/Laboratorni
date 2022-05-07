package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

class RatingTest {
    @Test
    void test1(){
        int avg = 0;
        int sum = 0;

        ArrayList<Rating> arr = new ArrayList<Rating>();

        arr.add(new Rating("Test1", 123, 100));
        arr.add(new Rating("Test2", 133, 100));
        arr.add(new Rating("Test3", 143, 100));

        for(Rating o : arr){
            sum+=o.getRating();
        }
        avg = sum / arr.size();
        int actual = 100;

        Assert.assertEquals(avg, actual);
    }

    @Test
    void test2(){
        Rating test = new Rating("Test1", 123, 60);
        test.lowRating(70);
        boolean test6 = false;
        if(Rating.lowAvg.contains(test)){
            test6 = true;
        }
        boolean actual = true;
        Assert.assertEquals(test6, actual);
    }
}