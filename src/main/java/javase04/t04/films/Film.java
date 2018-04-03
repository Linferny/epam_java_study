package javase04.t04.films;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude = "actors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film implements Serializable {
    @Getter
    @Setter
    String name;
    List<Actor> actors;

    public Actor[] getActors(){
        return actors.toArray(new Actor[0]);
    }

    public Film(String name) {
        this.name = name;
        actors = new ArrayList<>();
    }

    public void addActor(@NonNull Actor actor) {
        if (actors.contains(actor))
            return;
        actors.add(actor);
    }

    public boolean removeActor(@NonNull Actor actor){
        return actors.remove(actor);
    }


}
