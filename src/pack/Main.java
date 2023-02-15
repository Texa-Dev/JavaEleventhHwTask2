package pack;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Person p =new Person("Doe","John", LocalDate.of(1957,12,8), Person.Gender.MALE,true);

        Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new  TypeAdapter<Person>(){

            @Override
            public void write(JsonWriter jsonWriter, Person person) throws IOException {
                jsonWriter.beginObject();
                for (Field f : person.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    try {
                        jsonWriter.name(f.getName()).value(f.get(person).toString());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                jsonWriter.endObject();
            }

            @Override
            public Person read(JsonReader jsonReader) throws IOException {

                    Person person= new Person();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()){
                        switch (jsonReader.nextName()){
                            case "surname"->person.setSurname(jsonReader.nextString());
                            case "name"->person.setName(jsonReader.nextString());
                            case "birthDate"->person.setBirthDate(LocalDate.parse(jsonReader.nextString()));
                            case "gender"->person.setGender(Person.Gender.valueOf(jsonReader.nextString()));
                            case "activated"->person.setActivated(Boolean.parseBoolean(jsonReader.nextString()));
                        }
                    }
                    jsonReader.endObject();
                    return person;

            }
        }).create();

        String json = gson.toJson(p);

        System.out.println(json);

        Person p2 = gson.fromJson(json, Person.class);

        System.out.println(p2);

    }
}