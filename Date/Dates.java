package Date;

import java.text.DecimalFormat;

public class Dates {

    static class DateDiff{
        private String startDate;
        private String endDate;
        private int diff;
        public String getStart(){
            if(this.startDate.split(".").length == 1){
                DecimalFormat df = new DecimalFormat("00");
                String[] dateInfo = this.startDate.split(".");
                return (dateInfo[2] + "-" + df.format(dateInfo[1]) + "-" + df.format(dateInfo[0]));
            }
            return this.startDate;
        }
        public String getEnd(){
            if(this.endDate.split(".").length == 1){
                DecimalFormat df = new DecimalFormat("00");
                String[] dateInfo = this.startDate.split(".");
                return (dateInfo[2] + "-" + df.format(dateInfo[1]) + "-" + df.format(dateInfo[0]));
            }
            return this.endDate;
        }
        public int getDiff(){
            return this.diff;
        }
        public String toString(){
            
        }
    }
}
