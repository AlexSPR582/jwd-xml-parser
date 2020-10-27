package com.alexander.parser.main;

import com.alexander.parser.builder.AbstractStudentsBuilder;
import com.alexander.parser.builder.StudentBuilderFactory;
import com.alexander.parser.exception.ParserException;

public class Main {
    public static void main(String[] args) throws ParserException {
        StudentBuilderFactory sFactory = new StudentBuilderFactory();
        AbstractStudentsBuilder saxBuilder = sFactory.createStudentBuilder("sax");
        AbstractStudentsBuilder eventStaxBuilder = sFactory.createStudentBuilder("event_stax");
        AbstractStudentsBuilder streamStaxBuilder = sFactory.createStudentBuilder("stream_stax");
        AbstractStudentsBuilder domBuilder = sFactory.createStudentBuilder("dom");

        saxBuilder.buildSetStudents("data/students.xml");
        eventStaxBuilder.buildSetStudents("data/students.xml");
        streamStaxBuilder.buildSetStudents("data/students.xml");
        domBuilder.buildSetStudents("data/students.xml");

        System.out.println("SAX:");
        System.out.println(saxBuilder.getStudents());
        System.out.println();
        System.out.println("EVENT STAX:");
        System.out.println(eventStaxBuilder.getStudents());
        System.out.println();
        System.out.println("STREAM STAX:");
        System.out.println(streamStaxBuilder.getStudents());
        System.out.println();
        System.out.println("DOM:");
        System.out.println(domBuilder.getStudents());
    }
}
