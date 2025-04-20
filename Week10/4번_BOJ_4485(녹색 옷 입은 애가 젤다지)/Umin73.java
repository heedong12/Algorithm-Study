package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _4485 {

    static int N;
    static int[][] arr;
    static int[][] minCostArr;

    static StringBuilder sb = new StringBuilder();
    static int tc = 1;

    static class Node implements Comparable<Node> {

        int x, y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        minCostArr[0][0] = arr[0][0];
        pq.offer(new Node(0,0,arr[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.x == N-1 && cur.y == N-1){
                sb.append("Problem ").append(tc++).append(": ").append(cur.cost).append("\n");
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dirX[i];
                int nextY = cur.y + dirY[i];

                if(nextX >=0 && nextX < N && nextY>=0 && nextY < N) {
                    int tempCost = arr[nextX][nextY] + minCostArr[cur.x][cur.y];
                    if(tempCost < minCostArr[nextX][nextY]) {
                        minCostArr[nextX][nextY] = tempCost;
                        pq.offer(new Node(nextX, nextY, tempCost));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        while(N != 0) {
            arr = new int[N][N];
            minCostArr = new int[N][N];

            for(int i=0; i<N; i++) {
                String[] input = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                    minCostArr[i][j] = Integer.MAX_VALUE;
                }
            }
            solution();

            N = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
        br.close();
    }
}
