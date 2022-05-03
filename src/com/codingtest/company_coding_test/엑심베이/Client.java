package com.codingtest.company_coding_test.엑심베이;


/**
 * Controller
 */
public class Client {

    public Menu getMenu(){
        Menu menu = new Menu();
        return menu;
    }

    public Shef choiceMenu(int index,Menu menu){
        DishType type = menu.getDishTypes().get(index);

        if(type == DishType.CHINESE)
            return new ChineseShef();

        else if(type == DishType.KOREAN)
            return new KoreanShef();

        else if(type == DishType.WESTERN)
            return new WesternShef();


        return null;
    }



    public static void main(String[] args) {
        Shef shef=null;

        Client client=new Client();
        Menu menu = client.getMenu();
        int index=1;

        shef=client.choiceMenu(1,menu);
        Dish dish = shef.getOrder(menu, 1);

        System.out.println("고객은 주문한 " + dish.getName() + "을 받았으며 " + menu.getMethods().get(index)+"을 사용하여 먹었습니다.");


    }
}
