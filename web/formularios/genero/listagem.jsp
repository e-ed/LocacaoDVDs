<%-- 
    Document   : listagem
    Created on : Sep 17, 2023, 2:49:57 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generos</title>
    </head>
    <body>
        <table>
            <tr>
                <th>id</th>
                <th>Descrição</th>
            </tr>
            <jsp:useBean
                    id="servicos"
                    scope="page"
                    class="locacaodvds.servicos.GeneroServices"/>
            <c:forEach items="${servicos.todos}" var="genero">
                    <tr>
                        <td>${genero.id}</td>
                        <td>${genero.descricao}</td>
                        <td>
                            <a href="${cp}/${prefixo}Alteracao&id=${genero.id}">
                                Alterar
                            </a>
                        </td>
                        <td>
                            <a href="${cp}/${prefixo}Exclusao&id=${genero.id}">
                                Excluir
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            
        </table>
    </body>
</html>
