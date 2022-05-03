package com.codingtest.company_coding_test.엑심베이;

public interface Shef {

    //주문 받기
    Dish getOrder(Menu menu,int index);

    //요리 하기
    Dish makeFood(String foodName);

}
