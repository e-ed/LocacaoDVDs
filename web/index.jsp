<%-- 
    Document   : index.jsp
    Created on : Sep 16, 2023, 10:42:45 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Sistema para Cadastro de Clientes</title>
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

    </body>

</html>