package model.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.SubjectInfoTo;
        
public class SubjectInfoDao {
    private String errormessage;
    private String query;
    
    public String getErrormessage(){
        return errormessage;
    } 
    public boolean insertRecord(SubjectInfoTo sit){
       try{
            String query="insert into SubjectInfo(SubjectId,SubjectName,Description)values(?,?,?)";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,sit.getSubjectId());
            stmt.setString(2,sit.getSubjectName());
            stmt.setString(3,sit.getDescription());
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            if(errormessage.contains("PRIMARY")){
                errormessage="This SubjectID Already Exists";
            } 
            return false;
        }
    }
    public boolean updateRecord(SubjectInfoTo sit){
        try{
            String query="update SubjectInfo set SubjectName=?,Description=? where SubjectID=?";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,sit.getSubjectName());
            stmt.setString(2,sit.getDescription());
            stmt.setString(3,sit.getSubjectId());
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return false;
        }
    }
    public boolean deleteRecord(String SubjectID){
        try{
            String query="Delete from SubjectInfo where SubjectID=?";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,SubjectID);
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
    public SubjectInfoTo getRecord(String SubjectID){
        try{
            String query="select SubjectID,SubjectName,Description from SubjectInfo";
            PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,SubjectID);
            SubjectInfoTo result=null;
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                result=new SubjectInfoTo();
                result.setSubjectId(rs.getString("SubjectID"));
                result.setSubjectName(rs.getString("Subject Name"));
                result.setDescription(rs.getString("Description"));
            }
            rs.close();
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return null;
        }
    }
    public List<SubjectInfoTo> getAllRecord(){
        try {
            String query = "select SubjectId , SubjectName , Description from SubjectInfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<SubjectInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    SubjectInfoTo res = new SubjectInfoTo();
                    res.setSubjectId(rs.getString("SubjectId"));
                    res.setSubjectName(rs.getString("SubjectName"));
                    res.setDescription(rs.getString("Description"));
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
