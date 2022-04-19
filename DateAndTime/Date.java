package DateAndTime;

import java.text.DecimalFormat;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int aYear, int aMonth, int aDay) throws DateException {
        if (aYear < 0 || aMonth < 1 || aMonth > 12 || aDay > 31 || aDay < 1) {
            String strErr = String.format("Illegal date %d.%d.%d", aDay, aMonth, aYear);
            throw new DateException(strErr);
        }
        this.year = aYear;
        this.month = aMonth;
        this.day = aDay;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("00");
        return (df.format(this.day) + "." + df.format(this.month) + "." + this.year);
    }
}
