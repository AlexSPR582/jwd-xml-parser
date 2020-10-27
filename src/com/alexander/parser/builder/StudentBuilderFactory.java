package com.alexander.parser.builder;

import com.alexander.parser.builder.impl.StudentsDOMBuilder;
import com.alexander.parser.builder.impl.StudentsSAXBuilder;
import com.alexander.parser.builder.impl.StudentsEventStaxBuilder;
import com.alexander.parser.builder.impl.StudentsStreamStAXBuilder;
import com.alexander.parser.exception.ParserException;

public class StudentBuilderFactory {
    private enum TypeParser {
        SAX, EVENT_STAX, STREAM_STAX, DOM
    }

    public AbstractStudentsBuilder createStudentBuilder(String typeParser) throws ParserException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new StudentsDOMBuilder();
            case STREAM_STAX:
                return new StudentsStreamStAXBuilder();
            case EVENT_STAX:
                return new StudentsEventStaxBuilder();
            case SAX:
                return new StudentsSAXBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
