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
public class ColaboradorClt extends Pessoa{
    private String funcao;
    private String mesAnoContratado;
    private String tipo = "CLT";

    public ColaboradorClt(String nome, String cpf, String endereco, String setor, String equipe, String mesAnoContratado, String funcao) {
        super(nome, cpf, endereco, setor, equipe);
        this.funcao = funcao;
        this.mesAnoContratado = mesAnoContratado;
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
    
    public String getMesAnoContratado() {
        return mesAnoContratado;
    }

    public void setMesAnoContratado(String mesAnoContratado) {
        this.mesAnoContratado = mesAnoContratado;
    }

    @Override
    public String toString() {
        return "ColaboradorClt{" + "nome="+super.getNome()+ ", cpf=" + super.getCpf() + ", endereco=" + super.getEndereco() + 
                ", setor=" + super.getSetor()+ "funcao=" + funcao + ", mesAnoContratado=" + mesAnoContratado + ", tipo=" + tipo + '}';
    }

    
}
