package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back14502 {
    static int n,m;
    static int[][] arr; // 넣는 배열
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    private static int maxSafeArea = Integer.MIN_VALUE;
    static Queue<int[]>que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //7
        m = Integer.parseInt(st.nextToken()); //7

        arr = new int[n][m];
        // 배열에 넣기
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       dfs(0);
        System.out.println(maxSafeArea);
    }
    /// 벽 새우기
    static void dfs(int index){
        if(index ==3){
            safeArea();
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    arr[i][j] = 1;
                    dfs(index+1);
                    arr[i][j] = 0;
                }
            }
        }

    }
    // 안전한 지대 구하기
    static void safeArea(){
        int[][] copyarr = new int[n][m];
        // 배열 복사
        for(int i=0;i<n;i++){
            copyarr[i] = Arrays.copyOfRange(arr[i],0,m); //원본배열, 시작인덱스 , 끝인덱스 복사
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copyarr[i][j]==2){
                    virus(copyarr,i,j); // 2이면 주변을 2로 만듬
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copyarr[i][j]==0){
                    cnt++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea,cnt);
    }
    //bfs 2퍼트리기
    static void virus(int[][] copy,int y,int x){

        que.add(new int[]{y,x});
        while (!que.isEmpty()){
            int[] a = que.poll(); // y x
            int nexty = a[0]; //y
            int nextx = a[1]; //x

            for(int i=0;i<4;i++){
                int nexty2 = nexty+dy[i];
                int nextx2 = nextx+dx[i];
                if(nexty2>=0&&nextx2>=0&&nexty2<n&&nextx2<m&&copy[nexty2][nextx2]==0){
                    copy[nexty2][nextx2] =3;
                    que.add(new int[]{nexty2,nextx2});
                }

            }

        }
    }

}
