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
public class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;
    private Setor setor;

    public Pessoa(String nome, String cpf, String endereco, String setor, String equipe) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        
        setSetor(setor, equipe);
    }

    
    
    public Setor getSetor() {
        return setor;
    }

    public void setSetor(String nome, String equipe) {
        Setor s = new Setor();
        s.setEquipe(equipe);
        s.setNome(nome);
        this.setor = s;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", setor=" + setor + '}';
    }

    
    
    
}
