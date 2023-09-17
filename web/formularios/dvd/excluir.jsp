<%-- 
    Document   : excluir
    Created on : Sep 17, 2023, 7:56:54 PM
    Author     : eduardo
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir DVD</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>

        <%
        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String ano_lancamento = request.getParameter("ano_lancamento");
        String ator_principal_id = request.getParameter("ator_principal_id");
        String ator_coadjuvante_id = request.getParameter("ator_coadjuvante_id");
        String data_lancamento = request.getParameter("data_lancamento");
        String duracao_minutos = request.getParameter("duracao_minutos");
        String classificacao_etaria_id = request.getParameter("classificacao_etaria_id");
        String genero_id = request.getParameter("genero_id");
        %>

        <form method="POST" action="/LocacaoDVDs/processaDVDs">
            <input name="acao" type="hidden" value="excluir"/>
            <input name="id" type="hidden" value="<%= id %>"/>
            <h2>Excluir DVD </h2>
            <table class="table">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Titulo</th>
                    <th scope="col">Ano de Lançamento</th>
                    <th scope="col">ID do ator principal</th>
                    <th scope="col">ID do ator coadjuvante</th>
                    <th scope="col">Data de Lançamento</th>
                    <th scope="col">Duração em minutos</th>
                    <th scope="col">ID da classificação etária</th>
                    <th scope="col">ID do gênero</th>
                </tr>

                <tr>
                    <td scope="row"> <%= id %> </td>
                    <td> <%= titulo %></td>
                    <td> <%= ano_lancamento %></td>
                    <td> <%= ator_principal_id %></td>
                    <td> <%= ator_coadjuvante_id %></td>
                    <td> <%= data_lancamento %></td>
                    <td> <%= duracao_minutos %></td>
                    <td> <%= classificacao_etaria_id %></td>
                    <td> <%= genero_id %></td>

                </tr>

            </table>
            <button type="submit" class="btn btn-primary">Excluir</button>

        </form>
        <br>
        <a class="btn btn-secondary" href="listagem.jsp">Voltar</a>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>


