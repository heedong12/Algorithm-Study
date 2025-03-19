import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        int[] heights = new int[257];
        int mapSize = n * m;
        int blocks = 0;
        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(input[j]);
                heights[h]++;
                blocks += h;
                minHeight = Math.min(h, minHeight);
            }
        }

        int maxHeight = b + blocks < (mapSize << 8) ? (b + blocks) / mapSize : 256;
        int t = (blocks - (minHeight * mapSize)) << 1;

        int time = t;
        int height = minHeight;
        blocks = 0;

        for (int i = minHeight + 1; i <= maxHeight; i++) {
            blocks += heights[i - 1];
            t += blocks - ((mapSize - blocks) << 1);

            if (time >= t) {
                time = t;
                height = i;
            }
        }

        System.out.println(time + " " + height);
    }
}
