<%-- 
    Document   : listagem
    Created on : Sep 17, 2023, 2:49:57 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
</head>
<body class="container">
    <h2>Gêneros</h2>
    <table class="table table-dark table-striped">
        <thead class="table-light">
            <th scope="col">id</th>
            <th scope="col">Descrição</th>
            <th scope="col">Alterar</th>
            <th scope="col">Excluir</th>
        </thead>
        <jsp:useBean
            id="servicos"
            scope="page"
            class="locacaodvds.servicos.GeneroServices"/>
        <c:forEach items="${servicos.todos}" var="genero">
            <tr>
                <td scope="row">${genero.id}</td>
                <td>${genero.descricao}</td>
                <td>
                    <a class="btn btn-outline-primary" href="${cp}/formularios/genero/alterar.jsp?id=${genero.id}&descricao=${genero.descricao}">
                        Alterar
                    </a>
                </td>
                <td>
                    <a class="btn btn-outline-danger" href="${cp}/formularios/genero/excluir.jsp?id=${genero.id}&descricao=${genero.descricao}">
                        Excluir
                    </a>
                </td>
            </tr>
        </c:forEach>

    </table>
   
        <a class="btn btn-primary" href="${cp}/formularios/genero/novo.jsp">Novo Genero</a>
    
        <br><br>
    <a class="btn btn-secondary" href="${cp}/index.jsp">Voltar</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
