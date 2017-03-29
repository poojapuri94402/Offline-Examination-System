package model.to;

public class SectionInfoTo {
    private String SectionId;
    private String SectionName;
    private String SubjectId;

    public String getSectionId() {
        return SectionId;
    }

    public void setSectionId(String SectionId) {
        this.SectionId = SectionId;
    }

    public String getSectionName() {
        return SectionName;
    }

    public void setSectionName(String SectionName) {
        this.SectionName = SectionName;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String SubjectId) {
        this.SubjectId = SubjectId;
    }
    public String toString(){
        return SectionId;
    }
}
