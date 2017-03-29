package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.SectionInfoTo;

public class SectionInfoDao {
private String errormessage;
    private String query;
    
    public String getErrormessage(){
        return errormessage;
    } 
 public boolean insertRecord(SectionInfoTo Sit){
        try{
            String query="insert into SectionInfo(SectionId,SectionName,SubjectId)values(?,?,?)";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,Sit.getSectionId());
            stmt.setString(2,Sit.getSectionName());
            stmt.setString(3,Sit.getSubjectId());
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            if(errormessage.contains("Duplicate entry")){
                errormessage="This SectionID Already Exists";
            }
            return false;
        }
    }    
 public boolean updateRecord(SectionInfoTo Sit){
        try{
            String query="update SectionInfo set SectionName=?,SubjectId=? where SectionId=?";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,Sit.getSectionName());
            stmt.setString(2,Sit.getSubjectId());
            stmt.setString(3,Sit.getSectionId());
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return false;
        }
    }
  public boolean deleteRecord(String SectionID){
        try{
            String query="Delete from SectionInfo where SectionId=?";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,SectionID);
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            if(errormessage.contains("foreign")){
                errormessage="This SubjectID is Assigned to a Section";
            }

            return false;
        }
    }
    public SectionInfoTo getRecord(String SectionId){
        try{
            String query="select SectionId,SectionName,SubjectId from SectionInfo where SectionId=?";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,SectionId);
            SectionInfoTo result=null;
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                result=new SectionInfoTo();
                result.setSectionId(rs.getString("SectionId"));
                result.setSectionName(rs.getString("SectionName"));
                result.setSubjectId(rs.getString("SubjectId"));
            }
            rs.close();
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return null;
        }
    }
    public List<SectionInfoTo> getAllRecord(){
        try {
            String query = "select SectionId , SectionName , SubjectId from SectionInfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<SectionInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    SectionInfoTo res = new SectionInfoTo();
                    res.setSectionId(rs.getString("SectionId"));
                    res.setSectionName(rs.getString("SectionName"));
                    res.setSubjectId(rs.getString("SubjectId"));
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
