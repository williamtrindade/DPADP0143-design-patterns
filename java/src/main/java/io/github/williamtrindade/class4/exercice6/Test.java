package io.github.williamtrindade.class4.exercice6;

import io.github.williamtrindade.class2.exercice2.Bank;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class Test {

    public static void main(String[] args) throws MalformedURLException {
//        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos JAR", "jar");
//        jfc.setFileFilter(filter);
//        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//            File jar = jfc.getSelectedFile();
//            URLClassLoader child = new URLClassLoader(new URL[]{jar.toURI().toURL()});
//        }
        Class<Bank> bankClass = Bank.class;

        for (Method method : bankClass.getMethods()) {
           // Get annotation data
            Example annotation = method.getAnnotation(Example.class);
            if (annotation != null) {
                String annotationValue = annotation.name();
                System.out.println("@Example(name = \"" + annotationValue + "\")");

                // Get method return type and name
                System.out.print(method.getReturnType().getName() + " / " + method.getName() + "(");

                // Get method parameters
                boolean isFirst = true;
                for (Class<?> param : method.getParameterTypes()) {
                    if (!isFirst) {
                        System.out.print(", ");
                    }
                    System.out.print(param.getName());
                    isFirst = false;
                    // method.invoke()
                }
                System.out.println(")");
            }
        }
    }
}
