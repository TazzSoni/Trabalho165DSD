/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rodrigo
 */
public class Setor {
    
    String nome;
    String equipe;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String matricula) {
        this.equipe = matricula;
    }

    @Override
    public String toString() {
        return "Setor{" + "nome=" + nome + ", equipe=" + equipe + '}';
    }
    
}
