package model.to;

public class TestQuestionTo {
    private int QuestionID;
    private String QuestionText;
    private String OptionA;
    private String OptionB;
    private String OptionC;
    private String OptionD;
    private String Answer;
    private String SectionID;
    private int TestID;
    private int Marks;

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int QuestionID) {
        this.QuestionID = QuestionID;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String QuestionText) {
        this.QuestionText = QuestionText;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String OptionA) {
        this.OptionA = OptionA;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String B) {
        this.OptionB = B;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setOptionC(String OptionC) {
        this.OptionC = OptionC;
    }

    public String getOptionD() {
        return OptionD;
    }

    public void setOptionD(String OptionD) {
        this.OptionD = OptionD;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public String getSectionID() {
        return SectionID;
    }

    public void setSectionID(String SectionID) {
        this.SectionID = SectionID;
    }

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int TestID) {
        this.TestID = TestID;
    }

    public int getMarks() {
        return Marks;
    }

    public void setMarks(int Marks) {
        this.Marks = Marks;
    }
}
