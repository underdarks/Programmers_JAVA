package com.codingtest;

import com.codingtest.programmers.level1.Lotto;

public class Main {
    public static void main(String[] args) {
        Lotto lotto=new Lotto();
        int []lottos={44, 1, 0, 0, 31, 25};
        int []wins={31, 10, 45, 1, 6, 19};
        lotto.solution(lottos,wins);

    }
}
