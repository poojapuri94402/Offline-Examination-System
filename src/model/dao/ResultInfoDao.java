package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.ResultInfoTo;

public class ResultInfoDao {
 private String errormessage;
    private String query;
    private int ResultID;
    
    public String getErrormessage(){
        return errormessage;
    } 
    public boolean insertRecord(ResultInfoTo rit){
        try{
            String query="insert into SubjectInfo(ResultID,ResultDate,UserName,TestID,TotalQuestion,AttemptedQuestions,CorrectQuestions,ObtainedMarks)values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1,rit.getResultID());
            stmt.setTimestamp(2,rit.getResultDate());
            stmt.setString(3,rit.getUserName());
            stmt.setInt(4,rit.getTestID());
            stmt.setInt(5,rit.getTotalQuestion());
            stmt.setInt(6,rit.getAttemptedQuestion());
            stmt.setInt(7,rit.getCorrectQuestions());
            stmt.setInt(8,rit.getObtainedMarks());
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return false;
        }
    }
    public boolean updateRecord(ResultInfoTo rit){
        try{
            String query="update ResultInfo set ResultDate=?,UserName=?,TestID=?,TotalQuestion=?,AttemptedQuestions=?,CorrectQuestions=?,ObtainedMarks=? where ResultID=?";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setTimestamp(1,rit.getResultDate());
            stmt.setString(2,rit.getUserName());
            stmt.setInt(3,rit.getTestID());
            stmt.setInt(4,rit.getTotalQuestion());
            stmt.setInt(5,rit.getAttemptedQuestion());
            stmt.setInt(6,rit.getCorrectQuestions());
            stmt.setInt(7,rit.getObtainedMarks());
            stmt.setInt(8,rit.getResultID());
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return false;
        }
    }
    public boolean deleteRecord(String ResultID){
        try{
            String query="Delete from ResultInfo where ResultID=?";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,ResultID);
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return false;
        }
    }
    public ResultInfoTo getRecord(String ResutID){
        try{
            String query="select ResultID,ResultDate,UserName,TestID,TotalQuestion,AttemptedQuestions,CorrectQuestions,ObtainedMarks from ResultInfo";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1,ResultID);
            ResultInfoTo result=null;
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                result=new ResultInfoTo();
                result.setResultID(rs.getInt("ResultID"));
                result.setResultDate(rs.getTimestamp("ResultDate"));
                result.setUserName(rs.getString("UserName"));
                result.setTestID(rs.getInt("TestID"));
                result.setTotalQuestion(rs.getInt("TotalQuestion"));
                result.setAttemptedQuestion(rs.getInt("AttemptedQuestions"));
                result.setCorrectQuestions(rs.getInt("CorrectQuestions"));
                result.setObtainedMarks(rs.getInt("ObtainedMarks"));
            }
            rs.close();
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return null;
        }
    }    
        public List<ResultInfoTo> getAllRecord(){
        try {
            String query = "select ResultID,ResultDate,UserName,TestID,TotalQuestion,AttemptedQuestions,CorrectQuestions,ObtainedMarks from ResultInfoTo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<ResultInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ResultInfoTo res = new ResultInfoTo();
                    res.setResultID(rs.getInt("ResultID"));
                    res.setResultDate(rs.getTimestamp("ResultDate"));
                    res.setUserName(rs.getString("UserName"));
                    res.setTestID(rs.getInt("TestID"));
                    res.setTotalQuestion(rs.getInt("TotalQuestion"));
                    res.setAttemptedQuestion(rs.getInt("AttemptedQuestions"));
                    res.setCorrectQuestions(rs.getInt("CorrectQuestions"));
                    res.setObtainedMarks(rs.getInt("ObtainedMarks"));
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
