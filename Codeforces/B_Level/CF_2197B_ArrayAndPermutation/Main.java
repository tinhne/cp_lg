package Codeforces.B_Level.CF_2197B_ArrayAndPermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] pos = new int[n + 1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        int value = Integer.parseInt(st.nextToken());
        pos[value] = i;
      }

      st = new StringTokenizer(br.readLine());
      boolean ok = true;
      int previos = 0;
      for (int i = 1; i <= n; i++) {
        int value = Integer.parseInt(st.nextToken());
        int current = pos[value];

        if (current < previos) {
          ok = false;
          break;
        }
        previos = current;
      }
      System.out.print(ok ? "Yes \n" : "No\n");
    }
  }
}
