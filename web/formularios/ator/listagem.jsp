<%-- 
    Document   : listagem.jsp
    Created on : Sep 17, 2023, 6:43:06 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
</head>
<body class="container">
    <h2>Atores</h2>
    <br>
    <table class="table table-dark table-striped">
        <thead class="table-light">
        <th scope="col">id</th>
        <th scope="col">Nome</th>
        <th scope="col">Sobrenome</th>
        <th scope="col">Data de Estréia</th>
        <th scope="col">Alterar</th>
        <th scope="col">Excluir</th>
    </thead>
    <jsp:useBean
        id="servicos"
        scope="page"
        class="locacaodvds.servicos.AtorServices"/>
    <c:forEach items="${servicos.todos}" var="ator">
        <tr>
            <td scope="row">${ator.id}</td>
            <td>${ator.nome}</td>
            <td>${ator.sobrenome}</td>
            <td><fmt:formatDate value="${ator.data_estreia}" pattern="dd-MM-yyyy" /></td>
    <td>
        <a class="btn btn-outline-primary" href="${cp}/formularios/ator/alterar.jsp?id=${ator.id}&nome=${ator.nome}&sobrenome=${ator.sobrenome}&data_estreia=${ator.data_estreia}">
            Alterar
        </a>
    </td>
    <td>
        <a class="btn btn-outline-danger" href="${cp}/formularios/ator/excluir.jsp?id=${ator.id}&nome=${ator.nome}&sobrenome=${ator.sobrenome}&data_estreia=${ator.data_estreia}">
            Excluir
        </a>
    </td>
</tr>
</c:forEach>

</table>

<a class="btn btn-primary" href="${cp}/formularios/ator/novo.jsp">Novo Ator</a>

<br><br>
<a class="btn btn-secondary" href="${cp}/index.jsp">Voltar</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
