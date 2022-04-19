package DateAndTime;

import java.text.DecimalFormat;

public class DateTime extends Date {
    private int hour;
    private int minute;
    private int second;

    public DateTime(int aYear, int aMonth, int aDay, int aHour, int aMinute, int aSecond) throws DateException {
        super(aYear, aMonth, aDay);
        if (aHour < 0 || aHour > 23 || aMinute < 0 || aMinute > 59 || aSecond < 0 || aSecond > 59) {
            DecimalFormat df = new DecimalFormat("00");
            throw new DateException("Illegal time " + df.format(aHour) + ":" + df.format(aMinute) + ":" + df.format(aSecond));
        }
        this.hour = aHour;
        this.minute = aMinute;
        this.second = aSecond;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("00");
        String dateStr = super.toString();
        String timeStr = df.format(this.hour) + ":" + df.format(this.minute) + ":" + df.format(this.second);
        return (dateStr + " " + timeStr);
    }
}
