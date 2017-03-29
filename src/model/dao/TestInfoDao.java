package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.TestInfoTo;

public class TestInfoDao {

    private String errormessage;
    private String query;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(TestInfoTo tit) {
        try {
            String query = "insert into TestInfo(TestName,SubjectID,TestLevel,TotalQuestion,UserName)values(?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, tit.getTestName());
            stmt.setString(2, tit.getSubjectID());
            stmt.setString(3, tit.getTestLevel());
            stmt.setInt(4, tit.getTotalQuestion());
            stmt.setString(5, tit.getUserName());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(TestInfoTo tit) {
        try {
            String query = "update TestInfo set TestName=?, SubjectID=?,TestLevel=?,TotalQuestion=?,UserName=? where TestID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, tit.getTestName());
            stmt.setString(2, tit.getSubjectID());
            stmt.setString(3, tit.getTestLevel());
            stmt.setInt(4, tit.getTotalQuestion());
            stmt.setString(5, tit.getUserName());
            stmt.setInt(6, tit.getTestID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String TestID) {
        try {
            String query = "Delete from TestInfo where TestID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, TestID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public TestInfoTo getRecord(int TestID) {
        try {
            String query = "select TestID,TestName,SubjectID,TestLevel,TotalQuestion,UserName from TestInfo where TestID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, TestID);
            TestInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TestInfoTo();
                result.setTestID(rs.getInt("TestID"));
                result.setTestName(rs.getString("TestName"));
                result.setSubjectID(rs.getString("SubjectID"));
                result.setTestLevel(rs.getString("TestLevel"));
                result.setTotalQuestion(rs.getInt("TotalQuestion"));
                result.setUserName(rs.getString("UserName"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<TestInfoTo> getAllRecord() {
        try {
            String query = "select TestID,TestName,SubjectID,TestLevel,TotalQuestion,UserName from TestInfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<TestInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TestInfoTo res = new TestInfoTo();
                    res.setTestID(rs.getInt("TestId"));
                    res.setTestName(rs.getString("TestName"));
                    res.setSubjectID(rs.getString("SubjectID"));
                    res.setTestLevel(rs.getString("TestLevel"));
                    res.setTotalQuestion(rs.getInt("TotalQuestion"));
                    res.setUserName(rs.getString("UserName"));
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

    public List<TestInfoTo> gettestid(String username) {
        try {
            String query = "select TestID,TestName,SubjectID,TestLevel,TotalQuestion,UserName from TestInfo where TestID in(Select TestID from TestSchedule where SUsername=? and TestDate=curdate())";

            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, username);
            List<TestInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TestInfoTo res = new TestInfoTo();
                    res.setTestID(rs.getInt("TestId"));
                    res.setTestName(rs.getString("TestName"));
                    res.setSubjectID(rs.getString("SubjectID"));
                    res.setTestLevel(rs.getString("TestLevel"));
                    res.setTotalQuestion(rs.getInt("TotalQuestion"));
                    res.setUserName(rs.getString("UserName"));
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
