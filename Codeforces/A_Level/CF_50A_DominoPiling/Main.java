package Codeforces.A_Level.CF_50A_DominoPiling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] arr = br.readLine().split(" ");

    System.out.print((Integer.parseInt(arr[0]) * Integer.parseInt(arr[1])) / 2);
  }
}
