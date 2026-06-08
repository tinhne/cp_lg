package Codeforces.B_Level.CF_2232B_CakeLeveling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      long sum = 0;
      long ans = Long.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        long x = Long.parseLong(st.nextToken());
        sum += x;
        long avg = sum / (i + 1);
        ans = Math.min(ans, avg);
        sb.append(ans);
        if (i < n - 1)
          sb.append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
