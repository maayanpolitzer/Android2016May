package com.company;

public class Main {

    public static void main(String[] args) {

        char[] chars = {'H','e','l','l','o',' ','W','o','r','l','d'};
        MyString s = new MyString(chars);

        s.print();  // Maayan

        System.out.println(s.charAt(2));    //  'a'

        System.out.println(s.indexOf('a'));     //  3

        System.out.println(s.howManySameChars('a'));    //  3

        System.out.println(s.contains('M'));    //      false.

        System.out.println(s.isLastChar('n'));      //  true.

        MyString sub = s.subString(7);
        sub.print();

        MyString sub2 = s.subString(2,7);
        sub2.print();

        // homework
        MyString replacedMyString = s.replace('c', 5);
        replacedMyString.print();

        char[] check = new char[]{'r','l','d'};
        System.out.println(s.isEndsWith(check));    //  true

        MyString replaceAll = s.replace('o','*');
        replaceAll.print();

        MyString[] strings = s.split(' ');
        for (int i = 0; i < strings.length; i++){
            strings[i].print();
        }



    }
}
