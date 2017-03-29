package model.to;

import java.sql.Timestamp;

public class ResultInfoTo {
    private int ResultID;
    private Timestamp ResultDate;
    private String UserName;
    private int TestID;
    private int TotalQuestion;

    public int getTotalQuestion() {
        return TotalQuestion;
    }

    public void setTotalQuestion(int TotalQuestion) {
        this.TotalQuestion = TotalQuestion;
    }
    private int AttemptedQuestion;
    private int CorrectQuestions;
    private int ObtainedMarks;

    public int getResultID() {
        return ResultID;
    }

    public void setResultID(int ResultID) {
        this.ResultID = ResultID;
    }

    public Timestamp getResultDate() {
        return ResultDate;
    }

    public void setResultDate(Timestamp ResultDate) {
        this.ResultDate = ResultDate;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int TestID) {
        this.TestID = TestID;
    }

    public int getAttemptedQuestion() {
        return AttemptedQuestion;
    }

    public void setAttemptedQuestion(int AttemptedQuestion) {
        this.AttemptedQuestion = AttemptedQuestion;
    }

    public int getCorrectQuestions() {
        return CorrectQuestions;
    }

    public void setCorrectQuestions(int CorrectQuestions) {
        this.CorrectQuestions = CorrectQuestions;
    }

    public int getObtainedMarks() {
        return ObtainedMarks;
    }

    public void setObtainedMarks(int ObtainedMarks) {
        this.ObtainedMarks = ObtainedMarks;
    }

}
