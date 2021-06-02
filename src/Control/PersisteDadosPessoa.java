/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.ColaboradorClt;
import Model.ColaboradorTemporario;
import Model.Pessoa;
import Model.Setor;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class PersisteDadosPessoa {

    private String dados;
    private List<Pessoa> pessoas = new ArrayList();
    private List<Setor> setores = new ArrayList();

    public PersisteDadosPessoa() {
    }
//"insert;00783962042;LacoSouzaTassoni;Rua arbt Wagner;clt;mecânica;123456;032021;mecânico"
    public void criaPessoa(String dados) {

        this.dados = dados;
        String[] textoSeparado = dados.split(";");
        String comando = textoSeparado[0].toLowerCase();
        Pessoa pessoa;

        switch (comando) {
            case "insertPessoa":
                if (textoSeparado[4].equals("clt")) {
                    pessoa = new ColaboradorClt(textoSeparado[2], textoSeparado[1],
                            textoSeparado[3], textoSeparado[5], textoSeparado[6], textoSeparado[7], textoSeparado[8]);
                } else {
                    pessoa = new ColaboradorTemporario(textoSeparado[2], textoSeparado[1],
                            textoSeparado[3], textoSeparado[5], textoSeparado[6], textoSeparado[7], textoSeparado[8]);
                }
                insertPessoa(pessoa);
                break;
            case "updatePessoa":

                if (textoSeparado[4].equals("clt")) {
                    pessoa = new ColaboradorClt(textoSeparado[2], textoSeparado[1],
                            textoSeparado[3], textoSeparado[5], textoSeparado[6], textoSeparado[7], textoSeparado[8]);
                } else {
                    pessoa = new ColaboradorTemporario(textoSeparado[2], textoSeparado[1],
                            textoSeparado[3], textoSeparado[5], textoSeparado[6], textoSeparado[7], textoSeparado[8]);
                }
                updatePessoa(pessoa);
                break;
            case "getPessoa":
                getPessoa(textoSeparado[1]);
                break;
            case "deletePessoa":
                deletePessoa(textoSeparado[1]);
                break;
            case "listPessoa":
                listPessoa();
                break;
            default:

        }
    }

    private void insertPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        System.out.println(pessoas.toString());
    }

    private String updatePessoa(Pessoa p) {
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

    private String deletePessoa(String cpf) {
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

    private String getPessoa(String cpf) {
        String mensagem = "";
        if (pessoas.size() > 0) {
            if (getByCpf(cpf) >= 0) {
                Pessoa p1 = pessoas.get(getByCpf(cpf));
                mensagem = "<" + p1.getCpf() + ">" + "<" + p1.getNome() + ">" + "<" + p1.getEndereco() + ">"
                        + "<" + p1.getSetor().getNome() + ">" + "<" + p1.getSetor().getEquipe()+ ">";
            } else {
                mensagem = "Pessoa não encontrada";
            }
        } else {
            mensagem = "Sem pessoas cadastradas";
        }
        System.out.println(mensagem);
        return mensagem;
    }

    private String listPessoa() {
        String retorno = "";
        if (pessoas.size() < 10) {
            retorno += "0" + pessoas.size();

        } else {
            retorno += pessoas.size();
        }
        for (Pessoa p : pessoas) {
            retorno += "\n" + p.getCpf() + ";" + p.getNome() + ";" + p.getEndereco() + ";" + p.getSetor().getNome() + ";" + p.getSetor().getEquipe();
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
////////////////////////////////////////////////////////////////////////////////////////////////
    //MÉTODOS REFERENTES A SETOR
////////////////////////////////////////////////////////////////////////////////////////////////

    public void criaSetor(String dados) {

        this.dados = dados;
        String[] textoSeparado = dados.split(";");
        String comando = textoSeparado[0].toLowerCase();
        Setor setor = new Setor();

        switch (comando) {
            case "insertsetor":
                setor.setNome(textoSeparado[1].toLowerCase());
                setor.setEquipe(textoSeparado[2]);
                insertSetor(setor);
                break;
            case "updatesetor":
                setor.setNome(textoSeparado[2].toLowerCase());
                setor.setEquipe(textoSeparado[3]);
                updateSetor(textoSeparado[1].toLowerCase(),setor);
                break;
            case "getsetor":
                getSetor(textoSeparado[1].toLowerCase());
                break;
            case "deletesetor":
                deleteSetor(textoSeparado[1].toLowerCase());
                break;
            case "listsetor":
                listSetor();
                break;
            default:

        }
    }

    //"insertPessoa;00783962042;LacoSouzaTassoni;Rua arbt Wagner;clt;032021;mecânico;Setor"
    //"insertSetor;Mecanica;000111"
    private void insertSetor(Setor setor) {
        setores.add(setor);
    }

    private String updateSetor(String s, Setor n) {
        int indice = getSetorByNome(s);
        if (indice >= 0) {
            setores.remove(indice);
            setores.add(n);

            return "Pessoa atualizada com sucesso";
        } else {
            return "Pessoa não encontrada";
        }
    }

    private String deleteSetor(String nome) {
        String mensagem = "";
        int indice = getSetorByNome(nome);
        if (setores.size() > 0) {
            if (indice >= 0) {
                setores.remove(indice);
                mensagem = "Setor removido com sucesso";

            } else {
                mensagem = "Setor não encontrado";
            }
        } else {
            mensagem = "Sem setores cadastrados";
        }
        System.out.println(setores.toString());
        System.out.println(mensagem);
        return mensagem;
    }

    private String getSetor(String nome) {
        String mensagem = "";
        if (setores.size() > 0) {
            if (getSetorByNome(nome) >= 0) {
                Setor s1 = setores.get(getSetorByNome(nome));
                mensagem = "<" + s1.getNome() + ">"
                        + "\n" + printPessoasDoSetor(nome);
            } else {
                mensagem = "Setor não encontrado";
            }
        } else {
            mensagem = "Sem setores cadastradas";
        }
        return mensagem;
    }

    private String listSetor() {
        String retorno = "";
        if (setores.size() < 10) {
            retorno += "0" + setores.size();

        } else {
            retorno += setores.size();
        }
        for (Setor s : setores) {
            retorno += "\n" + s.getNome() + ";";
        }
        System.out.println(retorno);
        return retorno;
    }

    private int getSetorByNome(String nome) {
        int index = -1;
        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equals(nome)) {
                index = i;
            }
        }
        return index;
    }

    private List getPessoasDoSetor(String nome) {
        List<Integer> listaPessoas = new VirtualFlow.ArrayLinkedList<>();
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getSetor().getNome().equals(nome)) {
                listaPessoas.add(i);
            }
        }
        return listaPessoas;
    }

    private String printPessoasDoSetor(String nome) {
        List<Integer> listaPessoas = getPessoasDoSetor(nome);
        String retorno = "";
        for (int i = 0; i < listaPessoas.size(); i++) {
            for (int j = 0; j < pessoas.size(); j++) {
                if (pessoas.get(i).getSetor().getNome().equals(nome)) {
                    retorno += "<" + pessoas.get(i).getNome() + ">";
                }
            }
        }
        return retorno;
    }
//
//    private int getByCpf(String cpf) {
//        int index = -1;
//        for (int i = 0; i < pessoas.size(); i++) {
//            if (pessoas.get(i).getCpf().equals(cpf)) {
//                index = i;
//            }
//        }
//        return index;
//    }
//

}
