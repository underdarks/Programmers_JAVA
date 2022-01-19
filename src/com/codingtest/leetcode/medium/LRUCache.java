package com.codingtest.leetcode.medium;
/*
LRU 알고리즘 :
        가장 오랫동안 참조되지 않은 페이지를 교체하는 기법
        Cache 알고리즘 중에 가장 유명한 알고리즘 중 하나로 LRU 알고리즘 이라는 것이 있다.
        LRU 알고리즘이란 Least Recently Used Algorithm 의 약자로, 캐시에서 메모리를 다루기 위해 사용되는 알고리즘이다.
        캐시가 사용하는 리소스의 양은 제한되어 있고, 캐시는 제한된 리소스 내에서 데이터를 빠르게 저장하고 접근할 수 있어야 한다.
        이를 위해 LRU 알고리즘은 메모리 상에서 가장 최근에 사용된 적이 없는 캐시의 메모리부터 대체하며 새로운 데이터로 갱신시켜준다.
*/
import java.util.*;

//146. LRUCache
public class LRUCache {
    Map<Integer,Integer> map;
    List<String> l=new LinkedList<String>();

//    public LRUCache(int capacity) {
//        map=new HashMap<>(2);
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//
//    }
}
