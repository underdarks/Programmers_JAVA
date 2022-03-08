package com.codingtest.programmers.level1;

import javax.print.attribute.standard.DialogTypeSelection;
import java.lang.reflect.Array;
import java.util.Arrays;

//체육복
//https://programmers.co.kr/learn/courses/30/lessons/42862
public class GymSuit {

    /**
     * 여벌 체육복을 가진 학생이 체육복을 잃어 버린경우 찾기
     *
     * @param reverse
     * @param lostStudent
     */
    public int check(int[] reverse, int []lost) {
        int ans=0;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reverse.length; j++) {
                if (reverse[j] == lost[i]) {
                    reverse[j]=-1;  //빌려줌
                    lost[i]= -1;    //빌려받음
                    ans++;
                }
            }

        }

        return ans;
    }


    //여벌 체육복 가진 학생 index 찾기
    public int haveGymSuit(int[] lost, int[] reverse, int lostStudent) {
        if (lostStudent < 0)
            return -1;

        for (int i = 0; i < reverse.length; i++) {
            int haveStdudent=reverse[i];
            if (haveStdudent == lostStudent - 1 || haveStdudent == lostStudent + 1) {    //앞 뒤 학생이 여벌 체육복을 가지고 있을 경우
                return i;
            }
        }

        return -1;
    }

    /**
     * @param n       : 총 학생 수( 2 <= n <= 30)
     * @param lost    : 체육복을 도난 당한 학생 수 ( 1 <= lost <= n, 중복 번호 없음)
     * @param reserve : 여벌의 체육복을 가져온 학생의 수 ( 1 <= reverse <= n, 중복 번호 없음)
     */
    public int solution(int n, int[] lost, int[] reserve) {
        //1. 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int lostLen = lost.length;
        n -= lostLen; //전체 학생수 - 도난 당한 학생 수
        int idx=0;

        n+=check(reserve,lost);

        //2. 체육복을 잃어버린 학생
        for (int i = 0; i < lost.length; i++) {
            int lostStudent = lost[i];
            //체육복을 빌려 받지 못했으면
            if(lostStudent > -1) {
                idx = haveGymSuit(lost, reserve, lostStudent);    //2. 여벌 체육복 가진 학생 찾기

                if (idx > -1) {
                    reserve[idx] = -1;  //여벌 학생이 체육복 잃어버린 학생에게 빌려줌
                    n++;
                }
            }
        }

        return n;
    }


    public static void main(String[] args) {
        int n = 5;
        int[] lost = {1,2,3,4,5};
        int[] reverse = {1,2,5};

        GymSuit gymSuit = new GymSuit();
        int solution = gymSuit.solution(n, lost, reverse);
        System.out.println("solution = " + solution);
    }
}
