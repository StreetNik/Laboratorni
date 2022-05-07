package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class WebPageTest {

    @Test
    void z1() {
        Visiting[] vis = new Visiting[3];
        vis[0] = new Visiting("test", "test.com", LocalDate.parse("2022-04-01"), 7, 3);
        vis[1] = new Visiting("test1", "test1.com", LocalDate.parse("2022-05-01"), 9, 4);
        vis[2] = new Visiting("test2", "test2.com", LocalDate.parse("2022-06-01"), 8, 5);

        int max = 0;
        LocalDate date = null;

        for(int i = 0; i < 3; i++){
            if(vis[i].getCountPages() > max){
                max = vis[i].getCountPages();
                date = vis[i].getDate();
            }
        }
        LocalDate expected = vis[2].getDate();
        Assert.assertEquals(expected, date);
    }

    @Test
    void z2() {
        Visiting[] vis = new Visiting[3];
        vis[0] = new Visiting("test", "test.com", LocalDate.parse("2022-04-01"), 7, 3);
        vis[1] = new Visiting("test1", "test1.com", LocalDate.parse("2022-05-01"), 9, 4);
        vis[2] = new Visiting("test2", "test2.com", LocalDate.parse("2022-04-10"), 10, 5);

        int sum = 0;
        int count = 0;

        LocalDate date1 = LocalDate.parse("2022-04-01");
        LocalDate date2 = LocalDate.parse("2022-05-01");
        for(Visiting o : vis){
            if(o.getDate().compareTo(date1) > 0 && o.getDate().compareTo(date2) < 0){
                sum += o.getCountUniqHost();
                count++;
            }
        }
        float expected = 10;
        Assert.assertEquals(expected, sum/count, 0);

    }

    @Test
    void z3() {
        Visiting[] vis = new Visiting[3];
        vis[0] = new Visiting("test", "test.com", LocalDate.parse("2022-04-01"), 7, 3);
        vis[1] = new Visiting("test1", "test1.com", LocalDate.parse("2022-05-01"), 9, 10);
        vis[2] = new Visiting("test2", "test2.com", LocalDate.parse("2022-04-10"), 10, 5);

        int n = 1;
        int i =0;

        for(Visiting o : vis){
            if(o.getCountUniqHost() / o.getCountPages() > n)
                i++;
        }
        float expected = 2;
        Assert.assertEquals(i, expected, 0);
    }
}