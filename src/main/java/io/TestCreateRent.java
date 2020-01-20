package io;

import fit.ColumnFixture;
import io.entity.User;

import java.io.IOException;

public class TestCreateRent extends ColumnFixture {

    String login;
    String password;

    public boolean loginFail(){
        try{
            return SetUp.app.login(login, password);
        }catch (IOException e){
            return false;
        }
    }

    public boolean loginSuccess(){
        User user = new User(login, encode(password), null, null);

        try{
            return SetUp.app.login(login, password);
        }catch (IOException e){
            return false;
        }
    }

    private String encode(String password) {
        char[] chars = password.toCharArray();
        char[] newPwd = new char[chars.length];
        int i = 0;
        for (char ch : chars) {
            newPwd[i++] = (char) (ch + 4);
        }

        return String.valueOf(newPwd);
    }
}
