<%-- 
    Document   : excluir
    Created on : Sep 17, 2023, 6:42:37 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Genero</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>

        <%
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String data_estreia = request.getParameter("data_estreia");
        %>

        <form method="POST" action="/LocacaoDVDs/processaAtores">
            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="<%= id %>"/>
            <h2>Excluir ator </h2>
            <table class="table">
                <tr>
                     <th scope="col">id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Sobrenome</th>
                    <th scope="col">Data de estréia</th>
                </tr>

                <tr>
                    <td scope="row"> <%= id %> </td>
                    <td> <%= nome %></td>
                    <td> <%= sobrenome %></td>
                    <td> <%= data_estreia %></td>

                </tr>

            </table>
            <button type="submit" class="btn btn-primary">Excluir</button>

        </form>
        <br>
        <a class="btn btn-secondary" href="listagem.jsp">Voltar</a>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>
