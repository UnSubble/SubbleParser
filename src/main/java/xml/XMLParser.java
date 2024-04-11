package xml;

import parser.Parser;

import java.io.InputStream;

public interface XMLParser extends Parser {

    XMLDocument parseXML(InputStream stream);
}
