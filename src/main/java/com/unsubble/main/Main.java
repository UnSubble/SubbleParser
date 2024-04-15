package com.unsubble.main;

import com.unsubble.xml.BaseXMLParser;
import com.unsubble.xml.XMLParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        try {
            XMLParser xmlParser = new BaseXMLParser(Path.of("test.yml"));
            xmlParser.parseXML();
        } catch (Exception ex) {
            //logger.log(Level.WARN, ex.toString());
            ex.printStackTrace();
        }
    }
}
