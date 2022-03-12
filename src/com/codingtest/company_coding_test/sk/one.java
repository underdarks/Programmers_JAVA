package com.codingtest.company_coding_test.sk;

public class one {

    public int solution(int money, int[] costs) {
        int []moneys={1,5,10,50,100,500};
        int answer = 0;
        int min=0;
        int value=0;
        int idx=costs.length;


        //큰 화폐부터 시작
        for (int i = costs.length-1; i >= 0 && money > 0; i--) {
            min=Integer.MAX_VALUE;
            value=0;

            //그리디
            for(int j=idx-1;j>=0 && money >0;j--){
                int count = money / moneys[j];  //금액 / 화폐 단위
                int cost = count*costs[j];      //나눈 금액 * 생산 단가 = 해당 화폐단위 만들때의 생산 비용
                min=Math.min(min,cost);

                if(min == cost) {
                    value = count * moneys[j];  //value는 생상 화폐 가치
                    idx=j;
                }
            }

            money-=value;
            answer+=min;
        }


        return answer;
    }

    public static void main(String[] args) {
//        int money=4578;
//        int []costs={1,4,99,35,50,1000};

        int money=1999;
        int []costs={2,11,20,100,200,600};

        one one=new one();
        int solution = one.solution(money, costs);
        System.out.println("solution = " + solution);

    }
}
