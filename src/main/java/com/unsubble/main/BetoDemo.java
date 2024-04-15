package com.unsubble.main;


import com.unsubble.yaml.BaseYAMLParser;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Objects;


public class BetoDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){


        try{
            Path path=Path.of("Demo.yml");
            BaseYAMLParser yamlParser=new BaseYAMLParser(path);
            yamlParser.parseYaml();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
