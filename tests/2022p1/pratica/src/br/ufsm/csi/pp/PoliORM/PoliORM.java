package br.ufsm.csi.pp.PoliORM;

import br.ufsm.csi.pp.PersistenceLayer;
import br.ufsm.csi.pp.annotations.ChavePrimaria;
import br.ufsm.csi.pp.annotations.Coluna;
import br.ufsm.csi.pp.annotations.Tabela;

import java.lang.reflect.Method;

public class PoliORM implements PersistenceLayer {
    @Override
    public String generateInsertUpdate(Object o) {
        String tabela = o.getClass().getAnnotation(Tabela.class).nome();
        Long id = null;
        for (Method metodo : o.getClass().getMethods()) {
            if (metodo.getAnnotation(ChavePrimaria.class) != null) {
                try {
                    id = (Long) metodo.invoke(o);
                    break;
                } catch (Exception e) {
                    id = null;
                }

                System.out.println(id);
            }
        }

        StringBuilder sql = new StringBuilder();
        if (id == null) {
            // CREATE
            sql = new StringBuilder("INSERT INTO " + tabela + " (");
            boolean primeiro = true;
            for (Method metodo : o.getClass().getDeclaredMethods()) {
                String coluna = null;
                if (metodo.getAnnotation(Coluna.class) != null) {
                    try {
                        coluna = metodo.getAnnotation(Coluna.class).nome();
                        if (coluna.equals("ID")) {
                            coluna = null;
                        }
                    } catch (Exception e) {
                        coluna = null;
                    }
                    if (coluna != null) {
                        if (!primeiro) {
                            sql.append(", ");
                        }
                        primeiro = false;
                        sql.append(coluna);
                    }
                }
            }


            sql.append(") values (");
            boolean primeiroValor = true;
            for (Method metodo : o.getClass().getDeclaredMethods()) {
                if (metodo.getAnnotation(Coluna.class) != null) {
                    if (metodo.getAnnotation(Coluna.class).tipo().equals("bigint")) {
                        Long valor = null;
                        try {
                            valor = (Long) metodo.invoke(o);
                        } catch (Exception ignored) {
                        }
                        if (valor != null) {
                            if (!primeiroValor) {
                                sql.append(", ");
                            }
                            primeiroValor = false;
                            sql.append(valor);
                        }
                    } else if (metodo.getAnnotation(Coluna.class).tipo().equals("varchar")){
                        String valor = null;
                        try {
                            valor = (String) metodo.invoke(o);
                        } catch (Exception ignored) {
                        }
                        if (valor != null) {
                            if (!primeiroValor) {
                                sql.append(", ");
                            }
                            primeiroValor = false;
                            sql.append("'" + valor + "'");
                        }
                    }
                }
            }

            sql.append(")");
        } else {
            // UPDATE
            sql = new StringBuilder("UPDATE " + tabela + " SET ");

            boolean primeiro = true;

            for (Method metodo : o.getClass().getDeclaredMethods()) {
                String coluna = null;
                if (metodo.getAnnotation(Coluna.class) != null) {
                    try {
                        coluna = metodo.getAnnotation(Coluna.class).nome();
                        if (coluna.equals("ID")) {
                            coluna = null;
                        }
                    } catch (Exception e) {
                        coluna = null;
                    }
                    if (coluna != null) {

                        String valorFinal = null;
                        if (metodo.getAnnotation(Coluna.class).tipo().equals("bigint")) {
                            Long valor = null;
                            try {
                                valor = (Long) metodo.invoke(o);
                            } catch (Exception ignored) {
                            }
                            if (valor != null) {
                                if (!primeiro) {
                                    sql.append(", ");
                                }
                                valorFinal = ""+valor+"";
                            }
                        } else if (metodo.getAnnotation(Coluna.class).tipo().equals("varchar")){
                            String valor = null;
                            try {
                                valor = (String) metodo.invoke(o);
                            } catch (Exception ignored) {
                            }
                            if (valor != null) {
                                if (!primeiro) {
                                    sql.append(", ");
                                }
                                valorFinal = "'"+valor+"'";
                            }
                        }

                        primeiro = false;

                        String stringFinal = coluna + " = " + valorFinal;



                        sql.append(stringFinal);
                    }
                }
            }

            sql.append(" WHERE ");

            for (Method metodo : o.getClass().getDeclaredMethods()) {
                if (metodo.getAnnotation(ChavePrimaria.class) != null) {
                    String campoID = null;
                    try {
                        campoID = metodo.getAnnotation(Coluna.class).nome();
                    } catch (Exception e) {
                        campoID = null;
                    }

                    Long valorID = null;
                    try {
                        valorID = (Long) metodo.invoke(o);
                    } catch (Exception e) {
                        valorID = null;
                    }

                    sql.append(campoID + " = " + valorID);
                }
            }
        }

        return (sql + ";");
    }
}
