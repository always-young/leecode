package com.kevin.leecode.godzuo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串全排列
 *
 * @author kevin lau
 */
public class PrintAll {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        new PrintAll().processWithNoRepeat("aac".toCharArray(),0,list);
        list.forEach(System.out::println);
    }

    public void process(char []str, int i, List<String> result){
        if(i == str.length) {
            result.add(new String(str));
            return;
        }
        for(int j = i;j< str.length;j++) {
            swap(str,i,j);
            process(str,i+1,result);
            swap(str,j,i);
        }
    }

    public void processWithNoRepeat(char []str, int i, List<String> result){
        if(i == str.length) {
            result.add(new String(str));
            return;
        }
        boolean []visited = new boolean[26];
        for(int j = i;j< str.length;j++) {
            if(!visited[str[j] - 'a']) {
                visited[str[j] - 'a'] = true;
                swap(str, i, j);
                processWithNoRepeat(str, i + 1, result);
                swap(str, j, i);
            }
        }
    }

    public String[] permutation(String s) {
        if(s == null||s.length()==0) {
            return new String[0];
        }
        List<String> list = new ArrayList<>();
        processWithNoRepeat(s.toCharArray(),0,list);
        String [] strings = new String[list.size()];
        int i=0;
        for (String s1 : list) {
            strings[i++] =s1;
        }
        return strings;
    }


    private void swap(char []str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }
}
