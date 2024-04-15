package com.unsubble.yaml.dom;


import com.unsubble.yaml.BaseYAMLParser;
import com.unsubble.yaml.YAMLParser;

import java.nio.file.Path;
import java.util.List;

public class BaseKey implements Key{



    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getOccupaiton() {
        return "";
    }

    @Override
    public List<String> getHobbies() {
        return List.of();
    }
}
