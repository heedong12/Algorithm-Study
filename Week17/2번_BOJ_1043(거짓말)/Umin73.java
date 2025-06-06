package 백준;

import java.io.*;
import java.util.*;

public class _1043 {

    static int N, M;
    static boolean[] peopleArr;
    static boolean[] visited;
    static List<Integer> truthPeople;
    static List<Integer>[] graph;
    static List<List<Integer>> partyList;

    static void dfs(int curPeople) {
        visited[curPeople] = true;
        peopleArr[curPeople] = true;

        for(int neighbor : graph[curPeople]) {
            if(!peopleArr[neighbor]) dfs(neighbor);
        }
    }

    static int countLieParty() {
        int cnt = 0;

        for(List<Integer> party: partyList) {
            boolean canLie = true;

            for(int people : party) {
                if(peopleArr[people]) {
                    canLie = false;
                    break;
                }
            }

            if(canLie) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 사람 수
        M = Integer.parseInt(input[1]); // 파티 수

        visited = new boolean[N+1];
        peopleArr = new boolean[N+1];
        truthPeople = new ArrayList<>();
        graph = new ArrayList[N+1];
        partyList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        input = br.readLine().split(" ");
        int truthPeopleCnt = Integer.parseInt(input[0]);

        for(int i=1; i<=truthPeopleCnt; i++) {
            int p = Integer.parseInt(input[i]);
            peopleArr[p] = true;
            truthPeople.add(p);
        }

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int participantsCnt = Integer.parseInt(input[0]);

            List<Integer> party = new ArrayList<>();

            for(int j=1; j<=participantsCnt; j++) {
                int p = Integer.parseInt(input[j]);
                party.add(p);
            }
            partyList.add(party);

            for(int j=0; j<party.size(); j++) {
                for(int k=j+1; k<party.size(); k++) {
                    int p1 = party.get(j);
                    int p2 = party.get(k);
                    graph[p1].add(p2);
                    graph[p2].add(p1);
                }
            }
        }

        for(int p : truthPeople) {
            if(!visited[p]) dfs(p);
        }

        System.out.println(countLieParty());

        br.close();
    }
}
