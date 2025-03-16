import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int idx, score;

    Pair(int idx, int score) {
        this.idx = idx;
        this.score = score;
    }

    @Override
    public int compareTo(Pair o) {
        return this.score - o.score;
    }
}

public class Main {
    static int gap;
    static StringTokenizer st;

    static int binarySearch(int idx, int score, ArrayList<Pair> oth) {
        if (gap < score) {
            return -1;
        }

        int start = -1, end = oth.size(), mid;
        while (start + 1 < end) {
            mid = (start + end) >> 1;

            if (gap < score + oth.get(mid).score) {
                end = mid;
            } else {
                start = mid;
            }
        }

        for (int i = end; i < oth.size(); i++) {
            if (idx != oth.get(i).idx) {
                return i;
            }
        }

        return -2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        gap = a - b;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> left = new ArrayList<>(), right = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            left.add(new Pair(i, Integer.parseInt(st.nextToken())));
            right.add(new Pair(i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(left);
        Collections.sort(right);

        int x = -2, y = -2, min = Integer.MAX_VALUE;
        if (gap < 0) {
            x = y = -1;
            min = b;
        }

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(left.get(i).idx, left.get(i).score, right);
            if (idx == -2) {
                continue;
            }

            int score = b + left.get(i).score + (idx == -1 ? 0 : right.get(idx).score);
            if (score < min) {
                x = left.get(i).idx;
                y = idx == -1 ? -1 : right.get(idx).idx;
                min = score;
            }
        }

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(right.get(i).idx, right.get(i).score, left);
            if (idx == -2) {
                continue;
            }

            int score = b + right.get(i).score + (idx == -1 ? 0 : left.get(idx).score);
            if (score < min) {
                x = idx == -1 ? -1 : left.get(idx).idx;
                y = right.get(i).idx;
                min = score;
            }
        }

        if (x == -2) {
            System.out.println("No");
        } else {
            System.out.printf(x + " " + y);
        }
    }
}
