/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.tipoProduto;

import br.com.curso.dao.GenericDAO;
import br.com.curso.dao.TipoProdutoDAO;
import br.com.curso.model.TipoProduto;
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
@WebServlet(name = "TipoProdutoCadastrar", urlPatterns = {"/TipoProdutoCadastrar"})
public class TipoProdutoCadastrar extends HttpServlet {

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
        int id_TipoProduto = Integer.parseInt(request.getParameter("id_TipoProduto"));
        String descricao = request.getParameter("descricao");
        String mensagem = null;
        
        try{
        TipoProduto oTipoProduto = new TipoProduto();
        
        oTipoProduto.setId_TipoProduto(id_TipoProduto);
        oTipoProduto.setDescricao(descricao);
        
            GenericDAO dao = new TipoProdutoDAO();
            if (dao.cadastrar(oTipoProduto)){
                mensagem = "Tipo de Produto Cadastrado com Sucesso!";
            }else {
                mensagem = "Problemas ao Cadastrar o Tipo de Produto. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("TipoProdutoListar");
        }catch (Exception ex){
            System.out.println("Problemas no Servlet ao cadastrar o Tipo de Produto! Erro: "+ex.getMessage());
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
