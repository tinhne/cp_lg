package Codeforces.A_Level.CF_2231A_ConstructAnArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++) {
        sb.append(i * 2 + 1).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
