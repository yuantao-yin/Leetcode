package main.java.com.lc.binarytree;

import java.util.TreeSet;

public class TreeSetDemo {

  public static void main(String[] args) {
    TreeSet<Integer> ts=new TreeSet();

    ts.add(20);
    ts.add(29);
    ts.add(18);
    ts.add(16);
    ts.add(21);


    for (Integer integer : ts) {
      System.out.print(integer + " ");
      System.out.println();
    }

    System.out.print("ceiling " + ts.ceiling(22));
  }
}