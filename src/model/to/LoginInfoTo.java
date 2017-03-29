package model.to;

import java.sql.Timestamp;

public class LoginInfoTo {
    private String UserName;
    private String Password;
    private String RoleName;
    private Timestamp LastLogin;

    @Override
    public String toString() {
        return  UserName  ;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public Timestamp getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Timestamp LastLogin) {
        this.LastLogin = LastLogin;
    }
}
