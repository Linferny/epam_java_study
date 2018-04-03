package javase04.t04.films;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmLibrary implements Serializable {
    List<Film> films;
    List<Actor> actors;

    public Actor[] getActors(){
        return actors.toArray(new Actor[0]);
    }

    public FilmLibrary() {
        films = new ArrayList<>();
        actors = new ArrayList<>();
    }

    public boolean addActor(@NonNull Actor actor) {
        if (actors.contains(actor))
            return false;
        return actors.add(actor);
    }

    public boolean removeActor(@NonNull Actor actor) {
        return actors.remove(actor);
    }

    public boolean addFilm(@NonNull Film film) {
        if (films.contains(film))
            return false;
        return films.add(film);
    }

    public boolean addActorToFilm(@NonNull String filmName, @NonNull Actor actor) {
        for (Film f : films) {
            if (f.getName().equals(filmName)) {
                f.addActor(actor);
                return true;
            }
        }
        return false;
    }

    public boolean removeActorFromFilm(@NonNull String filmName, @NonNull Actor actor) {
        for (Film f : films) {
            if (f.getName().equals(filmName)) {
                return f.removeActor(actor);
            }
        }
        return false;
    }

    public void printAll(){
        for (Film f:
             films) {
            System.out.println(f.getName());
            Arrays.stream(f.getActors()).forEach(System.out::println);
            System.out.println();
        }
    }

    public void serialize(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                if (file.getParentFile() != null)
                    Files.createDirectories(Paths.get(file.getPath()).getParent());
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(this);
            os.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static FilmLibrary deserialize(String fileName){
        File file = new File(fileName);
        if (!file.exists())
            return null;

        FilmLibrary fl = null;

        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
            fl = (FilmLibrary)is.readObject();
        }catch (IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return fl;
    }
}
