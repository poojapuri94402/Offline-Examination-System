package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.LoginInfoTo;

public class LoginInfoDAO {

    private String errormessage;
    private String UserName;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(LoginInfoTo lit) {
        try {
            String query = "insert into LoginInfo(UserName,Password,RoleName,LastLogin) values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, lit.getUserName());
            stmt.setString(2, lit.getPassword());
            stmt.setString(3, lit.getRoleName());
            stmt.setTimestamp(4, lit.getLastLogin());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(String UserName) {
        try {
            String query = "update logininfo set  lastlogin = sysdate() where username=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, UserName);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String UserName) {
        try {
            String query = "Delete from LoginInfo where UserName=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, UserName);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public LoginInfoTo getRecord(String UserName) {
        try {
            String query = "select username , password , rolename , lastlogin from logininfo where username=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, UserName);
            LoginInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new LoginInfoTo();
                result.setUserName(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setRoleName(rs.getString("rolename"));
                result.setLastLogin(rs.getTimestamp("lastlogin"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }

    }

    public List<LoginInfoTo> getAllRecord() {
        try {
            String query = "select UserName,Password,RoleName,LastLogin from LoginInfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<LoginInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    LoginInfoTo res = new LoginInfoTo();
                    res.setUserName(rs.getString("UserName"));
                    res.setPassword(rs.getString("Password"));
                    res.setRoleName(rs.getString("RoleName"));
                    res.setLastLogin(rs.getTimestamp("LastLogin"));
                    result.add(res);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }

    }

    public List<LoginInfoTo> getOnlyStudent() {
        try {
            String query = "select UserName,Password,RoleName,LastLogin from LoginInfo where RoleName='Student'";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<LoginInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    LoginInfoTo res = new LoginInfoTo();
                    res.setUserName(rs.getString("UserName"));
                    res.setPassword(rs.getString("Password"));
                    res.setRoleName(rs.getString("RoleName"));
                    res.setLastLogin(rs.getTimestamp("LastLogin"));
                    result.add(res);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }

    }

}
