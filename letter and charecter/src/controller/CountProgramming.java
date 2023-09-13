/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import common.Library;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import view.Menu;

/**
 *
 * @author Asus
 */
public class CountProgramming extends Menu<String>{
    static String[] mc = {"Letter Count", "Character Count","Exit"};
    private Map<Character,Integer> countChar = new HashMap<Character,Integer>();
    private Map<String,Integer> countLetter = new HashMap<String,Integer>();
    String t;
    Library x;
    public CountProgramming() {
        super("Count Menu",mc);
        x = new Library();
        t = x.getStr("Enter String: ");
        count(t);
    }
    
    public void count(String t){
       StringTokenizer st = new StringTokenizer(t);
       while(st.hasMoreTokens()){
           String m = st.nextToken();
           String deleteToken = deleteCharacter(m);
           if(Letter(deleteToken)){
               if(!countLetter.containsKey(deleteToken)){
                   countLetter.put(deleteToken,1);
               }else{
                   countLetter.put(deleteToken,countLetter.get(deleteToken)+1);
               }
           }
       }
       for(char ch : t.toCharArray()){
           if(Character.isLetter(ch)){
               if(!countChar.containsKey(ch)){
                   countChar.put(ch,1);
               }else{
                   countChar.put(ch,countChar.get(ch)+1);
               }
           }
       }
    }
    private boolean Letter(String t){
        for(char ch : t.toCharArray()){
            if(!Character.isLetter(ch)){
                return false;
            }
        }
        return true;
    }
    private String deleteCharacter(String t){
    StringBuilder deleteToken = new StringBuilder();
    for(char ch : t.toCharArray()){
        if(Character.isLetter(ch) || Character.isWhitespace(ch)){
            deleteToken.append(ch);
        }
    }
    return deleteToken.toString();
}

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                System.out.println(countLetter);
                break;
            case 2:
                System.out.println(countChar);
                break;
            case 3:
                System.exit(0);
        }
    }
}