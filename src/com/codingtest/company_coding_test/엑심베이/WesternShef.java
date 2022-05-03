package com.codingtest.company_coding_test.엑심베이;


/**
 * 요리사
 */
public class WesternShef implements Shef {

    private String name="양식 요리사는";

    @Override
    public Dish getOrder(Menu menu,int index) {
        String foodName = menu.getDishNames().get(index);
        System.out.println(name + " " +foodName + " 주문을 받았습니다.");
        return makeFood(menu.getDishNames().get(index));
    }

    @Override
    public Dish makeFood(String foodName) {
        System.out.println(name + " " +foodName + "을 만들었습니다.");
        return new Dish(foodName);
    }

}
