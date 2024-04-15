package com.unsubble.validators.xml;

import java.io.IOException;
import java.io.Reader;

public final class XMLDeclarationParser {
    private XMLDeclarationParser() {
    }

    public static String parseDeclaration(Reader reader) throws IOException {
        char attrValue = '\0';
        /* tagCount:
         *      zero                      -> no tags found
         *      odd                       -> one or more tags opened
         *      even and bigger than zero -> one or more tags closed
         */
        byte tagCount = 0;
        StringBuilder builder = new StringBuilder();
        int nextInt;
        while ((nextInt =  reader.read()) > 0) {
            char next=(char) nextInt;
            if (next <= 31)
                continue;
            if (attrValue == '\0') {
                if (next == '<' || next == '>')
                    tagCount++;
            }
            if (next == '"' || next == '\'') {
                if (attrValue == '\0')
                    attrValue = next;
                else if (attrValue == next)
                    attrValue = '\0';
            }
            builder.append(next);
            if (tagCount % 2 == 0 && tagCount > 0)
                break;
        }
        return builder.isEmpty() ? null : builder.toString();
    }


}
