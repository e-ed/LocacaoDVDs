<%-- 
    Document   : novo
    Created on : Sep 17, 2023, 7:56:47 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo DVD</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>
        <h2>Novo DVD </h2>
        <br>
        <form method="POST" action="/LocacaoDVDs/processaDVDs">
            <input name="acao" type="hidden" value="inserir"/>

            <div class="mb-3">
                <label for="titulo" class="form-label">Título </label>
                <input name="titulo" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="ano_lancamento" class="form-label">Ano de lançamento </label>
                <input name="ano_lancamento" type="number" class="form-control">
            </div>
            <div class="mb-3">
                <label for="ator_principal_id" class="form-label">ID do ator principal: </label>
                <input name="ator_principal_id" type="number" class="form-control">
            </div>
            <div class="mb-3">
                <label for="ator_coadjuvante_id" class="form-label">ID do ator coadjuvante: </label>
                <input name="ator_coadjuvante_id" type="number" class="form-control">
            </div>
            
            <div class="mb-3">
                <label for="data_lancamento" class="form-label">Data de lançamento:  </label>
                <input name="data_lancamento" type="date" class="form-control">
            </div>
            
            <div class="mb-3">
                <label for="duracao_minutos" class="form-label">Duração em minutos:  </label>
                <input name="duracao_minutos" type="number" class="form-control">
            </div>
            
            <div class="mb-3">
                <label for="classificacao_etaria_id" class="form-label">ID da classificação etária:  </label>
                <input name="classificacao_etaria_id" type="number" class="form-control">
            </div>
            
            <div class="mb-3">
                <label for="genero_id" class="form-label">ID do gênero:  </label>
                <input name="genero_id" type="number" class="form-control">
            </div>


            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
        
        
        <a class="btn btn-secondary" href="/LocacaoDVDs/formularios/dvd/listagem.jsp" >Voltar</a>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>
