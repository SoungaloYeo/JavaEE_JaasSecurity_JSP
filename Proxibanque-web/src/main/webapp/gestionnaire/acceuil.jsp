<%-- 
    Document   : acceuil
    Created on : 29 juin 2016, 01:07:49
    Author     : Achi Blay Kevin C. <Achi Blay Kevin C. at blay12cedric@gmail.com>
--%>

<%@page import="org.apache.logging.log4j.Logger"%>
<%@page import="org.apache.logging.log4j.LogManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale = 1"/>

        <!--        <style>
                    body{
                        background: #a27500;
                    }
        
                    .jumbotron {
                        padding:10px 30px 10px 30px;
                        margin-top: 100px;
                        margin-bottom: 40px;
                        background: #1A237E;
                        color:floralwhite;
                    }
        
                    .navbar-inverse {
                        background: #121D30;
                    }
        
                    .navbar-inverse .navbar-nav > .active > a,
                    .navbar-inverse .navbar-nav > .active > a:hover,
                    .navbar-inverse .navbar-nav > .active > a:focus {
                        color: #fff;
                        background: #1A237E;
                    }
        
                    .navbar-inverse .navbar-nav > .open > a,
                    .navbar-inverse .navbar-nav > .open > a:hover,
                    .navbar-inverse .navbar-nav > .open > a:focus {
                        color: #fff;
                        background: #1A237E;
                    }
        
                    .navbar-inverse .navbar-nav .open .dropdown-menu> li> a,
                    .navbar-inverse .navbar-nav .open .dropdown-menu {
                        background-color: #303F9F;
                        color:#eeeeee;
                    }
        
                    .navbar-inverse .navbar-nav .open .dropdown-menu> li> a:hover {
                        color:#000000;
                    }
        
                    .table-data {
                        text-align: center;
                    }
                </style>-->

        <title>Proxibanque - Acceuil</title>
        <!-- Fichier CSS de Bootstrap -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>

        <!-- Chargement des Librairies jQuery, Bootstrap & Fichier CSS (Necessaire au bon fonctionnement de Bootstrap et dataTables) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
        <link href="../css/acceuil.css" rel="stylesheet"/>
        <script src="http://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>

    <body>
        <%
            Logger logger = LogManager.getLogger("**********page acceuil.jsp **********");
        %>
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
                    <a class="navbar-brand" href="acceuil.jsp"><img src="../img/ele.png" alt=""/></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="acceuil.jsp">
                                <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Acceuil
                            </a>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" role="button" data-toggle="dropdown" 
                               href="#" aria-expanded="false" aria-haspopup="true">
                                Client <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="acceuil.jsp?action=liste-cpte">Liste les Comptes d'un Client</a></li>
                                <li class="divider"></li>
                                <li><a href="creerclient.jsp">Créer un Client</a></li>
                                <li><a href="acceuil.jsp?action=editer">Editer un Client</a></li>
                            </ul>
                        </li>
                        <li><a href="acceuil.jsp?action=virement">Virement</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" role="button" data-toggle="dropdown" 
                               href="#" aria-expanded="false" aria-haspopup="true">
                                <span class="glyphicon glyphicon-user"></span> 
                                ${gestionnaire.nom}&nbsp; ${gestionnaire.prenoms}
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!--<li><a href="#">Modifier mon Profil</a></li>-->
                                <!--<li class="divider"></li>-->
                                <li><a href="../index.jsp">Se Déconnecter</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="row" style="margin-top: 100px">
                <div class="col-xs-12">
                    <c:if test="${empty choix}">
                        <%
                            logger.info("**********[NAVBAR: click sur Acceuil]**********");
                        %>
                        <div class="alert alert-danger alert-dismissable ">
                            <button type="button" class="close" data-dismiss="alert"><span class="glyphicon glyphicon-remove-circle"></span> </button>
                            <h3><b>Bienvenue !</b></h3>
                            <p> <h4><b>${gestionnaire.nom}&nbsp; ${gestionnaire.prenoms}</b>, vous trouverez ci-dessous la liste des Clients
                                dont vous êtes le gestionnaire. Merci ! <h4></p>
                                    </div>
                                </c:if>
                                </div>
                                </div>
                                <div class="panel panel-primary">
                                    <div class="panel-heading"> 
                                        Listes des Clients
                                    </div>
                                    <div class="panel-body">
                                        <div class="row-table">
                                            <table id="myTable" class="table table-striped" width="100%">
                                                <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th class="table-data">Nom</th>
                                                        <th class="table-data">Prénoms</th>
                                                        <th class="table-data">Email</th>
                                                        <th class="table-data">Adresse</th>
                                                            <c:if test="${!empty choix}">
                                                            <th class="table-data">Action</th>
                                                            </c:if>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="client" items="${clients}">
                                                        <tr>
                                                            <td>${client.id}</td>
                                                            <td>${client.nom}</td>
                                                            <td>${client.prenoms}</td>
                                                            <td>${client.email}</td>
                                                            <td>${client.adresse}</td>
                                                            <td class="table-data">
                                                                <c:choose>

                                                                    <c:when test="${choix eq 'editer'}">
                                                                        <%
                                                                            logger.info("**********[NAVBAR: click sur Editer un client]**********");
                                                                        %>
                                                                        <form class="col-md-4" action="../editerclient" method="post">
                                                                            <button type="submit" class="btn btn-primary" name="editer">Editer Client</button>
                                                                            <input type="hidden" value="${client.codeClient}" name="codeCli"/>
                                                                        </form>
                                                                    </c:when>

                                                                    <c:when test="${choix eq 'liste-cpte'}">
                                                                         <%
                                                                            logger.info("**********[NAVBAR: click sur lister les comptes un client]**********");
                                                                        %>
                                                                        <form class="col-md-4" action="../listerclients" method="post">
                                                                            <button type="submit" class="btn btn-success" name="lister">Lister Compte</button>
                                                                            <input type="hidden" value="${client.codeClient}" name="codeCli"/>
                                                                        </form>
                                                                    </c:when>

                                                                    <c:when test="${choix eq 'virement'}">
                                                                         <%
                                                                            logger.info("**********[NAVBAR: click sur Virement]**********");
                                                                        %>
                                                                        <form class="col-md-4" action="../virement" method="post">
                                                                            <button type="submit" class="btn btn-danger" name="virement">Virement</button>
                                                                            <input type="hidden" value="${client.codeClient}" name="codeCli"/>
                                                                        </form>
                                                                    </c:when>

                                                                </c:choose>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                </div>  
                                </body>

                                <!-- Mon Fichier JavaScript Perso -->
                                <script>
                                    $(document).ready(function () {
                                        $('#myTable').dataTable({
                                            "language": {
                                                "sProcessing": "Traitement en cours...",
                                                "sSearch": "Rechercher&nbsp;:",
                                                "sLengthMenu": "Afficher _MENU_ &eacute;l&eacute;ments",
                                                "sInfo": "Affichage de l'&eacute;l&eacute;ment _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
                                                "sInfoEmpty": "Affichage de l'&eacute;l&eacute;ment 0 &agrave; 0 sur 0 &eacute;l&eacute;ment",
                                                "sInfoFiltered": "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
                                                "sInfoPostFix": "",
                                                "sLoadingRecords": "Chargement en cours...",
                                                "sZeroRecords": "Aucun &eacute;l&eacute;ment &agrave; afficher",
                                                "sEmptyTable": "Aucune donn&eacute;e disponible dans le tableau",
                                                "oPaginate": {
                                                    "sFirst": "Premier",
                                                    "sPrevious": "Pr&eacute;c&eacute;dent",
                                                    "sNext": "Suivant",
                                                    "sLast": "Dernier"
                                                },
                                                "oAria": {
                                                    "sSortAscending": ": activer pour trier la colonne par ordre croissant",
                                                    "sSortDescending": ": activer pour trier la colonne par ordre d&eacute;croissant"
                                                }
                                            }
                                        });
                                    });
                                </script>
                                </html>