package Codeforces.A_Level.CF_282A_BitPlusPlus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String cur;
    int x = 0;
    for (int i = 0; i < n; i++) {
      cur = br.readLine();

      if (cur.contains("+")) {
        x++;
      } else
        x--;
    }
    System.out.print(x);
  }
}
