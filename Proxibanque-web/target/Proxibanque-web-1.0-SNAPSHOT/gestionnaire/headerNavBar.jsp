<%-- 
    Document   : header
    Created on : 8 juil. 2016, 01:47:41
    Author     : yeo sglo
--%>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>

<!-- Chargement des Librairies jQuery, Bootstrap & Fichier CSS (Necessaire au bon fonctionnement de Bootstrap et dataTables) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
<link href="css/listerclient.css" rel="stylesheet">
<link href="css/virement.css" rel="stylesheet">
<link href="css/editerclient.css" rel="stylesheet"/>
<script src="http://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

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
            <a class="navbar-brand" href="gestionnaire/acceuil.jsp"><img src="img/ele.png" alt=""/></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active">
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
                        <!--<a href="controleur?action=afficher&ref=${e.code}"> Afficher <a/>-->
                        <li><a href="gestionnaire/acceuil.jsp?action=liste-cpte">Liste les Comptes d'un Client</a></li>
                        <li class="divider"></li>
                        <li><a href="gestionnaire/creerclient.jsp">Créer un Client</a></li>
                        <li><a href="gestionnaire/acceuil.jsp?action=editer">Editer un Client</a></li>
                    </ul>
                </li>
                <li><a href="gestionnaire/acceuil.jsp?action=virement">Virement</a></li>
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
                        <li><a href="#">Modifier mon Profil</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Se Déconnecter</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>