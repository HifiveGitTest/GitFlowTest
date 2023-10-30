import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M,K;
    static int[] dy= {-1,1,0,0};
    static int[] dx ={0,0,-1,1};
    static boolean[][] visited;
    static boolean[][] arr;
    static int max,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        visited  = new boolean[N][M];
        max = 0;
        count = 0;
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            arr[a][b] = true;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] && !visited[i][j]){
                   count = 0;
                   dfs(i,j);
                   max = Math.max(max,count);
                }
            }
        }
        System.out.println(max);
    }
    static void dfs(int y, int x){

        for(int i=0;i<4;i++){
            int nexty = y + dy[i];
            int nextx = x + dx[i];

            if(nexty<0||nextx<0||nexty>=N||nextx>=M||visited[nexty][nextx]||!arr[nexty][nextx]) {
                continue;
            }
            visited[nexty][nextx] = true;
            count++;
            dfs(nexty,nextx);
        }

    }
}
