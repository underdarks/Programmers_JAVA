package com.codingtest.programmers.dev_match;

import java.util.*;

public class MatrixBorder {

    //2차원 배열 테두리 만들기
    public int[][] makeMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];

        int v = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                matrix[i][j] = v++;
        }

        return matrix;
    }


    //시계 방향으로 회전
    public int doRotate(int[][] matrix, int x1, int y1, int x2, int y2) {
        int min = matrix[x1][y1]; //최소값
        Queue<Integer> que=new LinkedList<>();
        que.add(matrix[x1][y1]);

        //윗줄 옮기기(가로, y축 증가)
        for (int y = y1+1; y <= y2; y++) {
            if (min > matrix[x1][y])
                min = matrix[x1][y];

            que.add(matrix[x1][y]);
            matrix[x1][y] = que.poll(); //이전 값 넣기
        }

        //오른쪽 줄 옮기기(세로, x축 증가)
        for (int x = x1+1; x <= x2; x++) {
            if (min > matrix[x][y2])
                min = matrix[x][y2];

            que.add(matrix[x][y2]);
            matrix[x][y2] = que.poll();
        }

        //밑 줄 옮기기(가로, y축 감소)
        for (int y = y2-1; y >= y1; y--) {
            if (min > matrix[x2][y])
                min = matrix[x2][y];

            que.add(matrix[x2][y]);
            matrix[x2][y] = que.poll();
        }

        //왼쪽 줄 옮기기(세로, x축 감소)
        for (int x = x2-1; x >= x1; x--) {
            if (min > matrix[x][y1])
                min = matrix[x][y1];

            que.add(matrix[x][y1]);
            matrix[x][y1] = que.poll();
        }

        return min;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        //1. 행렬 만들기
        int[][] matrix = makeMatrix(rows, columns);

        //2. 회전 하기
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            answer[i] = doRotate(matrix, x1, y1, x2, y2);
        }


        return answer;
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;

        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };

//        int[][] queries = {
//                {1, 1, 100, 100},
//        };

        MatrixBorder matrixBorder = new MatrixBorder();
        int[] solution = matrixBorder.solution(rows, columns, queries);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

}
