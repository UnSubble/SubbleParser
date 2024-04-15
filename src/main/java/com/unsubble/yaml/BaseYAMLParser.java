package com.unsubble.yaml;


import com.unsubble.util.FileUtil;
import com.unsubble.validators.Validator;
import com.unsubble.validators.xml.XMLDeclarationParser;
import com.unsubble.validators.xml.XMLValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.yaml.snakeyaml.Yaml;
import java.io.FileReader;
import java.io.FileNotFoundException;


import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.*;

public class BaseYAMLParser implements YAMLParser{

    private Path path;
    private Validator validator;
    public BaseYAMLParser(Path path) throws FileNotFoundException, NoSuchFileException {
        this.path=path;
        validator=new XMLValidator();
        FileUtil.checkPath(path,"yml");
    }

    public void parseYaml() throws FileNotFoundException {
        try (Reader reader = new FileReader(path.toFile(), StandardCharsets.UTF_8)) {
            String content = XMLDeclarationParser.parseDeclaration(reader);
            LogManager.getLogger().log(Level.INFO,content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(){
        return null;
    }
}





