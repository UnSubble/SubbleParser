package com.unsubble.validators.xml;

import com.unsubble.exceptions.DocumentValidationException;
import com.unsubble.validators.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class XMLValidator implements Validator {
    private static final Pattern pattern = Pattern.compile("^<\\?.*\\?>$");

    public boolean isXMLDeclarationValid(String content) {
        if (content == null)
            return false;
        Matcher matcher = pattern.matcher(content);
        if (matcher.matches())
            return true;
        throw new DocumentValidationException("Given XML Document's syntax is not valid!");
    }


    @Override
    public boolean isValid(String content) {
        return false;
    }


}
