package br.ufsm.csi.pp;

import br.ufsm.csi.pp.PoliORM.PoliORM;
import br.ufsm.csi.pp.exemplo.ClasseExemplo;

public class Main {

    public static void main(String[] args) {
        PersistenceLayer persistenceLayer = new PoliORM(); //todo coloque aqui a forma de obter uma instância da sua implementação
        ClasseExemplo classeExemplo = new ClasseExemplo();
        classeExemplo.setAtributo1("valor 1");
        classeExemplo.setAtributo2("valor 2");
        classeExemplo.setCodigo(123456l);
        System.out.println(persistenceLayer.generateInsertUpdate(classeExemplo));
        classeExemplo.setId(1l);
        System.out.println(persistenceLayer.generateInsertUpdate(classeExemplo));
    }
}
