package xml;

import java.io.InputStream;

public class BaseXMLParser implements XMLParser {

    private InputStream inputStream;

    @Override
    public XMLDocument parseXML(InputStream stream) {
        this.inputStream = stream;


    }
}
