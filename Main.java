package com.example.javastudy.codingStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int totalDays = Integer.parseInt(st.nextToken());
        int inspectDays = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[totalDays];
        for(int i = 0; i < totalDays; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; //투포인트 시작점
        int end = 0; //투포인트 끝점
        int sum = 0;
        int max = 0;
        int count = 0;
        int maxCount = 0;
        while(end < totalDays){
            sum = sum + arr[end]; //1 4 2 5 1 차례대로 계속 더해준다 0 1, 0 1 4 ~

            if(end == (inspectDays-1)){  //기간이 2든 5든 블로그의 조회수 기간에 맞는 합을 구해서 최대값에 넣어야 한다
                if(max < sum){
                    max = sum;   //최대값 넣기
                }
                count = inspectDays; //첫 검사 이 후 inspectDays 변수를 증가시켜야 하니 count 변수로 이동

            }

            if(end == count && end != 0){ //end == 0 부터 시작하면 1 + 4 하고 1을 다시 뺴버린다
                sum = sum - arr[start]; // 다음겁사부터 매번 첫값을 빼주머 최대값 삽입
                start++;                // 예) 1+ 4 + 5 에서 1값을 뺴야 2틀치의 조회수를 계산
                if(max < sum){
                    max = sum;
                    maxCount = 0;  //1) 2)번 카운트 계속 세다가 또 최대값 만날시 세던것보다 최대값이 더크니 0으로 초기화
                }else if(max == sum){ //2) 최대값과 똑같을시 카운트 세기
                    maxCount++;
                }
                count++;
            }

            end++;
        }

        if(max == 0) { //최대값이 0이면 "SAD"
            System.out.println("SAD");
        }else{ // 아니면 정상 출력
            System.out.println(max);
            System.out.println(maxCount+1);
        }
    }
}
