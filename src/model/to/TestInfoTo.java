package model.to;

public class TestInfoTo {
    private int TestID;

    @Override
    public String toString() {
        return "TestInfoTo{" + "TestID=" + TestID + '}';
    }
    private String TestName;
    private String SubjectID;
    private String TestLevel;
    private int TotalQuestion;
    private String UserName;

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int TestID) {
        this.TestID = TestID;
    }

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String TestName) {
        this.TestName = TestName;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getTestLevel() {
        return TestLevel;
    }

    public void setTestLevel(String TestLevel) {
        this.TestLevel = TestLevel;
    }

    public int getTotalQuestion() {
        return TotalQuestion;
    }

    public void setTotalQuestion(int TotalQuestion) {
        this.TotalQuestion = TotalQuestion;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
}
