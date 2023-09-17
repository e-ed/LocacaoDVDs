<%-- 
    Document   : index.jsp
    Created on : Sep 16, 2023, 10:42:45 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html data-bs-theme="dark">
    <head>
        <title>Sistema para Cadastro de Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="${cp}/css/styles.css"/>
    </head>

    <body>

        <h1>Sistema para Cadastro de DVDs</h1>


        <p>
            <a href="${cp}/formularios/ator/listagem.jsp">Atores</a>
        </p>
        <p>
            <a href="${cp}/formularios/classificacao_etaria/listagem.jsp">classificacao Etaria</a>
        </p>
        <p>
            <a href="${cp}/formularios/genero/listagem.jsp">Genero</a>
        </p>
        <p>
            <a href="${cp}/formularios/dvd/listagem.jsp">DVD</a>
        </p>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>

</html>