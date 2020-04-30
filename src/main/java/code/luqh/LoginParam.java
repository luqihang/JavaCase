package code.luqh;

import java.util.*;

/**
 * @author luqh
 * @date 2019/10/15
 **/
public class LoginParam extends AbstractParam<LoginParam> {

    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    public LoginParam username(String username) {
        param(USERNAME, username);
        return this;
    }

    public String username() {
        return param(USERNAME);
    }

    public LoginParam password(String password) {
        param(PASSWORD, password);
        return this;
    }

    public String password() {
        return param(PASSWORD);
    }

    public static void main(String[] args) {
//        LoginParam loginParam = new LoginParam();
//        loginParam
//
//                .username("luqh")
//                .password("lalala")
//                .param("hello", "word").param("w", "2")
//                .toMap();
//
//        Integer cast = int.class.cast(1);
//
//        Character cast1 = char.class.cast('1');
//
//
//        String hello = loginParam.param("hello");

//        OptionalInt value = OptionalInt.of(7);

        List<String> list = null;

//        list.add("hello");
//        list.add("world");

        Optional<List<String>> optionalList = Optional.ofNullable(list);

        List<String> newList = optionalList.map(s -> {
            s.add("lalala");
            return s;
        }).orElse(null);

        System.out.println(newList);
    }

}
