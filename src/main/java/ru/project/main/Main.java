package ru.project.main;

import kotlinn.*;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Arnold", 75, "term");
        System.out.println(person.component1());
        System.out.println(person.component2());
        System.out.println(person.component3());
    }
}
