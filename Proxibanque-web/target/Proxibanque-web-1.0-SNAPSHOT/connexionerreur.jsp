<%-- 
Document   : virement
Created on : 23 juin 2016, 08:58:18
Author     : yeo sglo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">   
        <link href="css/connexion.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>connexion</title>
    </head>
    <body id="background">
        <div class="container">
            <section class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">  

                    <aside class="fontConx">
                        <legend> Authentification</legend>
                        <form role="form" action="j_security_check" method="post"> <!-- debut du formulaire-->
                            <div class="form-group">
                                <label for="nomUtil" class="libele">Nom d'utilisateur</label>
                                <input type="text" id="nomUtil" name="j_username" class="form-control contenu" required >
                            </div>
                            <div class="form-group">
                                <label for="pwd" class="libele">Mot de passe</label>
                                <input type="password" class="form-control contenu2" id="pwd" name="j_password" value=""  required>
                            </div>
                            <div class="alert alert-danger alert-dismissable ">
                                <button type="button" class="close" data-dismiss="alert"><span class="glyphicon glyphicon-remove-circle"></span> </button>
                                <strong>utilisateur / mot de passe incorrect</strong>
                            </div>
                            <input type="submit" class="btn btn-default" value="Valider"/>
                        </form><!-- f du formulaire-->
                    </aside>
                </div>
                <div class="col-md-4">  </div>

            </section>
            <!--     <section class="row">

</section> fin row -->

        </div><!--  fin container -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    </body>
</html>
