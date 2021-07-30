package sample.utility;

import java.sql.Timestamp;

public class TimeStampMaker {
    public int questionNo;
    public int point;
    public Timestamp timestamp;
    public TimeStampMaker(int questionNo,boolean point){
        this.questionNo = questionNo;
        this.point = (point)?1:0;
        timestamp = new Timestamp(System.currentTimeMillis());
    }
}
