package 백준;

import java.util.*;
import java.io.*;

public class _23254 {
    static int N, M;
    static int[] score;
    static int[] plus;
    static int total = 0;

    static class Score {
        int rest;
        int extra;

        Score(int rest, int plus) {
            this.rest = rest;
            this.extra = plus;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        score = new int[M];
        plus = new int[M];
        PriorityQueue<Score> pq = new PriorityQueue<>(
                (x,y) -> y.extra - x.extra
        );

        input = br.readLine().split(" ");
        for(int i = 0; i< M; i++){
            score[i] = Integer.parseInt(input[i]);
            total += score[i];
        }

        input = br.readLine().split(" ");
        for(int i = 0; i< M; i++){
            plus[i] = Integer.parseInt(input[i]);
            pq.add(new Score(100 - score[i],plus[i]));
        }

        int time = 24 * N;

        while(!pq.isEmpty()){
            Score cur = pq.poll();

            if(time >= (cur.rest / cur.extra)){
                time -= cur.rest / cur.extra;

                total += cur.extra * (cur.rest / cur.extra);

                if(cur.rest % cur.extra >= 1){
                    pq.add(new Score(cur.rest % cur.extra,cur.rest % cur.extra));
                }
            }else if(time > 0 && (cur.rest >= time * cur.extra)){
                total += time * cur.extra;
                time = 0;
            }
        }

        System.out.println(total);
        br.close();
    }

}
