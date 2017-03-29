package Testing;

import java.util.Scanner;
import model.dao.SubjectInfoDao;
import model.to.SubjectInfoTo;

public class TestSubject {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SubjectInfoTo sit=new SubjectInfoTo();
        System.out.print("Enter Subject ID: ");
        sit.setSubjectId(sc.nextLine());
        System.out.print("Enter Subject Name: ");
        sit.setSubjectName(sc.nextLine());
        System.out.print("Enter Subject Description: ");
        sit.setDescription(sc.nextLine());
        SubjectInfoDao action=new SubjectInfoDao();
        if(action.insertRecord(sit)){
            System.out.println("Record is added to the system");
        }else{
            System.out.println("Record is not added in the system");
        }
    }
}
