package io.github.williamtrindade.unity1.class5.exercise8.ex7;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setDate(new Date());
        user.setId(1);
        user.setName("ANA");
        user.setText("AMIGA");
        user.setPhones(new String[] { "55909090903", "778989898989", "909090909" });
        user.setOwner(new User.Owner(1000, "Admin"));
        System.out.println(new JsonFramework().generateJson(user));
    }
}
