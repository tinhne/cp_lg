package Codeforces.A_Level.CF_281A_CapitalizationWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    System.out.print(Character.toUpperCase(s.charAt(0)) + s.substring(1));
  }
}
