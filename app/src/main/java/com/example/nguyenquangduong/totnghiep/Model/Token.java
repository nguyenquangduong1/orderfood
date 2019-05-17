package com.example.nguyenquangduong.totnghiep.Model;

public class Token  {
    private String token;
    private boolean isSeverToken;

    public Token(String token, boolean isSeverToken) {
        this.token = token;
        this.isSeverToken = isSeverToken;
    }

    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSeverToken() {
        return isSeverToken;
    }

    public void setSeverToken(boolean severToken) {
        isSeverToken = severToken;
    }
}
