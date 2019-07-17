/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 23:48
 */

package com.atguigu.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserData {

    public static List<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        Random random = new Random();

        users.add(new User(10001, "AA", random.nextDouble()*100000));
        users.add(new User(10002, "AB", random.nextDouble()*100000));
        users.add(new User(10003, "AC", random.nextDouble()*100000));
        users.add(new User(10004, "ADS", random.nextDouble()*100000));
        users.add(new User(10005, "AE", random.nextDouble()*100000));
        users.add(new User(10006, "AAC", random.nextDouble()*100000));
        users.add(new User(10007, "AAS", random.nextDouble()*100000));
        users.add(new User(10008, "AA", 123456));
        users.add(new User(10008, "AA", 123456));

        return users;

    }

}
