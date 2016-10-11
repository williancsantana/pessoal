<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main"> 
        <title>Sample title</title>
    </head>
    <body>
        <h1>Sample line</h1>
        
        <form class="form-horizontal">
            <fieldset>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="textinput">Login:</label>  
              <div class="col-md-4">
              <input id="textinput" name="textinput" type="text" placeholder="Digite seu login" class="form-control input-md">

              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="tb_senha">Senha:</label>
              <div class="col-md-4">
                <input id="tb_senha" name="tb_senha" type="password" placeholder="" class="form-control input-md">

              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="buttonAutenticar"></label>
              <div class="col-md-4">
                <button id="buttonAutenticar" name="buttonAutenticar" class="btn btn-success">Entrar</button>
              </div>
            </div>

            </fieldset>
        </form>

        
    </body>
</html>
