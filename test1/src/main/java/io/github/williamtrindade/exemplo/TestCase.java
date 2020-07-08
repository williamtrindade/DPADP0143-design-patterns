package io.github.williamtrindade.exemplo;

import io.github.williamtrindade.FormGenerator;

import java.util.HashMap;
import java.util.Map;

public class TestCase {

    private final FormGenerator formGenerator;
    private final ClasseExemplo classeExemplo;

    public TestCase(FormGenerator formGenerator, ClasseExemplo classeExemplo) {
        this.formGenerator = formGenerator;
        this.classeExemplo = classeExemplo;
    }

    public static void main(String[] args) {
        FormGenerator formGenerator = null; //incluir o seu form aqui
        ClasseExemplo classeExemplo = new ClasseExemplo();
        classeExemplo.setAtivo(true);
        classeExemplo.setId((long) 111);
        classeExemplo.setCodigo((long) 1000);
        classeExemplo.setAtributo1("asdfadsfasdfasdfasdfasdfasdfasdf");
        TestCase testCase = new TestCase(formGenerator, classeExemplo);
        testCase.test1().test2().test3();
    }

    public TestCase test1() {
        System.out.println(formGenerator.generateForm(classeExemplo));
        return this;
    }


    public TestCase test2() {
        System.out.println(formGenerator.generateReadOnlyView(classeExemplo));
        return this;
    }

    public TestCase test3() {
        Map<String, String> req = new HashMap<>();
        req.put("id", "111");
        req.put("codigo", "1000");
        req.put("atributo1", "asdfasdfasdfasdfasdf");
        req.put("atributo2", "asdfasdfasdfasdfasdf");
        req.put("ativo", "true");
        ClasseExemplo ex = (ClasseExemplo) formGenerator.populateObject(
                req,
                ClasseExemplo.class
        );
        System.out.println(formGenerator.generateReadOnlyView(ex));
        return this;
    }

}
