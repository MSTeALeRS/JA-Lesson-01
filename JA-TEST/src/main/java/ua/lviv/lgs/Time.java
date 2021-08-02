package ua.lviv.lgs;

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



    public static Time addTime(Time time1, Time time2)  {
        int hour = time1.getHour() + time2.getHour();
        int min = time1.getMin() + time2.getMin();

        if (min >= 60) {
            hour = hour + 1;
            min = min - 60;
        } else if (hour >= 24) {
            hour = hour - 24;
        }

        return new Time(hour, min);
    }




    @Override
    public String toString() {
        return
                "hour=" + hour +
                ", min=" + min;
    }


}
