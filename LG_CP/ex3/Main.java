package LG_CP.ex3;

import java.io.*;
import java.util.*;

public class Main {
  static final long MD = 1_000_000_007L;
  static int nr, nc, K;
  static int[][][] ps = new int[3][101][101];
  static long[][][] tb = new long[11][101][101];
  static int[] seq;
  static StringBuilder out = new StringBuilder();

  static int fi(char c) {
    return c == 'S' ? 0 : c == 'B' ? 1 : 2;
  }

  static int qr(int f, int r1, int c1, int r2, int c2) {
    if (r1 > r2 || c1 > c2)
      return 0;
    return ps[f][r2][c2] - ps[f][r1 - 1][c2] - ps[f][r2][c1 - 1] + ps[f][r1 - 1][c1 - 1];
  }

  static void solve(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    nr = Integer.parseInt(st.nextToken());
    nc = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    for (int f = 0; f < 3; f++) {
      int r = 0;
      while (r <= nr) {
        Arrays.fill(ps[f][r], 0);
        r++;
      }
    }

    char[][] g = new char[nr + 1][nc + 1];
    int ri = 1;
    while (ri <= nr) {
      String ln = br.readLine().trim();
      int ci = 1;
      while (ci <= nc) {
        g[ri][ci] = ln.charAt(ci - 1);
        ci++;
      }
      ri++;
    }

    int f = 0;
    while (f < 3) {
      int r = 1;
      while (r <= nr) {
        int c = 1;
        while (c <= nc) {
          int v = (g[r][c] != '.' && fi(g[r][c]) == f) ? 1 : 0;
          ps[f][r][c] = v + ps[f][r - 1][c] + ps[f][r][c - 1] - ps[f][r - 1][c - 1];
          c++;
        }
        r++;
      }
      f++;
    }

    seq = new int[K + 1];
    String fl = br.readLine().trim();
    int si = 1;
    while (si <= K) {
      seq[si] = fi(fl.charAt(si - 1));
      si++;
    }

    for (long[] b : tb[0])
      Arrays.fill(b, 0);
    int ii = 1;
    while (ii < tb.length) {
      for (long[] b : tb[ii])
        Arrays.fill(b, 0);
      ii++;
    }

    int r = 1;
    while (r <= nr) {
      int c = 1;
      while (c <= nc) {
        tb[K][r][c] = qr(seq[K], r, c, nr, nc) > 0 ? 1 : 0;
        c++;
      }
      r++;
    }

    int i = K - 1;
    while (i >= 1) {
      r = 1;
      while (r <= nr) {
        int c = 1;
        while (c <= nc) {
          long acc = 0;
          int rr = r;
          while (rr < nr) {
            if (qr(seq[i], r, c, rr, nc) > 0)
              acc = (acc + tb[i + 1][rr + 1][c]) % MD;
            rr++;
          }
          int cc = c;
          while (cc < nc) {
            if (qr(seq[i], r, c, nr, cc) > 0)
              acc = (acc + tb[i + 1][r][cc + 1]) % MD;
            cc++;
          }
          tb[i][r][c] = acc;
          c++;
        }
        r++;
      }
      i--;
    }

    out.append(tb[1][1][1]).append('\n');
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0)
      solve(br);
    System.out.print(out);
  }
}