package xml.dom;

import java.util.Map;

public interface Element {
    String getName();

    Attribute getAttribute(String name);

    Map<String, Attribute> getAttributes();
}
