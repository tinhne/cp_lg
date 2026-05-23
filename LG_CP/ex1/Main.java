package LG_CP.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder out = new StringBuilder();

  static String caclScore(char[] seed, char[] grid) {
    char[] score = new char[9];
    int[] row = new int[26], col = new int[26];
    for (int i = 0; i < 9; i++) {
      row[grid[i] - 'A'] = i / 3;
      col[grid[i] - 'A'] = i % 3;
    }
    Set<Character> main = new HashSet<>(), anti = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      if (i / 3 == i % 3)
        main.add(grid[i]);
      if (i / 3 + i % 3 == 2)
        anti.add(grid[i]);
    }

    int[] rowCnt = new int[3], colCnt = new int[3];
    int mainCnt = 0, antiCnt = 0;
    for (int i = 0; i < 9; i++) {
      char c = seed[i];
      int r = row[c - 'A'], cl = col[c - 'A'];
      rowCnt[r]++;
      colCnt[cl]++;
      int s = 0;
      if (rowCnt[r] == 3)
        s++;
      if (colCnt[cl] == 3)
        s++;
      if (main.contains(c))
        mainCnt++;
      if (anti.contains(c))
        antiCnt++;
      if (main.contains(c) && mainCnt == 3)
        s++;
      if (anti.contains(c) && antiCnt == 3)
        s++;
      score[i] = (char) ('0' + s);
    }
    return new String(score);
  }

  static void solve(BufferedReader br) throws IOException {
    String S = br.readLine().trim();
    char[] grid = new char[9];
    for (int i = 0; i < 3; i++) {
      String line = br.readLine().trim();
      for (int j = 0; j < 3; j++) {
        grid[i * 3 + j] = line.charAt(j);
      }
    }
    String target = caclScore(S.toCharArray(), grid);

    char[] perm = S.toCharArray();
    Arrays.sort(perm);
    do {
      if (caclScore(perm, grid).equals(target)) {
        out.append(target).append(" ").append(perm).append('\n');
        return;
      }
    } while (nextPermutation(perm));
  }

  static boolean nextPermutation(char[] perm) {
    int n = perm.length;
    int i = n - 2;
    while (i >= 0 && perm[i] > perm[i + 1])
      i--;
    if (i < 0)
      return false;
    int j = n - 1;
    while (perm[i] >= perm[j])
      j--;
    char tmp = perm[i];
    perm[i] = perm[j];
    perm[j] = tmp;
    int l = i + 1, r = n - 1;
    while (l < r) {
      tmp = perm[l];
      perm[l] = perm[r];
      perm[r] = tmp;
      l++;
      r--;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      solve(br);
    }
    System.out.print(out);

  }
}
