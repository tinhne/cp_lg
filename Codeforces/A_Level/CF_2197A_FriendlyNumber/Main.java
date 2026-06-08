package Codeforces.A_Level.CF_2197A_FriendlyNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int digitSum(int x) {
    int sum = 0;
    while (x > 0) {
      sum += x % 10;
      x /= 10;
    }
    return sum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (tc-- > 0) {
      int x = Integer.parseInt(br.readLine());
      int count = 0;
      for (int i = x; i < x + 90; i++) {
        if (i - digitSum(i) == x) {
          count++;
        }
      }
      sb.append(count).append("\n");
    }

    System.out.print(sb);
  }
}
