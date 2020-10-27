package com.alexander.parser.builder.impl;

import com.alexander.parser.builder.AbstractStudentsBuilder;
import com.alexander.parser.exception.ParserException;
import com.alexander.parser.handler.StudentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class StudentsSAXBuilder extends AbstractStudentsBuilder {
    private StudentHandler sh;
    private XMLReader reader;

    public StudentsSAXBuilder() throws ParserException {
        sh = new StudentHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            throw new ParserException("ошибка SAX парсера: ", e);
        }
    }

    public void buildSetStudents(String fileName) throws ParserException {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            throw new ParserException("ошибка SAX парсера: ", e);
        } catch (IOException e) {
            throw new ParserException("ошибка I/О потока: ", e);
        }
        students = sh.getStudents();
    }
}
