package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.TestScheduleTo;

public class TestScheduleDao {

    private String errormessage;
    private String query;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(TestScheduleTo tsit) {
        try {
            String query = "insert into TestSchedule(FUserName,SUserName,TestDate,TestID)values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);

            stmt.setString(1, tsit.getFUserName());
            stmt.setString(2, tsit.getSUserName());
            stmt.setDate(3, tsit.getTestDate());
            stmt.setInt(4, tsit.getTestID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(TestScheduleTo tsit) {
        try {
            String query = "update TestSchedule set FUserName=?,SUserName=?,TestDate=?,TestID=? where ScheduleId=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, tsit.getFUserName());
            stmt.setString(2, tsit.getSUserName());
            stmt.setDate(3, tsit.getTestDate());
            stmt.setInt(4, tsit.getTestID());
            stmt.setInt(5, tsit.getScheduleId());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String ScheduleId) {
        try {
            String query = "Delete from TestSchedule where ScheduleId=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ScheduleId);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public TestScheduleTo getRecord(String ScheduleId) {
        try {
            String query = "select ScheduleId,FUserName,SUserName,TestDate,TestID from TestSchedule where ScheduleId=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, ScheduleId);
            TestScheduleTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TestScheduleTo();
                result.setScheduleId(rs.getInt("Schedule Id"));
                result.setFUserName(rs.getString("FUserName"));
                result.setSUserName(rs.getString("SUserName"));
                result.setTestDate(rs.getDate("TestDate"));
                result.setTestID(rs.getInt("TestID"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<TestScheduleTo> getAllRecord() {
        try {
            String query = "select ScheduleId,FUserName,SUserName,TestDate,TestID from TestSchedule";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<TestScheduleTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TestScheduleTo res = new TestScheduleTo();
                    res.setScheduleId(rs.getInt("ScheduleID"));
                    res.setFUserName(rs.getString("FUserName"));
                    res.setSUserName(rs.getString("SUserName"));
                    res.setTestDate(rs.getDate("TestDate"));
                    res.setTestID(rs.getInt("TestID"));
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
