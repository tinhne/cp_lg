package Codeforces.A_Level.CF_4A_Watermelon;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int w = sc.nextInt();

    sc.close();

    if (w > 2 && w % 2 == 0) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
  }
}
