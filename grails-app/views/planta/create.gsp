<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'planta.label', default: 'Planta')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-planta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-planta" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <%-- <g:hasErrors bean="${this.planta}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.planta}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors> --%>
            <g:form action="save">
                <fieldset class="form">
<!--                    <f:all bean="planta"/>-->
                    

                <!-- Text input-->
                <div class="container-fluid">
                    <div class="form-group">
                        <div class="">
                            <label class="" for="tb_nome">Nome</label>  
                            <div class="">
                            <input id="tb_nome"  name="tb_nome" type="text" placeholder="" class="" required="">

                            </div>
                </div><br/>
                  <label class="" for="tb_nomecientifico">Nome científico</label>  
                  <div class="">
                  <input id="tb_nomecientifico" name="tb_nomecientifico" type="text" placeholder="" class="">

                  </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                  <label class="" for="tb_custo">Custo da muda</label>  
                  <div class="">
                  <input id="tb_custo" name="tb_custo" type="number" placeholder="" class="">

                  </div>
                  <div>
                  <label class="" for="tb_dispersao_planta">Dispersão da Planta</label>  
                  <div class="">
                    <g:select name="selectDispersaoPlanta"
                        from="${listaDispersaoPlanta}"
                        noSelection="['':'Selecione']"
                        optionValue="descricao"
                        optionKey="id" />

                  </div>
                  </div>
                  <div>
                  <label class="" for="tb_sucessao_planta">Sucessão da Planta</label>  
                  <div class="">
                    <g:select name="selectSucessaoPlanta"
                        from="${listaSucessaoPlanta}"
                        noSelection="['':'Selecione']"
                        optionValue="descricao"
                        optionKey="id" />

                  </div>
                  </div>
                  
                  <div>
                    <label class="" for="cb_ameacadoExtincao">Ameaçado de extinção</label>
                    <!--<div > -->
                           <input type="checkbox" name="cb_ameacadoExtincao" id="cb_ameacadoExtincao" />
                    <!--</div>-->
                  </div>
                  
                </div>
                
                <div>
                    <label for="cb_nativoCerrado">Nativo do Cerrado</label>
                    <!--<div > -->
                           <input type="checkbox" name="cb_nativoCerrado" id="cb_nativoCerrado"/>
                    <!--</div > -->
                  </div>
                  
                </div>
                </div>
                
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
