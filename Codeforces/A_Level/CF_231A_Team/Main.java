package Codeforces.A_Level.CF_231A_Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int count = 0;

    for (int i = 0; i < n; i++) {
      String[] arr = br.readLine().split(" ");

      int a = Integer.parseInt(arr[0]);
      int b = Integer.parseInt(arr[1]);
      int c = Integer.parseInt(arr[2]);

      if ((a + b + c) >= 2)
        count++;
    }

    System.out.print(count);

  }
}
