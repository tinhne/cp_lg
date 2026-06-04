package Codeforces.A_Level.CF_71A_WayTooLongWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      if (s.length() <= 10) {
        System.out.println(s);
      } else {
        System.out.println(s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1));
      }
    }
  }
}
