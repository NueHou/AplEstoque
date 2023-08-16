/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.produto;

import br.com.curso.dao.GenericDAO;
import br.com.curso.dao.ProdutoDAO;
import br.com.curso.model.Produto;
import br.com.curso.model.TipoProduto;
import br.com.curso.model.UnidadeMedida;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 55179
 */
@WebServlet(name = "ProdutoCadastrar", urlPatterns = {"/ProdutoCadastrar"})
public class ProdutoCadastrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id_Produto = Integer.parseInt(request.getParameter("id_Produto"));
        String nome_Produto = request.getParameter("nome_Produto");
        int ultimoPrecoPago = Integer.parseInt(request.getParameter("ultimoPrecoPago"));
        int saldoAtual = Integer.parseInt(request.getParameter("saldoAtual"));
        int id_TipoProduto = Integer.parseInt(request.getParameter("id_TipoProduto"));
        int id_unidadeMedida = Integer.parseInt(request.getParameter("id_unidadeMedida"));
        String mensagem = null;
        
        try{
        Produto oProduto = new Produto();
        
        oProduto.setId_Produto(id_Produto);
        oProduto.setNome_Produto(nome_Produto);
        oProduto.setUltimoPrecoPago(ultimoPrecoPago);
        oProduto.setSaldoAtual(saldoAtual);
        
        TipoProduto oTipoProduto = new TipoProduto();
        oTipoProduto.setId_TipoProduto(id_TipoProduto);
        //oProduto.setId_TipoProduto(new TipoProduto(id_TipoProduto, "", ""));
        UnidadeMedida oUnidadeMedida = new UnidadeMedida();
        oUnidadeMedida.setId_unidadeMedida(id_unidadeMedida);
        //oProduto.setId_unidadeMedida(new UnidadeMedida(id_unidadeMedida, "", ""));
            GenericDAO dao = new ProdutoDAO();
            if (dao.cadastrar(oProduto)){
                mensagem = "Movimento de Estoque Cadastrado com Sucesso!";
            }else {
                mensagem = "Problemas ao Cadastrar Movimento de Estoque. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("ProdutoListar");
        }catch (Exception ex){
            System.out.println("Problemas no Servlet ao cadastrar Produto! Erro: "+ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
