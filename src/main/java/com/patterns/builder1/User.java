package com.patterns.builder1;


/**
 * вместо тысячи конструктров
 * pattern Builder
 */
public class User {

    String login;
    String password;
    String mail;

    class Creator {

        Creator login(String login) {
            User.this.login = login;
            System.out.println(login);
            return this;
        }

        Creator password(String password) {
            User.this.password = password;
            System.out.println(password);
            return this;
        }

        Creator mail(String mail) {
            User.this.mail = mail;
            System.out.println(mail);
            return this;
        }

        public User buildUser() {
            return User.this;
        }

    }

    public static Creator init() {
        return new User().new Creator();
    }

}
