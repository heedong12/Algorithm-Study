package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17220 {

    static int N, M;
    static int answer = 0;
    static int drugDealerCnt;
    static Map<Character, List<Character>> graph = new HashMap<>();
    static Map<Character, Integer> degree = new HashMap<>();
    static Set<Character> visited = new HashSet<>();


    static void solution(char curNode) {
        if(visited.contains(curNode)) return;

        if(graph.get(curNode) != null) {
            for (char nextNode : graph.get(curNode)) {
                if(!visited.contains(nextNode)) {
                    answer++;
                    solution(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i = 0;i<M; i++) {
            input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char child = input[1].charAt(0);

            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(child);

            degree.put(child, degree.getOrDefault(child, 0) + 1);
            degree.put(parent, degree.getOrDefault(parent, 0));
        }

        input = br.readLine().split(" ");
        drugDealerCnt = Integer.parseInt(input[0]);
        for (int i=0; i<drugDealerCnt; i++) {
            char dealer = input[1+i].charAt(0);
            visited.add(dealer);
        }

        for(char node: degree.keySet()) {
            if(degree.get(node) == 0) {
                solution(node);
            }
        }

        System.out.println(answer);

        br.close();
    }
}
