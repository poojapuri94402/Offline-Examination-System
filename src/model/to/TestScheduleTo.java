package model.to;

import java.sql.Date;

public class TestScheduleTo {
    private int ScheduleId;
    private String FUserName;
    private String SUserName;
    private Date TestDate;
    private int TestID;

    public int getScheduleId() {
        return ScheduleId;
    }

    public void setScheduleId(int ScheduleId) {
        this.ScheduleId = ScheduleId;
    }

    public String getFUserName() {
        return FUserName;
    }

    public void setFUserName(String FUserName) {
        this.FUserName = FUserName;
    }

    public String getSUserName() {
        return SUserName;
    }

    public void setSUserName(String SUserName) {
        this.SUserName = SUserName;
    }

    public Date getTestDate() {
        return TestDate;
    }

    public void setTestDate(Date TestDate) {
        this.TestDate = TestDate;
    }

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int TestID) {
        this.TestID = TestID;
    }
}
