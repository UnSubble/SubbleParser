package com.unsubble.yaml;


import com.unsubble.validators.Validator;
import com.unsubble.validators.xml.XMLDeclarationParser;
import com.unsubble.validators.xml.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.yaml.snakeyaml.Yaml;
import java.io.FileReader;
import java.io.FileNotFoundException;


import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class BaseYAMLParser implements YAMLParser{

    private Path path;
    private Validator validator;
    public BaseYAMLParser(Path path) throws FileNotFoundException {
        this.path=path;
        validator=new XMLValidator();
    }

    public void parseYaml() throws FileNotFoundException {

        try (Reader reader = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
            String content = XMLDeclarationParser.parseDeclaration(reader);
            LogManager.getLogger().info(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(){
        return null;
    }
}





