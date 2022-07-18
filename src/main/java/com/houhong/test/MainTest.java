package com.houhong.test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @program: bpm-starter
 * @description: 测试
 * @author: houhong
 * @create: 2022-07-16 16:53
 **/
public class MainTest {

     public static void main(String[] args) {


        Set<String> testLinkedHashSet = new LinkedHashSet<>();

        testLinkedHashSet.add("1");

        testLinkedHashSet.add("2");

        testLinkedHashSet.add("3");

        testLinkedHashSet.add("2");

        testLinkedHashSet.add("4");

        for (String s : testLinkedHashSet) {
            System.out.println(s);
        }


    }
}