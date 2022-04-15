package com.itheima;
import org.junit.jupiter.api.Test;

import java.util.*;

public class test {
    @Test
    public void test01(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            HashMap<Integer, Object> map= new HashMap<>();
            for(int i=0;i<str.length();i++){
                map.put(i,str.charAt(i));
            }
            for (int j = map.size();j>0;j--){
                System.out.print(map.get(j));
            }
        }
    }
}
