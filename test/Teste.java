
import Control.PersisteDados;

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
    
    
    
    public static void main(String[] args){
        PersisteDados per = new PersisteDados();
        per.criaPessoa("insert;00783962042;LacoSouzaTassoni;Rua arbt Wagner;clt;mecânica;123456;032021;mecânico");
        //String nome, String cpf, String endereco, String setor, String matricula, String tempo, String funcao
        per.criaPessoa("insert;00783962045;RodrigoSouzaTassoni;Rua Adolfo Wagner;temporario;mecânica;123456;03;mecânico");
        per.criaPessoa("update;00783962042;Alberto Roberto;Rua Amadeu Alves;temporario;elétrica;123456;06;eletricista");
        per.criaPessoa("list");
    }
    
}
