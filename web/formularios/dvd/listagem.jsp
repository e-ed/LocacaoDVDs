<%-- 
    Document   : listagem
    Created on : Sep 17, 2023, 7:56:44 PM
    Author     : eduardo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVDs </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
</head>
<body class="container">
    <h2>DVDs</h2>
    <table class="table table-dark table-striped">
        <thead class="table-light">
            <th scope="col">id</th>
            <th scope="col">Título</th>
            <th scope="col">Ano de lançamento</th>
            <th scope="col">ID do ator principal</th>
            <th scope="col">ID do ator coadjuvante</th>
            <th scope="col">Data de lançamento</th>
            <th scope="col">Duração em minutos</th>
            <th scope="col">ID da classificação etária</th>
            <th scope="col">ID do gênero</th>
            <th scope="col">Alterar</th>
            <th scope="col">Excluir</th>
        </thead>
        <jsp:useBean
            id="servicos"
            scope="page"
            class="locacaodvds.servicos.DVDServices"/>
        <c:forEach items="${servicos.todos}" var="dvd">
            <tr>
                <td scope="row">${dvd.id}</td>
                <td>${dvd.titulo}</td>
                <td>${dvd.ano_lancamento}</td>
                <td>${dvd.ator_principal_id}</td>
                <td>${dvd.ator_coadjuvante_id}</td>
                <td>${dvd.data_lancamento}</td>
                <td>${dvd.duracao_minutos}</td>
                <td>${dvd.classificacao_etaria_id}</td>
                <td>${dvd.genero_id}</td>
                <td>
                    <a href="${cp}/formularios/dvd/alterar.jsp?id=${dvd.id}&titulo=${dvd.titulo}&ano_lancamento=${dvd.ano_lancamento}&ator_principal_id=${dvd.ator_principal_id}&ator_coadjuvante_id=${dvd.ator_coadjuvante_id}&data_lancamento=${dvd.data_lancamento}&duracao_minutos=${dvd.duracao_minutos}&classificacao_etaria_id=${dvd.classificacao_etaria_id}&genero_id=${dvd.genero_id}">
                        Alterar
                    </a>
                </td>
                <td>
                    <a href="${cp}/formularios/dvd/excluir.jsp?id=${dvd.id}&titulo=${dvd.titulo}&ano_lancamento=${dvd.ano_lancamento}&ator_principal_id=${dvd.ator_principal_id}&ator_coadjuvante_id=${dvd.ator_coadjuvante_id}&data_lancamento=${dvd.data_lancamento}&duracao_minutos=${dvd.duracao_minutos}&classificacao_etaria_id=${dvd.classificacao_etaria_id}&genero_id=${dvd.genero_id}">
                        Excluir
                    </a>
                </td>
            </tr>
        </c:forEach>

    </table>
   
        <a class="btn btn-primary" href="${cp}/formularios/dvd/novo.jsp">Novo DVD</a>
    
        <br><br>
    <a class="btn btn-secondary" href="${cp}/index.jsp">Voltar</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
