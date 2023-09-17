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

    </head>

    <body>

        <div class="d-flex justify-content-center">
            <h1>Sistema para Cadastro de DVDs</h1>
        </div>
        <hr>
        <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
        

                    <p class="ms-5 me-3">
                        <a class="link-offset-2 link-underline link-underline-opacity-0" href="${cp}/formularios/ator/listagem.jsp">Atores</a>
                    </p>
      
                    <p class="ms-3 me-3">
                        <a class="link-offset-2 link-underline link-underline-opacity-0" href="${cp}/formularios/classificacao_etaria/listagem.jsp">Classificacões Etárias</a>
                    </p>


                    <p class="ms-3 me-3">
                        <a class="link-offset-2 link-underline link-underline-opacity-0" href="${cp}/formularios/genero/listagem.jsp">Gêneros</a>
                    </p>
        
                    <p class="ms-3 me-5">
                        <a class="link-offset-2 link-underline link-underline-opacity-0" href="${cp}/formularios/dvd/listagem.jsp">DVDs</a>
                    </p>
                
            </div>
        
    </nav>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>

</html>