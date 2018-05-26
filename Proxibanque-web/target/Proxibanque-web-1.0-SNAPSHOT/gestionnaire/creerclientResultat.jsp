ele<%-- 
    Document   : creerclient
    Created on : 29 juin 2016, 01:07:49
    Author     : Achi Blay Kevin C. <Achi Blay Kevin C. at blay12cedric@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale = 1"/>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
        <!-- Fichier CSS de Bootstrap -->
        <link href="css/creerclient.css" rel="stylesheet"/>
        <title> Creer un client</title>
    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="gestionnaire/acceuil.jsp"><img src="../img/ele.png" alt=""/></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <!--<a href="controleur?action=afficher&ref=${e.code}"> Afficher <a/>-->
                            <!--<a href="../controle?action=acceuil">--> 
                            <a href="gestionnaire/acceuil.jsp">
                                <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Acceuil
                            </a>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" role="button" data-toggle="dropdown" 
                               href="#" aria-expanded="false" aria-haspopup="true">
                                Client <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="gestionnaire/acceuil.jsp">Liste les Comptes d'un Client</a></li>
                                <li class="divider"></li>
                                <li class="active"><a href="gestionnaire/acceuil.jsp">Créer un Client</a></li>
                                <li><a href="gestionnaire/acceuil.jsp">Editer un Client</a></li>
                            </ul>
                        </li>
                        <li><a href="gestionnaire/acceuil.jsp?action=virement">Virement</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" role="button" data-toggle="dropdown" 
                               href="#" aria-expanded="false" aria-haspopup="true">
                                <span class="glyphicon glyphicon-user"></span> ${gestionnaire.nom} ${gestionnaire.prenoms}
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Modifier mon Profil</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Se Déconnecter</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="panel panel-primary mypanel">
                <div class="panel-heading">
                    REFERENCE NOUVEAU CLIENT
                </div>

                <div class="panel-body">
                    <form class="row myrow" action="../creerclient" method="post">
                        <div class="alert alert-info myalert" role="alert">
                            <span href="#" class="alert-link">Pour enregistrer un nouveau Client, vous devez remplir les champs suivants.<br/></span>
                            <input type="hidden" class="form-control" name="codeGest" value="${codeGest}"/> <!--juste pour recuperer le code du gestionnaire dans la SERVLET -->
                        </div>
                        <section class="row">
                            <div class="col-md-1"> </div>   
                            <div class="col-md-4">    
                                <div class="label-input">
                                    <label for="nom">Nom</label>
                                    <input type="text" class="form-control" name="nom" required/>
                                </div>
                                <div class="label-input">
                                    <label for="prenom">Prénoms</label>
                                    <input type="text" class="form-control" name="prenoms" required/>
                                </div>
                                <div class="label-input">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" required/>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="label-input">
                                    <label for="adresse">Adresse</label>
                                    <input type="text" class="form-control" name="adresse" required/>                                    
                                </div>
                                <aside class="row">
                                    <div class="col-sm-7">                                        

                                        <div class="input-group" style=" margin-left: 10px; margin-top: 25px">
                                            <span class="input-group-addon">
                                                <input  name="creerCC" type="checkbox" value="creerCC"  aria-label="...">
                                            </span>
                                            <input disabled="true" type="text" style="text-align: center" value="Creer un compte courant" class="form-control alert-danger">
                                        </div><!-- /input-group -->

                                        <div class="input-group" style="margin-left: 10px; margin-top: 35px">
                                            <span class="input-group-addon">
                                                <input name="creerCE" type="checkbox" value="creerCE" aria-label="...">
                                            </span>
                                            <input disabled="true" type="text" style="text-align: center" value="Creer un compte epargne" class="form-control alert-danger">
                                        </div><!-- /input-group -->
                                    </div>
                                    <div class="col-sm-5">                                        

                                        <div class="label-input">
                                            <label for="depotCC">Faire un dépot (F CFA)</label>
                                            <input type="text" name="depotCC"class="form-control"  />                                    
                                        </div>
                                        <div class="label-input">
                                            <label for="depotCE">Faire un dépot (F CFA)</label>
                                            <input type="text" name="depotCE" class="form-control"  />                                    
                                        </div>
                                    </div>
                                </aside>
                            </div>
                            <div class="col-md-1"> </div>  
                        </section>
                        <hr/>
                        <c:if test="${empty str}">
                            <div class="my-button col-sm-offset-9">
                                <button type="submit" name="Valider" value="valider" class="btn btn-primary btn-sm form-button" >Valider</button>
                                <button type="reset" class="btn btn-danger btn-sm form-button" name="Annuler">Annuler</button>                                   
                            </div>                                
                        </c:if>
                    </form>
                    <c:if test="${!empty nvoClient}">
                        <div class="panel panel-success my-info-panel">
                            <div class="panel-heading">
                                <b> <span class="glyphicon glyphicon-ok"> Votre requete a aboutie avec succes voici les informations s'y rapportant. </span> </b>
                            </div>                               
                            <div class="panel-body">
                                <section class="row" style="margin-top: 10px;">
                                    <div class="col-lg-12">
                                        <table class="table table-hover mytable">
                                            <thead>
                                                <tr>
                                                    <th>NOM & PRENOM</th>
                                                    <th>EMAIL</th>
                                                    <th>ADRESSE</th>
                                                    <th>N°DE COMPTE</th>
                                                    <th>SOLDE</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${!empty compteCourant}">
                                                    <tr>
                                                        <td>${nvoClient.nom} ${nvoClient.prenoms}</td>
                                                        <td>${nvoClient.email}</td>
                                                        <td>${nvoClient.adresse} </td>
                                                        <td>${compteCourant.numeroCompte} </td>
                                                        <td>${compteCourant.soldeCompte} </td>
                                                    </tr>
                                                </c:if>
                                                <c:if test="${!empty compteEpargne}">
                                                    <tr>
                                                        <td>${nvoClient.nom} ${nvoClient.prenoms}</td>
                                                        <td>${nvoClient.email}</td>
                                                        <td>${nvoClient.adresse} </td>
                                                        <td>${compteEpargne.numeroCompte} </td>
                                                        <td>${compteEpargne.soldeCompte} </td>
                                                    </tr>
                                                </c:if>

                                            </tbody>
                                        </table>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script src="../bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>