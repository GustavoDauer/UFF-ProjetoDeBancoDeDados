package ic.tcc00175.biblioteca.model;
// Generated Oct 3, 2013 6:26:57 PM by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Emprestimo generated by hbm2java
 */
public class Emprestimo implements java.io.Serializable {

    private long operacaoNumero;
    private Operacao operacao;
    private Exemplar exemplar;
    private String obs;
    private Set devolucaos = new HashSet(0);

    public Emprestimo() {
    }

    public Emprestimo(long operacaoNumero, Operacao operacao, Exemplar exemplar) {
        this.operacaoNumero = operacaoNumero;
        this.operacao = operacao;
        this.exemplar = exemplar;
    }

    public Emprestimo(long operacaoNumero, Operacao operacao, Exemplar exemplar, String obs, Set devolucaos) {
        this.operacaoNumero = operacaoNumero;
        this.operacao = operacao;
        this.exemplar = exemplar;
        this.obs = obs;
        this.devolucaos = devolucaos;
    }

    public long getOperacaoNumero() {
        return this.operacaoNumero;
    }

    public void setOperacaoNumero(long operacaoNumero) {
        this.operacaoNumero = operacaoNumero;
    }

    public Operacao getOperacao() {
        return this.operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Exemplar getExemplar() {
        return this.exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Set getDevolucaos() {
        return this.devolucaos;
    }

    public void setDevolucaos(Set devolucaos) {
        this.devolucaos = devolucaos;
    }
}
