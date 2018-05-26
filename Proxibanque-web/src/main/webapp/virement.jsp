<%-- 
Document   : virement
Created on : 23 juin 2016, 08:58:18
Author     : yeo sglo
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">        
        <link href="css/virement.css" rel="stylesheet">
        <link href="css/recherche.css" rel="stylesheet">
        <link href="css/mystyle.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>virements</title>
    </head>
    <body> 
        <%@include file="headerNavBar.jsp" %>                                
        <div class="container">                   <!-- debut de notre container -->            
            <section class="row">
                <div class="col-sm-12 panel-general">
                    <section class="row">

                        <div class="panel panel-primary my-panel-perso">
                            <div class="panel-heading">
                                <h3 class="panel-title"> <b>ESPACE VIREMENT</b></h3>
                            </div>

                            <!--alert info enregistrement effectué-->
                            <c:if test="${!empty Veffectuer}">
                                <aside class="row">
                                    <div class="col-sm-2"></div>
                                    <div class="col-sm-8">
                                        <div class="alert alert-success alert-dismissable ">
                                            <button type="button" class="close" data-dismiss="alert"> </button>
                                            <strong><h4><span class="glyphicon glyphicon-ok"></span> virement effectué avec succes. . .(pour un autre virement cliquez l'onglet virement <span class="glyphicon glyphicon-hand-up"></span>)</h4></strong>
                                        </div>
                                    </div>
                                    <div class="col-sm-2"></div>
                                </aside>
                            </c:if>

                            </br>
                            <div class="panel-body">
                                <form action="virement" method="post" role="form">      
                                    <div class="col-sm-6">   <!-- debut panel compte emetteur -->                      
                                        <section class="row">
                                            <div class="panel panel-info hauteur">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">REFERENCE CLIENT EMETTEUR</h3>
                                                </div>
                                                </br>
                                                <div class="panel-body">

                                                    <fieldset>
                                                        <legend> </legend>

                                                        <div class="row">
                                                            <div class="col-xs-2"></div>
                                                            <div class="col-xs-4">
                                                                <div class="form-group alert-info">
                                                                    <select  name="numCpteE"class="selectpicker form-control">
                                                                        <c:forEach var="cpteE" items="${comptesE}" varStatus="cptr">
                                                                            <option value="${cpteE.numeroCompte}">${cptr.count}- &nbsp; ${cpteE.numeroCompte}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <button type="submit" name="btnActualiserE" class="btn btn-info"><span class="glyphicon glyphicon-search"></span> Actualiser</button>
                                                            </div>
                                                            <div class="col-xs-2"></div>
                                                        </div>
                                                        <hr/>
                                                        <section class="row">
                                                            <div class="col-sm-1"></div>
                                                            <div class="col-sm-10">
                                                                <div class="form-group">
                                                                    <label for="nom">Nom </label>
                                                                    <input type="hidden" name="numE" value="${clientE.codeClient}" class="form-control disabled">
                                                                    <input type="text" name="nomE" value="${clientE.nom}" class="form-control disabled" id="nom" style="background-color: #eeeeee" disabled required>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="prenom">Prenom </label>
                                                                    <input type="text" name="prenomE" value="${clientE.prenoms}" class="form-control" id="prenom" style="background-color: #eeeeee" disabled required>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="email">Email </label>
                                                                    <input type="text" name="emailE" value="${clientE.email}" class="form-control" id="email" style="background-color: #eeeeee" disabled required>
                                                                </div>

                                                                <div class="form-group">
                                                                    <label for="solde">Solde </label>
                                                                    <input type="text" name="soldeE" value="${soldeE}" class="form-control" id="solde" style="background-color: #eeeeee" disabled required>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-1"></div>
                                                        </section>
                                                    </fieldset>
                                                    <hr/>
                                                </div>
                                            </div>
                                        </section>   
                                        <!--  ==============================^^panel emetteur^^ & vv panel beneficiaire vv ================ -->

                                    </div>
                                    <div class="col-sm-6">      <!-- debut du panel compte beneficiaire-->
                                        <section class="row">
                                            <div class="panel panel-info hauteur">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">REFERENCE CLIENT BENEFICIAIRE</h3>
                                                </div>
                                                </br>
                                                <div class="panel-body">
                                                    <fieldset>
                                                        <legend></legend>                                                       
                                                        <div class="row">
                                                            <div class="col-xs-2"></div>
                                                            <div class="col-xs-4">
                                                                <div class="form-group alert-info">                                                                    
                                                                    <select  name="numCpteB" size="1" class="selectpicker form-control">
                                                                        <c:forEach var="cpteB" items="${comptesCli}" varStatus="cptr2">
                                                                            <option value="${cpteB}">&nbsp; ${cpteB}</option>
                                                                        </c:forEach>                                                                    
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <button type="submit" name="btnActualiserB" value="" class="btn btn-info"><span class="glyphicon glyphicon-search"></span> Actualiser</button>
                                                            </div>
                                                            <div class="col-xs-2"></div>
                                                        </div>
                                                        <hr/>

                                                        <section class="row">
                                                            <div class="col-sm-1"></div>
                                                            <div class="col-sm-10">
                                                                <div class="form-group">
                                                                    <label for="nom1">Nom </label>
                                                                    <input type="text" name="nomB" value="${clientB.nom}" class="form-control" id="nom1" style="background-color: #eeeeee" disabled required >
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="prenom1">Prenom </label>
                                                                    <input type="text" name="prenomB" value="${clientB.prenoms}" class="form-control" id="prenom1" style="background-color: #eeeeee" disabled required>
                                                                </div>   
                                                                <div class="form-group">
                                                                    <label for="email">Email </label>
                                                                    <input type="text" name="emailB" value="${clientB.email}" class="form-control" id="email" style="background-color: #eeeeee" disabled required>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="solde1">Solde </label>
                                                                    <input type="text" name="soldeB" value="${soldeB}" class="form-control" id="solde1"style="background-color: #eeeeee" disabled required>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-1"></div>
                                                        </section>
                                                        <span>
                                                        </span>
                                                    </fieldset>
                                                    <hr/><br/><br/><br/>
                                                    <!-- fin panel compte beneficiaire -->

                                                </div>
                                            </div>
                                        </section>
                                    </div>
                                </form>

                                <form action="virement" method="get" role="form">          <!-- debut du formulaire-->
                                    <div class="row">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-4">
                                            <div class="input-group ">
                                                <span class="input-group-addon alert-danger">Montant à virer</span>
                                                <input type="text" pattern="[1-9].{0,}" title="Entrez un montant SVP" name="montant" class="form-control" id="solde"  required>
                                                <span class="input-group-addon alert-danger">F CFA</span>                   
                                            </div>
                                        </div>
                                        <div class="col-xs-4"></div>
                                    </div>
                                    <br/>
                                    <div class="row">
                                        <div class="col-sm-5"></div>
                                        <div class="col-sm-3">
                                            <button type="submit" name="btnValiser" class="btn btn-danger">Valider</button>
                                            <button type="reset" class="btn btn-warning">Annuler</button>
                                        </div>
                                        <div class="col-sm-4"></div>
                                    </div>
                                </form>
                            </div>

                            <!-- fin formulaire d'enregistrement -->
                    </section>
                </div> 

            </section>

        </div>                                   <!-- fin du contener -->   
        <script src="../bootstrap/js/jquery-1.12.0.min.js"></script>
        <script src="../bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
