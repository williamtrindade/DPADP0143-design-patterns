package io.github.williamtrindade.unity1.class4.exercise6;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderService {

    public static URLClassLoader pushToClassLoader(File file) throws MalformedURLException {
        return new URLClassLoader(new URL[]{file.toURI().toURL()});
    }

}
