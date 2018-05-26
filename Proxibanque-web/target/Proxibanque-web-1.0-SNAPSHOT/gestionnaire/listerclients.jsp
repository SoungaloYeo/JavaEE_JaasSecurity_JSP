<%-- 
Document   : creer-client
Created on : 26 juin 2016, 17:52:37
Author     : yeo sglo
--%> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
        <!--<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">-->  
        <link href="css/listerclient.css" rel="stylesheet">
        <!--<link href="../css/listerclient.css" rel="stylesheet">-->
        <link href="css/mystyle.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <title>lister compte client</title>
    </head>
    <body>    
        <%@include file="headerNavBar.jsp" %>
        <div class="container">
            <div class="row">
                <!--<section class="col-sm-1"></section>-->
                <section class="col-sm-12 my-panel-listing">
                    <section class="row">

                        <div class="panel panel-primary my-panel-perso">
                            <div class="panel-heading">
                                <h3 class="panel-title"><b>ESPACE LISTING COMPTE CLIENT<b/></h3>
                            </div>
                            </br>
                            <form  method="post" action="../lister-client" >
                                <div class="panel-body">
                                    <section class="col-sm-12 ">

                                        <fieldset>
                                            <legend> Références client </legend>
                                            <aside class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="nom">Nom </label>
                                                    <input type="text"   value="${client.nom}"        name="nomCli"       class="form-control disabled" id="nom" style="background-color: #eeeeee" disabled required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="prenom">Prenom </label>
                                                    <input type="text"   value="${client.prenoms}"     name="prenomCli"   class="form-control" id="prenom" style="background-color: #eeeeee" disabled required>
                                                </div>
                                            </aside>
                                            <aside class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="email">Email</label>
                                                    <input type="text"   value="${client.email}"       name="emailCli"    class="form-control" id="email" style="background-color: #eeeeee" disabled required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="adresse">Adresse</label>
                                                    <input type="text"   value="${client.adresse}"     name="adresseCli"  class="form-control" id="solde" style="background-color: #eeeeee" disabled required>
                                                </div>
                                            </aside>
                                        </fieldset>
                                    </section> 
                                </div>
                                <hr/>
                                <!--                              
                                                            </form>
                                <!-- ====================================================tableau et pagination==================== -->                             

                                <c:if test="${!empty comptes}">
                                    <section class="row">
                                        <div class="col-lg-1"></div>
                                        <div class="col-lg-10">
                                            <div class="panel panel-success ">
                                                <div class="panel-heading">
                                                    <b> <span class="glyphicon glyphicon-ok"> Votre requete a aboutie avec succes voici les informations s'y rapportant. </span> </b>
                                                </div>                               
                                                <div class="panel-body text-uppercase">

                                                    <table class="table table-hover mytable">
                                                        <thead>
                                                            <tr>
                                                                <th>N°DE COMPTE</th>
                                                                <th>TYPE DE COMPTE</th>
                                                                <th>SOLDE A CE JOUR</th>
                                                            </tr>
                                                        </thead>

                                                        <tbody>
                                                            <c:forEach var="cc" items="${comptes}" varStatus="cptr" >
                                                                <tr>
                                                                    <td>${cc.numeroCompte}</td>
                                                                    <td>${typeCompte[cptr.count-1]}</td>
                                                                    <td>${cc.soldeCompte} </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>

                                                </div>
                                            </div> 
                                        </div>
                                        <div class="col-lg-1"></div>
                                    </section>
                                </c:if>
                                <!-- fin  tableau ======= -->
                                <%--</c:if>--%>
                        </div>
                    </section>
            </div>
            <!--</section>-->
            <!--<section class="col-sm-1"></section>-->
        </div>
    </div>
    <script src="../bootstrap/js/jquery-1.12.0.min.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
