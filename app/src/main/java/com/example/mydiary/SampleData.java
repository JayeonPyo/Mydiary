package com.example.mydiary;

import java.util.ArrayList;

public class SampleData {

    ArrayList<Test> items = new ArrayList<>();

    public ArrayList<Test> getItems() {

        Test test1 = new  Test("http://static.hubzum.zumst.com/hubzum/2018/02/06/09/962ec338ca3b4153b037168ec92756ac.jpg",
                "action", "Black Panther", "this movie open in 2018.01");

        Test test2 = new Test("https://t1.daumcdn.net/cfile/tistory/0138F14A517F77713A",
                "action", "Iron Man 3", "this movie open in 2013.04");

        Test test3 = new Test("https://i.ytimg.com/vi/5-mWvUR7_P0/maxresdefault.jpg",
                "action", "Ant Man", "this movie open in 2015.06");


        items.add(test1);
        items.add(test2);
        items.add(test3);


        items.add(test1);
        items.add(test2);
        items.add(test3);


        items.add(test1);
        items.add(test2);
        items.add(test3);


        return items;

}

}
