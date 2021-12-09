package Task23;

public class CallLog {

    private String telNumber;
    private int duration;


    public CallLog(String telNumber, int duration) {
        this.telNumber = telNumber;
        this.duration = duration;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public int getDuration() {
        return duration;
    }
}
