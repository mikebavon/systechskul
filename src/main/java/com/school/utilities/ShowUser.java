package com.school.utilities;

import java.util.ArrayList;
import java.util.List;

public class ShowUser {

    public static String show(User user){
        String newPasswordShow = "";

        int countPwdSize = user.getPassword() == null? 0 : user.getPassword().length();

        while((--countPwdSize)>0)
            newPasswordShow += "*";

        return "<br/><br/>" + user.getName() + " | " + user.getAddress() + " | " + user.getEmail() + " | " + newPasswordShow + "<br/>";

    }

    public static List<String> loopString(){

        List<String> someString = new ArrayList<String>();
        someString.add("ONE");
        someString.add("TWO");
        someString.add("THREE");
        someString.add("FOUR");

        return someString;
    }

}
