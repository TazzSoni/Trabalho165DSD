
import Control.PersisteDadosPessoa;
import Model.ColaboradorClt;
import Model.Pessoa;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Teste {
    
    public static void main(String[] args) {
        PersisteDadosPessoa per = new PersisteDadosPessoa();
//        per.criaPessoa("insert;00783962042;LacoSouzaTassoni;Rua arbt Wagner;clt;mecânica;123456;032021;mecânico");
//        //String nome, String cpf, String endereco, String setor, String matricula, String tempo, String funcao
//        per.criaPessoa("insert;00783962045;RodrigoSouzaTassoni;Rua Adolfo Wagner;temporario;mecânica;123456;03;mecânico");
//        per.criaPessoa("update;00783962042;Alberto Roberto;Rua Amadeu Alves;temporario;elétrica;123456;06;eletricista");
//        per.criaPessoa("list");

//        per.criaSetor("insertSetor;Mecânica;1");
//        per.criaSetor("insertSetor;asas;2");
//        per.criaSetor("updatesetor;Mecânica;Ele;2");
//        per.criaSetor("deletesetor;asas");

//Pessoa pe = new ColaboradorClt("nome", "cpf", "end", "mesAnoContratado", "funcao", "0");
//        System.out.println(pe.toString());
  List<Integer> listaPessoas = new ArrayList<>();
  listaPessoas.add(1);
    }
    
}
