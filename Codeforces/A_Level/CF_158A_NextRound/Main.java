package Codeforces.A_Level.CF_158A_NextRound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] first = br.readLine().split(" ");
    int n = Integer.parseInt(first[0]);
    int k = Integer.parseInt(first[1]);

    String[] arr = br.readLine().split(" ");

    int count = 0;

    int standard = Integer.parseInt(arr[k - 1]);

    for (int i = 0; i < n; i++) {
      int score = Integer.parseInt(arr[i]);
      if (score >= standard && score > 0)
        count++;
    }

    System.out.print(count);
  }
}
