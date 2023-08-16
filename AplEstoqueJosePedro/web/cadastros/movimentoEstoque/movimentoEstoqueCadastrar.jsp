<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarMovimentoEstoque" action="MovimentoEstoqueCadastrar" 
      method="POST">
    
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Movimento Estoque
                </th>
            </tr>
            <tr>
                <th colspan="2" align="center">
                    ${mensagem}
                </th>
            </tr>
        </thead> 
        <tbody>
            <tr><td>ID: </td>
            <td><input type="text" name="idmovimento" id="idmovimento" value="${movimentoEstoque.idMovimento}" readonly="readonly"/></td></tr>
            <tr><td>Entrada e Saida: </td>
            <td><input type="text" name="entradasaida" id="entradasaida" value="${movimentoEstoque.entradaSaida}" size="50"
                           maxlength="50" /></td></tr>
            <tr><td>Documento: </td>
            <td><input type="text" name="documento" id="documento" value="${movimentoEstoque.documento}" size="50"
                           maxlength="50"/></td></tr>
            <tr><td>Data: </td>
            <td><input type="text" name="data" id="data" value="${movimentoEstoque.data}" size="50"
                           maxlength="50"/></td></tr>
            <tr><td>Quantidade: </td>
            <td><input type="text" name="quantidade" id="quantidade" value="${movimentoEstoque.quantidade}" size="50"
                           maxlength="50"/></td></tr>
            <tr><td>Valor Movimento: </td>
            <td><input type="text" name="valormovimento" id="valormovimento" value="${movimentoEstoque.valorMovimento}" size="50"
                           maxlength="50"/></td></tr>
            <tr><td>Id do Produto: </td>
            <td><input type="text" name="id_produto" id="id_produto" value="${movimentoEstoque.id_Produto}" size="50"
                           maxlength="50"/></td></tr>
            <tr><td>Id do Tipo de Movimento: </td>
            <td><input type="text" name="idtipomovimento" id="idtipomovimento" value="${movimentoEstoque.idTipoMovimento}" size="50"
                           maxlength="50"/></td></tr>
            <tr><td>Id do Funcionario: </td>
            <td><input type="text" name="idfuncionario" id="idfuncionario" value="${movimentoEstoque.idFuncionario}" size="50"
                           maxlength="50"/></td></tr>
                <tr><td colspan="2" align="center">
                        <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar"/>
                        <input type="reset" name="limpar" id="limpar" value="Limpar"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><h5><a href="index.jsp">Voltar a Página Inicial</a></h5></td>
                </tr>
        </tbody>
    </table>
</form>
<%@include file="/footer.jsp" %>