<%-- 
    Document   : novo
    Created on : Sep 17, 2023, 7:56:47 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo DVD</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body class="container">
        <h2>Novo DVD </h2>
        <br>
        <form method="POST" action="/LocacaoDVDs/processaDVDs">
            <input name="acao" type="hidden" value="inserir"/>

            <div class="mb-3">
                <label for="titulo" class="form-label">Título </label>
                <input required name="titulo" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="ano_lancamento" class="form-label">Ano de lançamento </label>
                <input required name="ano_lancamento" type="number" class="form-control">
            </div>
            <div class="mb-3">
                <label for="ator_principal_id" class="form-label">Ator principal: </label>

                <jsp:useBean
                    id="servicos"
                    scope="page"
                    class="locacaodvds.servicos.AtorServices"/>

                <select name="ator_principal_id" required>
                    <c:forEach items="${servicos.todos}" var="ator">
                        <option value="${ator.id}">
                            ${ator.nome}
                        </option>
                    </c:forEach>
                </select>

            </div>
            <div class="mb-3">
                <label for="ator_coadjuvante_id" class="form-label">Ator coadjuvante: </label>
                <select name="ator_coadjuvante_id" required>
                    <c:forEach items="${servicos.todos}" var="ator">
                        <option value="${ator.id}">
                            ${ator.nome}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="data_lancamento" class="form-label">Data de lançamento:  </label>
                <input required name="data_lancamento" type="date" class="form-control">
            </div>

            <div class="mb-3">
                <label for="duracao_minutos" class="form-label">Duração em minutos:  </label>
                <input required name="duracao_minutos" type="number" class="form-control">
            </div>

            <div class="mb-3">
                <label for="classificacao_etaria_id" class="form-label">Classificação etária:  </label>
                <jsp:useBean
                    id="servicos_ce"
                    scope="page"
                    class="locacaodvds.servicos.ClassificacaoEtariaServices"/>

                <select name="classificacao_etaria_id" required>
                    <c:forEach items="${servicos_ce.todos}" var="ce">
                        <option value="${ce.id}">
                            ${ce.descricao}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="genero_id" class="form-label">Gênero:  </label>
                <jsp:useBean
                    id="servicos_ge"
                    scope="page"
                    class="locacaodvds.servicos.GeneroServices"/>

                <select name="genero_id" required>
                    <c:forEach items="${servicos_ge.todos}" var="genero">
                        <option value="${genero.id}">
                            ${genero.descricao}
                        </option>
                    </c:forEach>
                </select>
            </div>


            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
        <br>

        <a class="btn btn-secondary" href="/LocacaoDVDs/formularios/dvd/listagem.jsp" >Voltar</a>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>
