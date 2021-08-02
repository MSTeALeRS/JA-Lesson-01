package ua.lviv.lgs;

import java.util.Scanner;

public class main {
    static void menu() {
        System.out.println("1 додає фільм в фільмотеку moviesLibrary,");
        System.out.println("2 додає сеанс фільму в розклад");
        System.out.println("3 повністю видаляє фільм з фільмотеки і розкладу");
        System.out.println("4 видаляє конкретний сеанс фільму в конкретний день");


    }
    public static void main(String[] args) {


        Cinema cinema = new Cinema();
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();


            switch (sc.next()) {

                case "1": {
                    cinema.addMovie();
                    break;
                }
                case "2": {
                    cinema.addSeance();
                }
                case "3": {cinema.removeMovie();}
                case "4": {cinema.removeSeance();}
            }
            }
        }
    }