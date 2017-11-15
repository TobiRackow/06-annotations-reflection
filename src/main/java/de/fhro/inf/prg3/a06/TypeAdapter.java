package de.fhro.inf.prg3.a06;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.fhro.inf.prg3.a06.model.Joke;

public abstract class TypeAdapter {
    public Joke read(final JsonReader reader) {
        return null;
    }
    public void write(final JsonWriter writer, final Joke inst) {

    }
}
