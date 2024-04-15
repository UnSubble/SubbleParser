package com.unsubble.xml;

import com.unsubble.exceptions.InvalidFileExtensionException;
import com.unsubble.exceptions.UnreadableFileException;
import com.unsubble.validators.xml.XMLDeclarationParser;
import com.unsubble.validators.xml.XMLValidator;
import com.unsubble.xml.dom.XMLDocument;
import org.apache.logging.log4j.LogManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class BaseXMLParser implements XMLParser {

    private BufferedReader reader;
    private final XMLValidator validator;
    private String repo;
    private final Path path;

    public BaseXMLParser(Path path) throws IOException {
        checkPath(path);
        this.path = path;
        validator = new XMLValidator();
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
        parseXMLDeclaration();
        return null;
    }

    private void parseXMLDeclaration() {
        try (Reader reader = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
            String content = XMLDeclarationParser.parseDeclaration(reader);
            boolean res = validator.isXMLDeclarationValid(content);
            LogManager.getLogger().info(content);
            LogManager.getLogger().info(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
