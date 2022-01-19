package ic.tcc00175.biblioteca.controller.patterns.command;

import ic.tcc00175.biblioteca.oldmodel.patterns.facade.Cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveEmprestimo extends ServletCommand {

    private Cadastro cadastro = null;

    /**
     *
     */
    public RemoveEmprestimo() {
        super();
        cadastro = new Cadastro();
    }

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cadastro.removeEmprestimo(request);
        request.getRequestDispatcher(request.getParameter("page")).forward(
                request, response);
    }

    public void execute() {
        // TODO Auto-generated method stub
    }
}