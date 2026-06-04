package Codeforces.A_Level.CF_263A_BeautifulMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int row = 0, col = 0;
    for (int i = 0; i < 5; i++) {
      String[] arr = br.readLine().split(" ");
      for (int j = 0; j < 5; j++) {
        if (Integer.parseInt(arr[j]) == 1) {
          row = i;
          col = j;
        }
      }
    }
    System.out.print(Math.abs(2 - col) + Math.abs(row - 2));
  }
}
