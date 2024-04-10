package xml.dom;

import generics.Node;

import java.util.Optional;

public class XMLNode implements Node {

    @Override
    public <T> T getValueAs(Class<T> clazz) {
        return null;
    }

    @Override
    public <T> Optional<T> tryGetValueAs(Class<T> clazz) {
        return Optional.empty();
    }
}
