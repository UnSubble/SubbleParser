package com.unsubble.xml;

import com.unsubble.parser.Parser;
import com.unsubble.xml.dom.XMLDocument;

import java.io.IOException;

public interface XMLParser extends Parser {

    XMLDocument parseXML() throws IOException;
}
