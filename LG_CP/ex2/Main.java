package LG_CP.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder out = new StringBuilder();

  static final long MOD = 1_000_000_007L;
  static long[] fact = new long[50001];

  static void precompute() {
    fact[0] = 1;
    for (int i = 1; i < 50000; i++) {
      fact[i] = i * fact[i - 1] % MOD;
    }
  }

  static void solve(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    long[] A = new long[n];
    for (int i = 0; i < n; i++) {
      A[i] = Long.parseLong(st.nextToken());
    }

    long[] diff = new long[n + 2];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      diff[x]++;
      diff[y + 1]--;
    }

    out.append(Arrays.toString(A));
  }

  public static void main(String[] args) throws IOException {
    precompute();
    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      solve(br);
    }
    System.out.print(out);
  }

}
