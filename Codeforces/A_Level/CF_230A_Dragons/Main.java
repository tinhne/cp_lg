package Codeforces.A_Level.CF_230A_Dragons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int s = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[][] dragons = new int[n][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      dragons[i][0] = Integer.parseInt(st.nextToken());
      dragons[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(dragons, (a, b) -> a[0] - b[0]);

    for (int i = 0; i < n; i++) {
      if (s <= dragons[i][0]) {
        System.out.println("NO");
        return;
      } else {
        s += dragons[i][1];
      }
    }
    System.out.println("YES");
  }
}
