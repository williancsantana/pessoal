<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'planta.label', default: 'Planta')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-planta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-planta" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
<!--            <f:table collection="${plantaList}" />-->
            <table class="table">
            <tr>
                <g:sortableColumn property="ameacadoExtincao" title="Ameaçado"/>
                <g:sortableColumn property="nome" title="Nome"/>
                <g:sortableColumn property="nomeCientifico" title="Nome Científico"/>
                <g:sortableColumn property="custoMuda" title="Custo Muda"/>
                <g:sortableColumn property="dispersaoPlanta" title="Dispersão da Planta"/>
                <g:sortableColumn property="plantaSucessao" title="Sucessão da Planta"/>
                <g:sortableColumn property="nativoCerrado" title="Nativo do Cerrado"/>
            </tr>
            <g:each in="${plantaList}" status="i" var="planta">
                <tr >
                    <td>${planta.ameacadoExtincao ? "Sim": "Não"}</td>
                    
                    <td> <a href="${createLink(action: 'show', id: planta.id)}">${planta.nome}</a> </td>
                    
                    <td> ${planta.nomeCientifico} </td>
                    
                    <td> R$ ${planta.custoMuda} </td>
                    
                    <td> ${planta.dispersaoPlanta.descricao} </td>
                    
                    <td> ${planta.plantaSucessao.descricao}  </td>
                    
                    <td> ${planta.nativoCerrado ? "Sim" : "Não"} </td>
                </tr>
            </g:each>
            </table>
            <div class="pagination">
                <g:paginate total="${plantaCount ?: 0}" />
            </div>
        </div>
    </body>
</html>