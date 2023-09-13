package common;

import java.util.Scanner;


import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Library {

    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }

    public String getStr(String test) {
        System.out.println(test);
        return sc.nextLine();
    }

    public int getNumber(String x, int a, int b) {
        int c = -1;
        while (true) {
            System.out.print(x + ": ");
            try {
                String s = sc.nextLine();
                c = Integer.parseInt(s);
                if (c >= a && c <= b) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + a + " and " + b);
            }
        }
        return c;
    }

}