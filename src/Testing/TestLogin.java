package Testing;

import java.util.Scanner;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTo;
import java.sql.Timestamp;

public class TestLogin {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LoginInfoTo lit=new LoginInfoTo();
        System.out.print("Enter User Name: ");
        lit.setUserName(sc.nextLine());
        System.out.print("Enter Password: ");
        lit.setPassword(sc.nextLine());
        System.out.print("Enter Role Name: ");
        lit.setRoleName(sc.nextLine());
        //System.out.println("Enter Last Login: ");
        //lit.setLastLogin(date.getTime());
        LoginInfoDAO action=new LoginInfoDAO();
        if(action.insertRecord(lit)){
            System.out.println("Record Is Added in System");
        }else{
            System.out.println(action.getErrormessage());
        }
    }
}
