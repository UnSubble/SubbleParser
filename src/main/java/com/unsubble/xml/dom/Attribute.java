package com.unsubble.xml.dom;

import java.util.Optional;

public interface Attribute {
    String getName();

    <T> T getContentAs(Class<T> clazz);

    <T> Optional<T> tryGetContentAs(Class<T> clazz);

}
