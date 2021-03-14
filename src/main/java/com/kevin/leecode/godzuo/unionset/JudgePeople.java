package com.kevin.leecode.godzuo.unionset;

import java.util.HashMap;

/**
 * 人有身份证 姓名 出生证明编号 相同的就算一个人
 *
 * @author kevin lau
 */
public class JudgePeople {

    public int judgePeople(People []people) {
        UnionSet<People> set = new UnionSet<>();
        set.addAll(people);
        HashMap<String,People>  idMap = new HashMap<>();
        HashMap<String,People>  nameMap = new HashMap<>();
        HashMap<String,People>  bornMap = new HashMap<>();
        for (People person : people) {
            if(!idMap.containsKey(person.idNum)) {
                idMap.put(person.idNum,person);
            }else{
                People p1 = idMap.get(person.idNum);
                set.union(person,p1);
            }
            if(!nameMap.containsKey(person.name)) {
                nameMap.put(person.name,person);
            }else{
                People p1 = nameMap.get(person.name);
                set.union(person,p1);
            }
            if(!bornMap.containsKey(person.bornNum)) {
                bornMap.put(person.bornNum,person);
            }else{
                People p1 = bornMap.get(person.bornNum);
                set.union(person,p1);
            }
        }
        return set.getSize();
    }

    public static class People {

        public String idNum;

        public String name;

        public String bornNum;
    }
}
