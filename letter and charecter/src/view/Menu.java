/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import common.Library;
import java.util.ArrayList;


/**
 *
 * @author Asus
 */
public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> mChoose;
    Library t = new Library();

    public Menu() {
        mChoose = new ArrayList<>();
    }

    public Menu(String tl, String[] mc) {
        title = tl;
        mChoose = new ArrayList<>();
        for(String s : mc){
            mChoose.add((T) s);
        }
    }
      public void display() {
        System.out.println(title);
        for (int i = 0; i < mChoose.size(); i++) {
            System.out.println((i + 1) + "." + mChoose.get(i));
        }
    }

    public int getSelected() {
        display();
        return t.getNumber("Enter your choice", 1, mChoose.size() + 1);
    }
    public abstract void execute(int n);
    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > mChoose.size()) {
                break;
            }
        }
    }
}

