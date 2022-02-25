package com.codingtest.programmers_school.midterm_exam;



public class Reservation {

    public String[] solution(String[][] booked, String[][] unbooked) {
        String[] answer = new String[booked.length + unbooked.length];
        int idx=0;
        int i=0;
        int j=0;
        int beforeMin=0;

        //예약 고객 루프
        for (i = 0,j=0; i < booked.length && j<unbooked.length;) {
            String[] books = booked[i];
            String bookedTime = books[0];   //예약 도착 시간
            String bookedName = books[1];   //예약 고객 이름

            String[] unbooks = unbooked[j];
            String unbookedTime = unbooks[0];   //일반 고객 시간
            String unbookedName = unbooks[1];   //일반 고객 이름

            String[] booktimes = bookedTime.split(":");
            int bHour = Integer.parseInt(booktimes[0]);   //시
            int bMin = Integer.parseInt(booktimes[1]);    //분

            String[] unbookTimes = unbookedTime.split(":");
            int ubHour = Integer.parseInt(unbookTimes[0]);   //시
            int ubMin = Integer.parseInt(unbookTimes[1]);    //분

            if(i+j<1){  //첫 업무 시작의 분구하기
                if(bHour == ubHour) //시각이 같으면
                {
                    if(bMin > ubMin)
                        beforeMin = ubMin;

                    else
                        beforeMin = bMin;
                }

                else if(bHour < ubHour)    //예약 고객이 시각이 더 빠르면
                    beforeMin=bMin;

                else
                    beforeMin=ubMin;
            }

            //1. 일반 고객이 더 빨리왔으면(숫자가 더적은것이 더 빨리온것)
            if(bookedTime.compareTo(unbookedTime) > 0){
                //1.1 예약 고객이 앞 고객의 업무시간안에 왔으면(= 예약 고객을 먼저 업무본다)
                if(bMin%beforeMin<=beforeMin && bHour <= ubHour) {
                    answer[idx++] = bookedName;
                    i++;
                }

                //1.2 업무시간 밖에 왔으면(= 일반 고객을 업무본다)
                else {
                    answer[idx++] = unbookedName;
                    j++;
                }
            }

            //2. 예약 고객이 더 빨리왔으면
            else {
                answer[idx++] = bookedName;
                i++;
            }

            beforeMin=(beforeMin + 10)%60;   //업무처리 시간
        }

        //예약고객이 남았으면
        for(int k=i;k<booked.length;k++)
            answer[idx++]=booked[k][1];   //예약 고객 이름

        //일반 고객 남았으면
        for(int k=j;k<unbooked.length;k++)
            answer[idx++]=unbooked[k][1];   //일반 고객 이름


        return answer;
    }

    public static void main(String[] args) {
//        String [][]booked={{"09:10", "lee"}};
//        String [][]unbooked={{"09:00", "kim"},
//                             {"09:05", "bae"}};

//        String [][]booked={{"09:55", "hae"},
//                {"10:05", "jee"}};
//
//        String [][]unbooked={{"10:04", "hee"},
//                {"14:07", "eom"}};


        String [][]booked={{"09:55", "hae"},
                {"14:45", "jee"}};

        String [][]unbooked={{"10:04", "hee"},
                {"14:40", "eom"}};

        Reservation reservation=new Reservation();
        String[] solution = reservation.solution(booked, unbooked);

        for (String s : solution) {
            System.out.print(s+" ");
        }

    }
}
