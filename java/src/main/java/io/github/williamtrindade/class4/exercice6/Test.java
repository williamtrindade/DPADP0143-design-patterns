package io.github.williamtrindade.class4.exercice6;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {

    public static void main(String[] args) throws MalformedURLException {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos JAR", "jar");
        jfc.setFileFilter(filter);
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File jar = jfc.getSelectedFile();
            URLClassLoader child = new URLClassLoader(new URL[]{jar.toURI().toURL()});
        }
    }

}
