package com.codingtest.company_coding_test.엑심베이;

import java.util.ArrayList;
import java.util.List;

/**
 * 메뉴판 객체
 */

public class Menu {

//    private List<Dish> dishes;

    private List<String> dishNames;
    private List<DishType> dishTypes;
    private List<String> methods;

    public List<String> getDishNames() {
        return dishNames;
    }

    public List<DishType> getDishTypes() {
        return dishTypes;
    }

    public List<String> getMethods() {
        return methods;
    }

    public Menu() {
        dishNames =new ArrayList<>();
        dishTypes=new ArrayList<>();
        methods=new ArrayList<>();

        init();
    }


    public void init(){
        dishNames.add("갈비찜");
        dishTypes.add(DishType.KOREAN);
        methods.add("젓가락");

        dishNames.add("파스타");
        dishTypes.add(DishType.WESTERN);
        methods.add("포크");


        dishNames.add("마파두부");
        dishTypes.add(DishType.CHINESE);
        methods.add("숟가락");

    }


}
