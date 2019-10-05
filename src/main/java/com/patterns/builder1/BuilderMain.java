package com.patterns.builder1;

public class BuilderMain {

    public static void main(String[] args) {
        User user1 = new User().init().login("Tim").password("123").mail("tim@mail.ru").buildUser();
        User user2 = new User().init().login("Alex").password("321").buildUser();
        User user3 = User.init().login("Koko").mail("321@mail.ru").buildUser();

    }
}
