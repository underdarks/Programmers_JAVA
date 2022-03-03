package com.codingtest.programmers_school.week3;

public class BrocketNum {

    int count;

    public int solution(int n) {
        count = 0;

        findGoodBracket(0, 0, n);
        return count;
    }

    public void findGoodBracket(int openBracketCount, int closeBracketCount, int n) {

        //닫힌 괄호가 열린 괄호보다 많으면 종료
        if(openBracketCount < closeBracketCount)
            return;

        if(openBracketCount == n && closeBracketCount == n) {   //열린 괄호랑 닫힌 갈화의 갯수가 같으면(올바른 괄호)
            count++;
            return;
        }

        if(openBracketCount > n || closeBracketCount > n)   //열린 괄호나 닫힌 괄호의 갯수가 n보다 많으면
            return;

        findGoodBracket(openBracketCount + 1, closeBracketCount, n);    //왼쪽 괄호 하나 추가
        findGoodBracket(openBracketCount, closeBracketCount + 1, n);    //오른쪽 괄호 하나 추가
    }



    public static void main(String[] args) {
        BrocketNum b=new BrocketNum();
        b.solution(3);
    }
}
