package com.codingtest.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

//118. Pascal's Triangle
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = null,prev=null;

        for (int i = 0; i < numRows; ++i) {
            cur = new ArrayList<>();

            for (int j = 0; j <= i; ++j) {
                if (j == 0 || i == j)
                    cur.add(1);

                else
                    cur.add(prev.get(j) + prev.get(j - 1));
            }

            prev=cur;
            list.add(cur);
        }

        return list;
    }

    public List<List<Integer>> generate2(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }

    public static void main(String[] args) {
        PascalTriangle pt=new PascalTriangle();
        pt.generate2(5);
    }

}
