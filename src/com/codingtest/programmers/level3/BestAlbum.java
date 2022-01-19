package com.codingtest.programmers.level3;

import java.util.*;
import java.util.stream.Collectors;

//베스트앨범(해시)
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int count=2;
        List<Integer> bestAlbums=new ArrayList<>();

        Map<String,Map<Integer,Integer>> songs=new HashMap<>();   //장르 / 장르 별 음악 횟수
        Map<String,Integer> rank=new HashMap<>();               //장르 / 총 재생횟수

        for (int i=0;i<genres.length;i++) {
            String key = genres[i];

            //장르별 재생합계
            Integer score = rank.getOrDefault(key, 0);
            rank.put(key,score+plays[i]);

            //장르별 노래
            Map<Integer, Integer> song = songs.getOrDefault(key, new HashMap<>());
            song.put(i,plays[i]);   //고유번호 및 노래 재생 횟수
            songs.put(key,song);
        }

        //장르 내림차순 정렬(많이 재생된 장르순)
        List<String> genreRank = new ArrayList<String>(rank.keySet());
        Collections.sort(genreRank, (o1, o2) -> (rank.get(o2).compareTo(rank.get(o1))));

        //장르별 베스트앨범 구하기
        for (String genre : genreRank) {
            Map<Integer, Integer> song = songs.get(genre);
            List<Integer> keyList = new ArrayList<Integer>(song.keySet());
            Collections.sort(keyList, (o1, o2) -> (song.get(o2).compareTo(song.get(o1))));  //음아


            if(count > keyList.size())
                count=keyList.size();

            //장르별 베스트앨범 고유번호 추출
            for (int i = 0; i < count; i++) {
                int key=keyList.get(i);
                bestAlbums.add(key);
            }
        }

        return bestAlbums.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String []genres ={"classic", "pop", "classic", "pop", "classic", "classic"};
        int []plays={400, 600, 150, 600, 500, 500};
        BestAlbum b=new BestAlbum();
        int[] solution = b.solution(genres, plays);

        for (int i : solution) {
            System.out.println(i);
        }

    }

}
