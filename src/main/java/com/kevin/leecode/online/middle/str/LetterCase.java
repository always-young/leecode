package com.kevin.leecode.online.middle.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * @author kevin lau
 */
public class LetterCase {



    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        if(S == null || S.length() == 0) {
            return list;
        }
        process(S,list,0,"");
        return list;

    }

    public void process(String str,List<String> list ,int index,String path) {
        if(index == str.length()) {
            list.add(path);
            return;
        }
        char c = str.charAt(index);
        if(c >= 'a' && c <='z') {
            String r =  path + c;
            process(str,list,index+1,r);
            c = Character.toUpperCase(c);
            path = path + c;
            process(str,list,index+1,path);
            return;
        }else if (c>='A' && c<= 'Z'){
            String r =  path + c;
            process(str,list,index+1,r);
            c = Character.toLowerCase(c);
            path = path + c;
            process(str,list,index+1,path);
            return;
        }else{
            path = path + c;
            process(str,list,index+1,path);
        }

    }
}
