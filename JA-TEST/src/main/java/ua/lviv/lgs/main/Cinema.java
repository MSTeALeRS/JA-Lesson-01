package ua.lviv.lgs.main;

import java.util.*;

public class Cinema {
    TreeMap<Days, Schedule> schedules = new TreeMap<>();
    private ArrayList<Movie> moviesLibrary = new ArrayList<>();

    private Time open;
    private Time close;


    public Cinema(TreeMap<Days, Schedule> schedules, ArrayList<Movie> moviesLibrary, Time open, Time close) {
        this.schedules = schedules;
        this.moviesLibrary = moviesLibrary;
        this.open = open;
        this.close = close;
    }

    public Cinema() {

    }

    public TreeMap<Days, Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(TreeMap<Days, Schedule> schedules) {
        this.schedules = schedules;
    }

    public ArrayList<Movie> getMoviesLibrary() {
        return moviesLibrary;
    }

    public void setMoviesLibrary(ArrayList<Movie> moviesLibrary) {
        this.moviesLibrary = moviesLibrary;
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public Cinema(Time open, Time close) {
        this.open = open;
        this.close = close;
    }

    public void addMovie() {
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter film title = ");

        String movieTitle = scanner.nextLine();

        System.out.println("Please enter hours and minutes for film duration = ");
        int s2 = scanner.nextInt();
        if (s2 >= 0 && s2 <= 24) {
        } else {
            throw new IllegalArgumentException("Film duration in hours out of range \"0 - 24\" ");
        }

        int s1 = scanner.nextInt();
        if (s1 >= 0 && s1 <= 60) {
        } else {
            throw new IllegalArgumentException("Film duration in minutes out of range \"0 - 60\" min");
        }
        Time time = new Time(s1, s2);
        Movie movie = new Movie();
        movie.setTitle(movieTitle);
        movie.setDuration(time);
        moviesLibrary.add(counter, movie);

        System.out.println(moviesLibrary);

    }

    public void addSeance() {
        System.out.println("Please enter hour and minutes when film starts = ");
        Scanner ss = new Scanner(System.in);
        int startTimeHour = ss.nextInt();
        int startTimeMinute = ss.nextInt();
        Time time = new Time(startTimeMinute, startTimeHour);

        System.out.println("Please enter hour and minutes when film ends = ");
        int endTimeHour = ss.nextInt();
        int endTimeMinute = ss.nextInt();
        Time time1 = new Time(endTimeMinute, endTimeHour);

        Seance seance = new Seance(getMoviesLibrary().listIterator().next(), time);

        System.out.println(seance);

        System.out.println("Please enter the day when seance take place = ");
        Scanner sp = new Scanner(System.in);
        String seanceDay = sp.next();
        try {
            boolean match = Arrays.stream(Days.values()).anyMatch(Days.valueOf(seanceDay.toUpperCase())::equals);
            if (match) {
                Days day = Days.valueOf(seanceDay.toUpperCase());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("No such day! Add day name carefully! ");

        }
        Schedule schedule = new Schedule();
        schedule.seances.add(seance);

        schedules.put(Days.valueOf(seanceDay.toUpperCase()), schedule);

        System.out.println(schedule);
        System.out.println(schedules);
    }

    public void removeMovie() {
        int v = 0;
        try {
            System.out.println("Please set the number of film for removing from list below: ");
            Scanner scanner = new Scanner(System.in);
            Map<Integer, String> mapOfFilmRemoving = new HashMap<>();
            for (Movie i : moviesLibrary) {
                mapOfFilmRemoving.put(v++, i.getTitle());

            }

            System.out.println(mapOfFilmRemoving);
            int numberForFilmRemoving = scanner.nextInt();
            for (Integer ignored : mapOfFilmRemoving.keySet()) {
                mapOfFilmRemoving.remove(numberForFilmRemoving);
                moviesLibrary.remove(numberForFilmRemoving);
                System.out.println("Library after removing film = " + moviesLibrary);
            }
        } catch (ConcurrentModificationException e) {
        }
    }

    public void removeSeance() {
        try {
            System.out.println("Please enter day for seance removing = ");

            Scanner scanner1 = new Scanner(System.in);
            String dayOfSeanceRemoving = scanner1.next();
            if (schedules.containsKey(Days.valueOf(dayOfSeanceRemoving.toUpperCase()))) {
                schedules.remove(Days.valueOf(dayOfSeanceRemoving.toUpperCase()));
                System.out.println("Schedule after removing seance by day selecting" + schedules);
            } else {
                System.out.println("No such seance!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("There no such day! Enter day name carefully!");
        }
    }

    @Override
    public String toString () {
        return "Cinema{" +
                "schedules=" + schedules +
                ", moviesLibrary=" + moviesLibrary +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}








