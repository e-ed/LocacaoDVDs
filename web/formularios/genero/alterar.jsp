<%-- 
    Document   : alterar.jsp
    Created on : Sep 17, 2023, 4:51:34 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>
        <%
        String id = request.getParameter("id");
        String descricao = request.getParameter("descricao");
        %>

        <form method="POST" action="/LocacaoDVDs/processaGeneros">
            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="<%= id %>"/>
            <h2>Alterar gênero: </h2>
            <table class="table">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Descrição</th>
                </tr>

                <tr>
                    <td scope="row"> <%= id %> </td>
                    <td>
                        <input name="descricao" type="text" value="<%= descricao %>"/>
                    </td>

                </tr>

            </table>
            <button type="submit" class="btn btn-primary">Alterar</button>

        </form>
        <br>
        <a class="btn btn-secondary" href="listagem.jsp">Voltar</a>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>
