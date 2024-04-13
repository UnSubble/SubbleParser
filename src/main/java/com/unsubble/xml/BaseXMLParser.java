package com.unsubble.xml;

import com.unsubble.Logger;
import com.unsubble.exceptions.InvalidFileExtensionException;
import com.unsubble.exceptions.UnreadableFileException;
import com.unsubble.validators.Validator;
import com.unsubble.xml.dom.ElementParser;
import com.unsubble.xml.dom.XMLDocument;
import org.apache.logging.log4j.Level;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseXMLParser implements XMLParser {

    private InputStream inputStream;
    private Validator validator;
    private static final int MAX_BUFFER_SIZE = 1024;

    public BaseXMLParser(Path path) throws IOException {
        checkPath(path);
        inputStream = Files.newInputStream(path);
    }

    private void checkPath(Path path) throws NoSuchFileException {
        if (Files.notExists(path))
            throw new NoSuchFileException(path.toAbsolutePath().toString());
        if (!Files.isReadable(path))
            throw new UnreadableFileException("File has no read permission.");
        if (!path.getFileName().toString().endsWith(".xml")) {
            String targetFileName = path.getFileName().toString();
            int extensionIndex = targetFileName.lastIndexOf(".") + 1;
            throw new InvalidFileExtensionException("xml", targetFileName.substring(extensionIndex));
        }
    }

    @Override
    public XMLDocument parseXML() throws IOException {
        byte[] rawArray = new byte[MAX_BUFFER_SIZE];
        int bufferSize;
        while ((bufferSize = inputStream.readNBytes(rawArray, 0, MAX_BUFFER_SIZE)) > 0) {
            Logger.getLogger().log(Level.INFO, bufferSize);
            byte[] bufferedArray = Arrays.copyOf(rawArray, bufferSize);
            Logger.getLogger().log(Level.DEBUG, new String(bufferedArray));
            List<Byte> list = """
                                <r><a>A</a><b c="\\ns">\\<B</b></r>""".chars().boxed().map(Integer::byteValue).toList();
            ElementParser.parse(new ArrayDeque<>(list), bufferedArray);
        }
        return null;
    }

    
}
