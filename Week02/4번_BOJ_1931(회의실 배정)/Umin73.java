import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1931 {
    static int N;
    static int answer = 0;
    static int[][] meetingArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        meetingArr = new int[N][2];

        int start, end;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            meetingArr[i][0] = start;
            meetingArr[i][1] = end;
        }

        Arrays.sort(meetingArr, (o1, o2) ->
                (o1[1] == o2[1]) ? Integer.compare(o1[0], o2[0]):Integer.compare(o1[1], o2[1]));

        int lastMeetingEnd = -1;
        for(int i = 0; i < N; i++) {
            if(meetingArr[i][0] >= lastMeetingEnd) {
                answer++;
                lastMeetingEnd = meetingArr[i][1];
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
