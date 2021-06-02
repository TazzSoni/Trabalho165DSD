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
    private String setorIndex;

    public Pessoa(String nome, String cpf, String endereco, String setorIndex) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.setorIndex = setorIndex;
    }

    public String getSetorIndex() {
        return setorIndex;
    }

    public void setSetorIndex(String setorIndex) {
        this.setorIndex = setorIndex;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
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
