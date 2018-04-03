package javase04.t04.main;

import javase04.t04.films.Actor;
import javase04.t04.films.Film;
import javase04.t04.films.FilmLibrary;

public class Main {
    public static void main(String[] args) {
        String fileName = "Javase04-t04-serialized";

        Actor a1 = new Actor("Name1", "Surname1", "Patronymic1");
        Actor a2 = new Actor("Name2", "Surname2", "Patronymic2");
        Actor a3 = new Actor("Name3", "Surname3", "Patronymic3");
        Actor a4 = new Actor("Name4", "Surname4", "Patronymic4");

        Film f1 = new Film("film1");
        Film f2 = new Film("film2");

        FilmLibrary library = new FilmLibrary();

        library.addActor(a1);
        library.addActor(a2);
        library.addActor(a3);
        library.addActor(a4);

        library.addFilm(f1);
        library.addFilm(f2);

        library.addActorToFilm(f1.getName(), a1);
        library.addActorToFilm(f1.getName(), a2);
        library.addActorToFilm(f1.getName(), a3);
        library.addActorToFilm(f2.getName(), a1);
        library.addActorToFilm(f2.getName(), a4);

        library.printAll();

        System.out.println("------------------------------");

        library.serialize(fileName);

        library = FilmLibrary.deserialize(fileName);


        Film f3 = new Film("film3");

        library.addFilm(f3);

        library.addActorToFilm(f3.getName(), library.getActors()[0]);

        library.serialize(fileName);

        library = library.deserialize(fileName);


        library.printAll();
    }
}
