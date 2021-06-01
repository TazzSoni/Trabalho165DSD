/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.ColaboradorClt;
import Model.ColaboradorTemporario;
import Model.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class PersisteDados {

    private String dados;
    private List<Pessoa> pessoas = new ArrayList();

    public PersisteDados() {
    }

    public void criaPessoa(String dados) {

        this.dados = dados;
        String[] textoSeparado = dados.split(";");
        String comando = textoSeparado[0].toLowerCase();

        switch (comando) {
            case "insert":
                Pessoa pessoa;
                if (textoSeparado[4].equals("clt")) {
                    pessoa = new ColaboradorClt(textoSeparado[2], textoSeparado[1],
                            textoSeparado[3], textoSeparado[5], textoSeparado[6], textoSeparado[7], textoSeparado[8]);
                } else {
                    pessoa = new ColaboradorTemporario(textoSeparado[2], textoSeparado[1],
                            textoSeparado[3], textoSeparado[5], textoSeparado[6], textoSeparado[7], textoSeparado[8]);
                }
                insert(pessoa);
                break;
            case "update":
                
                if (textoSeparado[4].equals("clt")) {
                    pessoa = new ColaboradorClt(textoSeparado[2], textoSeparado[1],
                            textoSeparado[3], textoSeparado[5], textoSeparado[6], textoSeparado[7], textoSeparado[8]);
                } else {
                    pessoa = new ColaboradorTemporario(textoSeparado[2], textoSeparado[1],
                            textoSeparado[3], textoSeparado[5], textoSeparado[6], textoSeparado[7], textoSeparado[8]);
                }
                update(pessoa);
                break;
            case "get":
                get(textoSeparado[1]);
                break;
            case "delete":
                delete(textoSeparado[1]);
                break;
            case "list":
                list();
                break;
            default:

        }
    }

    private void insert(Pessoa pessoa) {
        pessoas.add(pessoa);
        System.out.println(pessoas.toString());
    }

    private String update(Pessoa p) {
        int indice = getByCpf(p.getCpf());
        if (indice >= 0) {
            pessoas.remove(indice);
            pessoas.add(p);
            System.out.println(pessoas.toString());
            return "Pessoa atualizada com sucesso";
        } else {
            return "Pessoa não encontrada";
        }
    }

    private String delete(String cpf) {
        String mensagem = "";
        int indice = getByCpf(cpf);
        if (pessoas.size() > 0) {
            if (indice >= 0) {
                pessoas.remove(indice);
                mensagem = "Pessoa removida com sucesso";

            } else {
                mensagem = "Pessoa não encontrada";
            }
        } else {
            mensagem = "Sem pessoas cadastradas";
        }
        return mensagem;
    }

    private String get(String cpf) {
        String mensagem = "";
        if (pessoas.size() > 0) {
            if (getByCpf(cpf) >= 0) {
                Pessoa p1 = pessoas.get(getByCpf(cpf));
                mensagem = "<" + p1.getCpf() + ">" + "<" + p1.getNome() + ">" + "<" + p1.getEndereco() + ">"
                        + "<" + p1.getSetor().getNome() + ">" + "<" + p1.getSetor().getMatricula() + ">";
            } else {
                mensagem = "Pessoa não encontrada";
            }
        } else {
            mensagem = "Sem pessoas cadastradas";
        }
        System.out.println(mensagem);
        return mensagem;
    }

    private String list() {
        String retorno = "";
        if (pessoas.size() < 10) {
            retorno += "0" + pessoas.size();

        } else {
            retorno += pessoas.size();
        }
        for (Pessoa p : pessoas) {
            retorno += "\n" + p.getCpf() + ";" + p.getNome() + ";" + p.getEndereco() + ";" + p.getSetor().getNome() + ";" + p.getSetor().getMatricula();
        }
        System.out.println(retorno);
        return retorno;
    }

    private int getByCpf(String cpf) {
        int index = -1;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getCpf().equals(cpf)) {
                index = i;
            }
        }
        return index;
    }

    private String getByNome(String n) {
        String nome = "";
        for (Pessoa p : pessoas) {
            if (p.getNome().equals(n)) {
                nome = n;
            }
        }
        return n;
    }

    public void addPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

}
