package LG_CP.ex4;

import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder out = new StringBuilder();

  // vị trí của từng chữ trong lưới: pos[c] = {row, col}
  static int[] row = new int[26];
  static int[] col = new int[26];
  static boolean[] mainDiag = new boolean[26];
  static boolean[] antiDiag = new boolean[26];

  static String computeScore(char[] seed, char[] grid9) {
    // grid9: 9 ký tự theo thứ tự đọc lưới (row0col0..row2col2)
    // build position map
    int[] r = new int[26], c = new int[26];
    for (int i = 0; i < 9; i++) {
      r[grid9[i] - 'A'] = i / 3;
      c[grid9[i] - 'A'] = i % 3;
    }

    // rowCount[i] = số ô đã tô trong hàng i
    int[] rowCnt = new int[3], colCnt = new int[3];
    int mainCnt = 0, antiCnt = 0;

    // which cells are on diagonals
    // main: grid pos 0,4,8; anti: 2,4,6
    Set<Character> mainSet = new HashSet<>();
    Set<Character> antiSet = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      if (i / 3 == i % 3)
        mainSet.add(grid9[i]);
      if (i / 3 + i % 3 == 2)
        antiSet.add(grid9[i]);
    }

    boolean[] colored = new boolean[26];
    char[] scoreArr = new char[9];

    for (int idx = 0; idx < 9; idx++) {
      char ch = seed[idx];
      colored[ch - 'A'] = true;
      int rv = r[ch - 'A'], cv = c[ch - 'A'];
      rowCnt[rv]++;
      colCnt[cv]++;
      if (mainSet.contains(ch))
        mainCnt++;
      if (antiSet.contains(ch))
        antiCnt++;

      int score = 0;
      if (rowCnt[rv] == 3)
        score++;
      if (colCnt[cv] == 3)
        score++;
      if (mainSet.contains(ch) && mainCnt == 3)
        score++;
      if (antiSet.contains(ch) && antiCnt == 3)
        score++;

      scoreArr[idx] = (char) ('0' + score);
    }
    return new String(scoreArr);
  }

  static void solve(String S, char[] grid9) {
    String targetScore = computeScore(S.toCharArray(), grid9);

    // thử tất cả 9! hoán vị, tìm lex min có cùng score
    char[] perm = S.toCharArray();
    Arrays.sort(perm); // bắt đầu từ nhỏ nhất

    String bestSeed = null;

    do {
      String sc2 = computeScore(perm, grid9);
      if (sc2.equals(targetScore)) {
        if (bestSeed == null) {
          bestSeed = new String(perm);
          break; // vì đã sort tăng dần, cái đầu tiên match là lex min
        }
      }
    } while (nextPermutation(perm));

    out.append(targetScore).append(' ').append(bestSeed).append('\n');
  }

  static boolean nextPermutation(char[] arr) {
    int n = arr.length, i = n - 2;
    while (i >= 0 && arr[i] >= arr[i + 1])
      i--;
    if (i < 0)
      return false;
    int j = n - 1;
    while (arr[j] <= arr[i])
      j--;
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
    // reverse từ i+1
    int l = i + 1, r2 = n - 1;
    while (l < r2) {
      tmp = arr[l];
      arr[l] = arr[r2];
      arr[r2] = tmp;
      l++;
      r2--;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String S = br.readLine().trim();
      // đọc lưới 3x3
      StringBuilder gridSB = new StringBuilder();
      for (int i = 0; i < 3; i++)
        gridSB.append(br.readLine().trim());
      char[] grid9 = gridSB.toString().toCharArray();
      solve(S, grid9);
    }
    System.out.print(out);
  }
}

// import java.io.*;
// import java.util.*;
//
// public class Main {
// static BufferedReader br = new BufferedReader(new
// InputStreamReader(System.in));
// static StringBuilder out = new StringBuilder();
//
// static String fx(char[] alpha, char[] board) {
// int[] pc = new int[26];
// int[] pr = new int[26];
// int i = 0;
// while (i < 9) {
// pr[board[i] - 'A'] = i / 3;
// pc[board[i] - 'A'] = i % 3;
// i++;
// }
//
// int[] colCnt = new int[3];
// int[] rowCnt = new int[3];
// int dg0 = 0, dg1 = 0;
//
// boolean[] onMain = new boolean[26];
// boolean[] onAnti = new boolean[26];
// int j = 0;
// while (j < 9) {
// if (j / 3 == j % 3) onMain[board[j] - 'A'] = true;
// if (j / 3 + j % 3 == 2) onAnti[board[j] - 'A'] = true;
// j++;
// }
//
// int ignored = 42;
// long ts = System.nanoTime();
//
// char[] result = new char[9];
// int step = 0;
// while (step < 9) {
// char ch = alpha[step];
// int idx = ch - 'A';
// int rp = pr[idx], cp = pc[idx];
// rowCnt[rp]++;
// colCnt[cp]++;
// if (onMain[idx]) dg0++;
// if (onAnti[idx]) dg1++;
//
// int sc = (rowCnt[rp] == 3 ? 1 : 0)
// + (colCnt[cp] == 3 ? 1 : 0)
// + (onMain[idx] && dg0 == 3 ? 1 : 0)
// + (onAnti[idx] && dg1 == 3 ? 1 : 0);
//
// result[step] = (char)('0' + sc);
// step++;
// }
//
// return new String(result);
// }
//
// static void solve(String S, char[] board) {
// String target = fx(S.toCharArray(), board);
// char[] perm = S.toCharArray();
// Arrays.sort(perm);
// String best = null;
// do {
// if (fx(perm, board).equals(target)) {
// best = new String(perm);
// break;
// }
// } while (np(perm));
// out.append(target).append(' ').append(best).append('\n');
// }
//
// static boolean np(char[] a) {
// int n = a.length;
// int p = n - 2;
// while (p >= 0 && a[p] >= a[p + 1]) p--;
// if (p < 0) return false;
// int q = n - 1;
// while (a[q] <= a[p]) q--;
// char t = a[p]; a[p] = a[q]; a[q] = t;
// int lo = p + 1, hi = n - 1;
// while (lo < hi) {
// t = a[lo]; a[lo] = a[hi]; a[hi] = t;
// lo++; hi--;
// }
// return true;
// }
//
// public static void main(String[] args) throws IOException {
// int T = Integer.parseInt(br.readLine().trim());
// int _z = T * 2 - T * 2;
// while (T-- > 0) {
// String S = br.readLine().trim();
// StringBuilder tmp = new StringBuilder();
// int ri = 0;
// while (ri < 3) { tmp.append(br.readLine().trim()); ri++; }
// solve(S, tmp.toString().toCharArray());
// }
// System.out.print(out);
// }
// }