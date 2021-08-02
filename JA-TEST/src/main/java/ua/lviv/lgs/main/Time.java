package ua.lviv.lgs.main;

public class Time {

    private int hour;
    private int min;


    public  Time(int hour, int min) {
        if ((min < 0) | (hour < 0))
            System.out.println("time < 0 ");
        else {
            if (min < 60) {
                this.min = min;
            } else if (min >= 60) {
                hour += min / 60;
                this.min = min % 60;
            }

            if (hour < 24) {
                this.hour = hour;
            } else {
                this.hour = hour % 24;
                System.out.println("Wrong hour value  > 24 ");
            }
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }








    public void setMin(int min) {
        this.min = min;
    }




    public Time addTime(Time addedTime) {
        int resultMin = this.getMin() + addedTime.getMin();
        int resultHour = this.getHour() + addedTime.getHour();
        return new Time(resultHour, resultMin);

    }


    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", min=" + min +
                '}';
    }


}
