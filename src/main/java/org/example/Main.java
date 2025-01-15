package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Zmogenas", 99, "zmogus@email.com");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Serialization
        File outputFile = new File("src/main/java/org/example/rezultatas.json");
        objectMapper.writeValue(outputFile, person);

        //Deserialization
        File inputFile = new File("src/main/java/org/example/rezultatas.json");
        Person personDeserialised = objectMapper.readValue(inputFile, Person.class);
        System.out.println(personDeserialised);
    }

}