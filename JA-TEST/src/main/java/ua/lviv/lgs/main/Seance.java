package ua.lviv.lgs.main;

public class Seance implements Comparable<Seance>  {
    private Movie movie;
    private Time startTime;
    private Time endTime;

    public Seance(Movie movie, Time startTime) {

        this.movie = movie;
        this.startTime = startTime;
        this.endTime = startTime.addTime(getMovie().getDuration());
    }





    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    @Override
    public int compareTo(Seance o) {
        if (startTime.getHour() == o.getStartTime().getHour()) {
            if (startTime.getMin() != o.getStartTime().getMin()) {
                return startTime.getMin() - o.getStartTime().getMin();
            } else {
                return startTime.getHour() - o.getStartTime().getHour();
            }
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Seance{" +
                "movie=" + movie +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
