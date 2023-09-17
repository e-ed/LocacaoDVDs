<%-- 
    Document   : novo.jsp
    Created on : Sep 17, 2023, 3:43:19 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo genero</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>
        <h2>Novo genero </h2>
        <br>
        <form method="POST" action="/LocacaoDVDs/processaGeneros">
            <input name="acao" type="hidden" value="inserir"/>

            <div class="mb-3">
                <label for="descricao" class="form-label">Descrição: </label>
                <input name="descricao" type="text" class="form-control" aria-describedby="emailHelp">
            </div>


            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
        
        
        <a class="btn btn-secondary" href="/LocacaoDVDs/formularios/genero/listagem.jsp" >Voltar</a>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>
