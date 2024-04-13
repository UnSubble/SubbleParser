package com.unsubble.xml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class XMLDocumentParser extends BaseXMLParser {
    public XMLDocumentParser(Path path) throws IOException {
        super(path);
    }
}
