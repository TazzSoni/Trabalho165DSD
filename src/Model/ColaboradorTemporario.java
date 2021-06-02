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
public class ColaboradorTemporario extends Pessoa {

    private String funcao;
    private String tempoDeContrato;
    private String tipo = "TEMPORÁRIO";

    public ColaboradorTemporario(String nome, String cpf, String endereco, String tempo, String funcao, String setorIndex) {
        super(nome, cpf, endereco, setorIndex);
        this.funcao = funcao;
        this.tempoDeContrato = tempo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTempoDeContrato() {
        return tempoDeContrato;
    }

    public void setTempoDeContrato(String tempoDeContrato) {
        this.tempoDeContrato = tempoDeContrato;
    }

    @Override
    public String toString() {
        return "ColaboradorTemporario{" + "nome=" + super.getNome() + ", cpf=" + super.getCpf() + ", endereco=" + super.getEndereco()
                + ", setor=" + super.getSetor() + "funcao=" + funcao + ", tempoDeContrato=" + tempoDeContrato + ", tipo=" + tipo + '}';
    }

}
