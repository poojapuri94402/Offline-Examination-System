package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.TestQuestionTo;

public class TestQuestionDao {

    private String errormessage;
    private String query;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(TestQuestionTo tqit) {
        try {
            String query = "insert into TestQuestion(QuestionID,QuestionText,OptionA,OptionB,OptionC,OptionD,Answer,SectionID,TestID,Marks)values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, tqit.getQuestionID());
            stmt.setString(2, tqit.getQuestionText());
            stmt.setString(3, tqit.getOptionA());
            stmt.setString(4, tqit.getOptionB());
            stmt.setString(5, tqit.getOptionC());
            stmt.setString(6, tqit.getOptionD());
            stmt.setString(7, tqit.getAnswer());
            stmt.setString(8, tqit.getSectionID());
            stmt.setInt(9, tqit.getTestID());
            stmt.setInt(10, tqit.getMarks());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(TestQuestionTo tqit) {
        try {
            String query = "update TestQuestion set QuestionText=?,OptionA=?,OptionB=?,OptionC=?,OptionD=?,Answer=?,SectionID=?,TestID=?,Marks=? where QuestionID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, tqit.getQuestionText());
            stmt.setString(2, tqit.getOptionA());
            stmt.setString(3, tqit.getOptionB());
            stmt.setString(4, tqit.getOptionC());
            stmt.setString(5, tqit.getOptionD());
            stmt.setString(6, tqit.getAnswer());
            stmt.setString(7, tqit.getSectionID());
            stmt.setInt(8, tqit.getTestID());
            stmt.setInt(9, tqit.getMarks());
            stmt.setInt(10, tqit.getQuestionID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String QuestionID) {
        try {
            String query = "Delete from TestQuestion where QuestionID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, QuestionID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public TestQuestionTo getRecord(String QuestionID) {
        try {
            String query = "select QuestionID,QuestionText,OptionA,OptionB,OptionC,OptionD,Answer,SectionID,TestID,Marks from TestQuestion where QuestionID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, QuestionID);
            TestQuestionTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TestQuestionTo();
                result.setQuestionID(rs.getInt("QuestionID"));
                result.setQuestionText(rs.getString("QUestionText"));
                result.setOptionA(rs.getString("OptionA"));
                result.setOptionB(rs.getString("OptionB"));
                result.setOptionC(rs.getString("OptionC"));
                result.setOptionD(rs.getString("OptionD"));
                result.setAnswer(rs.getString("Answer"));
                result.setSectionID(rs.getString("SectionID"));
                result.setTestID(rs.getInt("TestID"));
                result.setMarks(rs.getInt("Marks"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<TestQuestionTo> getAllRecord() {
        try {
            String query = "select QuestionID,QuestionText,OptionA,OptionB,OptionC,OptionD,Answer,SectionID,TestID,Marks from TestQuestion";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<TestQuestionTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TestQuestionTo res = new TestQuestionTo();
                    res.setQuestionID(rs.getInt("QuestionID"));
                    res.setQuestionText(rs.getString("QuestionText"));
                    res.setOptionA(rs.getString("OptionA"));
                    res.setOptionB(rs.getString("OptionB"));
                    res.setOptionC(rs.getString("OptionC"));
                    res.setOptionD(rs.getString("OptionD"));
                    res.setAnswer(rs.getString("Answer"));
                    res.setSectionID(rs.getString("SectionID"));
                    res.setTestID(rs.getInt("TestID"));
                    res.setMarks(rs.getInt("Marks"));
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
    
    public List<TestQuestionTo> getAllRecord(int testid) {
        try {
            String query = "select QuestionID,QuestionText,OptionA,OptionB,OptionC,OptionD,Answer,SectionID,TestID,Marks from TestQuestion where testid = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1,testid);
            List<TestQuestionTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TestQuestionTo res = new TestQuestionTo();
                    res.setQuestionID(rs.getInt("QuestionID"));
                    res.setQuestionText(rs.getString("QuestionText"));
                    res.setOptionA(rs.getString("OptionA"));
                    res.setOptionB(rs.getString("OptionB"));
                    res.setOptionC(rs.getString("OptionC"));
                    res.setOptionD(rs.getString("OptionD"));
                    res.setAnswer(rs.getString("Answer"));
                    res.setSectionID(rs.getString("SectionID"));
                    res.setTestID(rs.getInt("TestID"));
                    res.setMarks(rs.getInt("Marks"));
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
