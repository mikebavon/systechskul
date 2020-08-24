package com.school.utilities;

public class ShowUser {

    public static String show(User user){
        String newPasswordShow = "";

        int countPwdSize = user.getPassword() == null? 0 : user.getPassword().length();

        while((--countPwdSize)>0)
            newPasswordShow += "*";

        return "<br/><br/>" + user.getName() + " | " + user.getAddress() + " | " + user.getEmail() + " | " + newPasswordShow + "<br/>";

    }

}
