package com.alexander.parser.builder.impl;

import com.alexander.parser.builder.AbstractStudentsBuilder;
import com.alexander.parser.entity.Student;
import com.alexander.parser.exception.ParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Set;

public class StudentsDOMBuilder extends AbstractStudentsBuilder {
    private DocumentBuilder docBuilder;

    public StudentsDOMBuilder() throws ParserException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException("Ошибка конфигурации парсера: ", e);
        }
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void buildSetStudents(String fileName) throws ParserException {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList studentsList = root.getElementsByTagName("student");
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element studentElement = (Element) studentsList.item(i);
                Student student = buildStudent(studentElement);
                students.add(student);
            }
        } catch (IOException e) {
            throw new ParserException("File error or I/O error: ", e);
        } catch (SAXException e) {
            throw new ParserException("Parsing failure: ", e);
        }
    }

    private Student buildStudent(Element studentElement) {
        Student student = new Student();
        student.setFaculty(studentElement.getAttribute("faculty")); // проверка на null
        student.setName(getElementTextContent(studentElement, "name"));
        Integer tel = Integer.parseInt(getElementTextContent(
                studentElement,"telephone"));
        student.setTelephone(tel);
        Student.Address address = student.getAddress();
        Element addressElement = (Element) studentElement.getElementsByTagName(
                "address").item(0);
        address.setCountry(getElementTextContent(addressElement, "country"));
        address.setCity(getElementTextContent(addressElement, "city"));
        address.setStreet(getElementTextContent(addressElement, "street"));
        student.setLogin(studentElement.getAttribute("login"));
        return student;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
