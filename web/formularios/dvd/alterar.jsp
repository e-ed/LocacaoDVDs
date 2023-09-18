<%-- 
    Document   : alterar
    Created on : Sep 17, 2023, 7:56:50 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar</title>
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
        <c:set var="ator_principal_id" value="<%= ator_principal_id %>"/>
        <c:set var="ator_coadjuvante_id" value="<%= ator_coadjuvante_id %>"/>
        <c:set var="classificacao_etaria_id" value="<%= classificacao_etaria_id %>"/>
        <c:set var="genero_id" value="<%= genero_id %>"/>

        <form method="POST" action="/LocacaoDVDs/processaDVDs">
            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="<%= id %>"/>
            <h2>Alterar DVD: </h2>


            <table class="table">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Titulo</th>
                    <th scope="col">Ano de Lançamento</th>
                    <th scope="col">Ator principal</th>
                    <th scope="col">Ator coadjuvante</th>
                    <th scope="col">Data de Lançamento</th>
                    <th scope="col">Duração em minutos</th>
                    <th scope="col">Classificação etária</th>
                    <th scope="col">Gênero</th>
                </tr>

                <tr>
                    <td scope="row"> <%= id %> </td>
                    <td>
                        <input class="form-control input-sm" name="titulo" type="text" value="<%= titulo %>"/>
                    </td>
                    <td>
                        <input class="form-control input-sm" name="ano_lancamento" type="number" value="<%= ano_lancamento %>"/>
                    </td>
                    <td>
                        <jsp:useBean
                            id="servicos"
                            scope="application"
                            class="locacaodvds.servicos.AtorServices"/>


                        <select name="ator_principal_id" required>
                            <c:forEach items="${servicos.todos}" var="ator">
                                <c:choose>
                                    <c:when test="${ator_principal_id eq ator.id}">
                                        <option value="${ator.id}" selected>
                                            ${ator.nome}
                                        </option>
                                    </c:when>
                                    <c:otherwise> 
                                        <option value="${ator.id}">
                                            ${ator.nome}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                    </td>
                    <td>

                        <select name="ator_coadjuvante_id" required>
                            <c:forEach items="${servicos.todos}" var="ator">
                                <c:choose>
                                    <c:when test="${ator_coadjuvante_id eq ator.id}">
                                        <option value="${ator.id}" selected>
                                            ${ator.nome}
                                        </option>
                                    </c:when>
                                    <c:otherwise> 
                                        <option value="${ator.id}">
                                            ${ator.nome}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input class="form-control input-sm" name="data_lancamento" type="date" value="<%= data_lancamento %>"/>
                    </td>
                    <td>
                        <input class="form-control input-sm" name="duracao_minutos" type="number" value="<%= duracao_minutos %>"/>
                    </td>
                    <td>
                        <jsp:useBean
                            id="ce_servicos"
                            scope="application"
                            class="locacaodvds.servicos.ClassificacaoEtariaServices"/>


                        <select name="classificacao_etaria_id" required>
                            <c:forEach items="${ce_servicos.todos}" var="ce">
                                <c:choose>
                                    <c:when test="${classificacao_etaria_id eq ce.id}">
                                        <option value="${ce.id}" selected>
                                            ${ce.descricao}
                                        </option>
                                    </c:when>
                                    <c:otherwise> 
                                        <option value="${ce.id}">
                                            ${ce.descricao}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <jsp:useBean
                            id="genero_servicos"
                            scope="application"
                            class="locacaodvds.servicos.GeneroServices"/>


                        <select name="genero_id" required>
                            <c:forEach items="${genero_servicos.todos}" var="genero">
                                <c:choose>
                                    <c:when test="${genero_id eq genero.id}">
                                        <option value="${genero.id}" selected>
                                            ${genero.descricao}
                                        </option>
                                    </c:when>
                                    <c:otherwise> 
                                        <option value="${genero.id}">
                                            ${genero.descricao}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
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
