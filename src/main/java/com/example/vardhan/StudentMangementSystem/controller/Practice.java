package com.example.vardhan.StudentMangementSystem.controller;

import com.example.vardhan.StudentMangementSystem.Sample.*;
import com.example.vardhan.StudentMangementSystem.Sample.ENUMS.DEGREE;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.pow;

public class Practice {
    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>();
        s1.add("a");
        s1.add("b");
        s1.add("c");

        System.out.println(s1);
        s1.remove("b");
        System.out.println(s1);
        s1.add("d");
        System.out.println(s1);
        s1.remove(1);
        System.out.println(s1);
        boolean a = s1.contains("b");
        System.out.println(a);
        boolean b = s1.containsAll(List.of("x", "a"));
        System.out.println(b);
        for (String a1 : s1) {
            //boolean a = s1.contains("b");
            System.out.println(a1);
        }

        System.out.println(s1.size());
        Integer num[] = {2, 5, 4, 6};
        List<Integer> nums = Arrays.asList(num);
        List<String> s2 = new ArrayList<>(List.of("g", "v", "e", "a"));
        List<String> s3 = new ArrayList<>(List.of("e", "r", "a"));
        // s2.addAll(s3);
        // System.out.println(s2);
      /*  for(String i:s3){
            s2.add(i);
        }*/
        List<String> newList = new ArrayList<>();
        for (String i : s2) {
            if (s3.contains(i))
                newList.add(i);
        }
        System.out.println(newList);


        List<String> s4 = new ArrayList<>(List.of("e", "r", "a", "e", "c", "b", "c", "r", "r"));
        Collections.sort(s4);
        System.out.println(s4);
        s4.removeAll(List.of("r"));
        System.out.println(s4);
        List<String> s5 = new ArrayList<>();
        Set<String> set1 = new LinkedHashSet<>();

        // s4.remove("e");
        // System.out.println(set1);
        // String n="e";
        for (String i : s4) {
            set1.add(i);
            if (!s5.contains(i)) {
                s5.add(i);
            }
        }
        System.out.println(s5);
        System.out.println(set1);
        // int n= s5.size();
        List<String> n1 = new ArrayList<>();
        for (int i = s5.size() - 1; i >= 0; i--) {
            n1.add(s5.get(i));


        }
        System.out.println(n1);
        List<Integer> a1 = new ArrayList<>(List.of(2, 5, 4, 88, 6, 9, 1));
        Collections.sort(a1);
        System.out.println(a1.get(a1.size() - 2));
        System.out.println("----------------------------------------------------");
        List<Person> personList = new ArrayList<>(List.of(new Person("Vardhan", 21),
                new Person("Balu", 19),
                new Person("Chaitanya", 26)));
        System.out.println(personList);

        // personList.sort((p1, p2) -> p2.getAge() - p1.getAge());
        personList.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
        personList.sort((p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println("Fi----------------------------------------------------");
        System.out.println(personList);

        personList.sort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println("----------------------------------------------------");
        System.out.println(personList);
        personList.sort(Comparator.comparing(Person::getName).reversed());
        System.out.println("----------------------------------------------------");
        System.out.println(personList);


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()

                .filter(n -> n % 2 == 0)
                .map(n -> n * 3)
                .collect(Collectors.toList());
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(evenNumbers);

        String word = "1,2,1,3,3,3,10";
        String word1[] = word.split(",");
        List<Integer> w = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        for (String i : word1) {
            int a2 = Integer.parseInt(i);
            if (hash.containsKey(a2)) {
                hash.put(a2, hash.get(a2) + 1);

            } else {
                hash.put(a2, 1);
            }
        }

        System.out.println();


        List<String> ad =List.of("car","bike","apple");
        Map<String,Integer> m1 =new LinkedHashMap<>();
        for(String i: ad){

            m1.put(i,i.length());
        }
        System.out.println(m1);
       System.out.println(m1.get("car"));

    //{10:[1-10],20:[11-20]
        List<Integer> n = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            n.add(i);
        }
        Map<Integer,List<Integer>> resMap = new LinkedHashMap<>();
        List<Integer> lsInt = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Integer intVal = n.get(i);
            lsInt.add(intVal);
            System.out.print(intVal + ",");
            if (intVal % 10 ==0) {
                resMap.put(intVal,lsInt);
                lsInt = new ArrayList<>();
                System.out.println();
            }
        }
        System.out.println(resMap);

    //"123,45,67" ->[123,45,67]
        String a2="123,45,67,123";
       // String a3[]=a2.split(",");
       // a2.split(",");
        Set<Integer> a4 =new LinkedHashSet<>();
        for(String i:a2.split(",")){
           // int a5=Integer.parseInt(i);
            a4.add(Integer.parseInt(i));

        }
        System.out.println(a4);
        //a=[1,2] b=[3,4] c=[1,2,3,4]
        List<Integer> b3 =new ArrayList<>(List.of(1,2));
        List<Integer> b4 =new ArrayList<>(List.of(3,4));
        List<Integer> a5 =new LinkedList<>();
        List<Integer> b5 =new LinkedList<>();
        b3.addAll(b4);
        a5=List.copyOf(b3);
        System.out.println(a5);

        for(Integer i:b3){

            b5.add((int) pow(i,3));


        }
        List<Integer> b6 =a5.stream().map(i->(int) Math.pow(i,3)).collect(Collectors.toList());;


        System.out.println(b6);









    }

}















