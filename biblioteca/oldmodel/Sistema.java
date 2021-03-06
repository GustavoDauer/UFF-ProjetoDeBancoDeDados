/* Generated by Together */
package ic.tcc00175.biblioteca.oldmodel;

import ic.tcc00175.biblioteca.Load;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.UsuarioColecao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Sistema extends ic.tcc00175.biblioteca.oldmodel.BusinessObject {

    private static final long serialVersionUID = 2108824647411223359L;

    private Sistema() {
        // Comparator comparator = null;
        // comparator = new Comparator() {
        // public int compare(Object o1, Object o2) {
        // Long num1 = null;
        // num1 = new Long(((Usuario) o1).getId());
        // Long num2 = null;
        // num2 = new Long(((Usuario) o2).getId());
        // return num1.compareTo(num2);
        // }
        // };
        lnkUsuario = new UsuarioColecao();
        lnkBiblioteca = new HashMap();
        lnkLogin = new HashMap();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Sistema getInstance() {
        if (instance == null) {
            try {
                FileInputStream in;
                in = new FileInputStream(Sistema.arq);
                ObjectInputStream s = new ObjectInputStream(in);
                instance = (Sistema) s.readObject();
            } catch (FileNotFoundException e) {
                instance = new ic.tcc00175.biblioteca.oldmodel.Sistema();
                new Load(instance);
                instance.save();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Professor.qtdEmprestimo = 5;
        Professor.tempoEmprestimo = 3;
        AlunoPosGraduacao.qtdEmprestimo = 4;
        AlunoPosGraduacao.tempoEmprestimo = 2;
        AlunoGraduacao.qtdEmprestimo = 3;
        AlunoGraduacao.tempoEmprestimo = 1;
        Reserva.limite = 3;
        return instance;
    }

    public HashMap getLnkBiblioteca() {
        return lnkBiblioteca;
    }

    public void setLnkBiblioteca(HashMap lnkBiblioteca) {
        this.lnkBiblioteca = lnkBiblioteca;
    }

    public UsuarioColecao getLnkUsuario() {
        return lnkUsuario;
    }

    public void setLnkUsuario(UsuarioColecao lnkUsuario) {
        this.lnkUsuario = lnkUsuario;
    }

    public HashMap getLnkLogin() {
        return lnkLogin;
    }

    public void setLnkLogin(HashMap lnkLogin) {
        this.lnkLogin = lnkLogin;
    }
    private String nome = null;
    private UsuarioColecao lnkUsuario = null;
    private HashMap lnkBiblioteca = null;
    private static Sistema instance = null;
    private HashMap lnkLogin = null;
    private static final String arq = "Sistema.dat";

    public void finalize() throws Throwable {
        save();
        super.finalize();
    }

    public void save() {
        try {
            FileOutputStream out;
            out = new FileOutputStream(Sistema.arq, false);
            ObjectOutputStream s = new ObjectOutputStream(out);
            s.writeObject(Sistema.getInstance());
            s.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
