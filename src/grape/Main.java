package grape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static  int n;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {0,0,-1,1}; // 아래 위 좌 우
    static int[] dy = {-1,1,0,0};
    static  int apart;
    static int count;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 7
        arr = new int[n][n];
        visited = new boolean[n][n];

        //배열 만들기
        for(int i=0;i<n;i++){
            String a = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = a.charAt(j) - '0'; // 하나씩 끊기
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&arr[i][j]==1){
                    count = 1;
                    visited[i][j] = true;
                    bfs(i,j);
                    apart++;
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(apart);
        for(int i:list){
            System.out.println(i);
        }

    }
    static void bfs(int y,int x){

        for(int i=0;i<4;i++){
            int nextY = y+dy[i];
            int nextX = x+dx[i];

            if(nextY<0||nextX<0||nextY>=n||nextX>=n||visited[nextY][nextX]||arr[nextY][nextX]==0){
                continue;
            }
            visited[nextY][nextX] = true;
            count++;
            bfs(nextY,nextX);
        }
    }
}
