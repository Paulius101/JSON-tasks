package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Zmogenas", 99, "zmogus@email.com");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //---------------------------------TASK-1---------------------------------//

        //Serialization
        File outputFile = new File("src/main/java/org/example/rezultatas.json");
        objectMapper.writeValue(outputFile, person);

        //Deserialization
        File inputFile = new File("src/main/java/org/example/rezultatas.json");
        Person personDeserialised = objectMapper.readValue(inputFile, Person.class);
        System.out.println(personDeserialised);

        //----------------------------------TASK-2--------------------------------//
        //Write Person to a string
        System.out.println(objectMapper.writeValueAsString(person));
        //Serialise to person.json
        serialiseToPersonsJSON(getPeople(), objectMapper);
        //Deserialise person.json
        deserialiseToPersonsList(objectMapper);
    }

    private static ArrayList<Person> getPeople() {
        ArrayList<Person> people = new ArrayList<>();
        Person person1 = new Person("Zmogenas1", 98, "zmogus1@email.com");
        Person person2 = new Person("Zmogenas2", 97, "zmogus2@email.com");
        Person person3 = new Person("Zmogenas3", 96, "zmogus3@email.com");
        people.add(person1);
        people.add(person2);
        people.add(person3);
        return people;
    }

    private static void serialiseToPersonsJSON(ArrayList<Person> list, ObjectMapper mapper) throws IOException {
        File outputFile = new File("src/main/java/org/example/persons.json");
        mapper.writeValue(outputFile, list);
    }

    private static void deserialiseToPersonsList(ObjectMapper mapper) throws IOException {
        File inputFile = new File("src/main/java/org/example/persons.json");
        List<Person> personsDeserialised = mapper.readValue(inputFile, new TypeReference<>() {
        });
        System.out.println(personsDeserialised.toString());
    }
}