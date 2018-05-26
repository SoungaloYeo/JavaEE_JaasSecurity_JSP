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

                    <form action="virement" method="post" role="form">      
                        <section class="row">

                            <div class="panel panel-primary my-panel-perso">
                                <div class="panel-heading">
                                    <h3 class="panel-title"> <b>ESPACE VIREMENT</b></h3>
                                </div>

                                <!--alert info enregistrement effectué-->
                                <c:if test="${!empty Veffectuer}">
                                    <aside class="row">
                                        <div class="col-sm-1"></div>
                                        <div class="col-sm-10">
                                            <div class="alert alert-success alert-danger text-center ">
                                                <button type="button" class="close" data-dismiss="alert"> </button>
                                                <strong><h4><span class="glyphicon glyphicon-ok"></span> Virement d'un montant de<b> ${montant} F CFA </b> du compte <b>${choixCpteE}</b> vers le compte <b>${choixCpteB}</b> </h4></strong>
                                            </div>
                                        </div>
                                        <div class="col-sm-1"></div>
                                    </aside>
                                </c:if>

                                </br>
                                <div class="panel-body">
                                    <div class="col-sm-6">   <!-- debut panel compte emetteur -->                      
                                        <section class="row">
                                            <div class="panel panel-success info hauteur">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">REFERENCE CLIENT EMETTEUR <br/>
                                                        (choisissez l'un des comptes du client emetteur)</h3>
                                                </div>
                                                </br>
                                                <div class="panel-body">

                                                    <c:if test="${empty Veffectuer}">
                                                        <div class="row">
                                                            <div class="col-xs-2"></div>
                                                            <div class="col-xs-4">
                                                                <div class="form-group alert-info">
                                                                    <select name="numCpteE"class="selectpicker form-control">
                                                                        <c:forEach var="cpteE" items="${comptesE}" varStatus="cptr">
                                                                            <option value="${cpteE.numeroCompte}">&nbsp; ${cpteE.numeroCompte}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <button type="submit" value="btnActualiserE" name="btnActualiserE" class="btn alert-success info" ><span class="glyphicon glyphicon-search"></span> Voir le solde</button>
                                                            </div>
                                                            <div class="col-xs-2"></div>
                                                        </div>
                                                    </c:if>
                                                    <hr/>
                                                    <c:if test="${!empty choixCpteE}">                                                            
                                                        <aside class="row">
                                                            <div class="col-sm-2"></div>
                                                            <div class="col-sm-8">
                                                                <div class="alert alert-success info ">
                                                                    <button type="button" class="close" data-dismiss="alert"> </button>                                                                    
                                                                    <span class="glyphicon glyphicon-check"></span> &nbsp; N°de compte choisi: ${choixCpteE} <br/>                                                                    
                                                                    <h4>SOLDE A CE JOUR:<b> ${soldeE} FCFA </b></h4>
                                                                    <input type="hidden" name="soldeEAffiche" value="${soldeE}">
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-2"></div>
                                                        </aside>
                                                    </c:if>
                                                    <section class="row">
                                                        <div class="col-sm-1"></div>
                                                        <div class="col-sm-10">
                                                            <div class="form-group">
                                                                <label for="nom">Nom </label>
                                                                <input type="hidden" name="codeCliE" value="${clientE.codeClient}">
                                                                <input type="text" name="nomE" value="${clientE.nom}" class="form-control disabled" id="nom" style="background-color: #eeeeee" disabled >
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="prenom">Prenom </label>
                                                                <input type="text" name="prenomE" value="${clientE.prenoms}" class="form-control" id="prenom" style="background-color: #eeeeee" disabled >
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="email">Email </label>
                                                                <input type="text" name="emailE" value="${clientE.email}" class="form-control" id="email" style="background-color: #eeeeee" disabled >
                                                            </div>                                                           
                                                        </div>
                                                        <div class="col-sm-1"></div>
                                                    </section>
                                                </div>
                                            </div>
                                        </section>   
                                        <!--  ==============================^^panel emetteur^^ & vv panel beneficiaire vv ================ -->

                                    </div>
                                    <!--</form>-->
                                    <!--                                <form action="info-beneficiaire" method="post">-->
                                    <div class="col-sm-6">      <!-- debut du panel compte beneficiaire-->
                                        <section class="row">
                                            <div class="panel panel-info hauteur">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">REFERENCE CLIENT BENEFICIAIRE <br/>
                                                        (choisissez le N°de compte du client bénéficiaire)</h3>
                                                </div>
                                                </br>
                                                <div class="panel-body">
                                                    <c:if test="${empty Veffectuer}">
                                                        <div class="row">
                                                            <div class="col-xs-2"></div>
                                                            <div class="col-xs-4">
                                                                <div class="form-group alert-info">                                                                    
                                                                    <select  name="numCpteB" class="selectpicker form-control">
                                                                        <c:forEach var="cpteB" items="${comptesCli}" varStatus="cptr2">
                                                                            <option value="${cpteB}">&nbsp; ${cpteB}</option>
                                                                        </c:forEach>                                                                    
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <button type="submit" name="btnActualiserB" value="btnActualiserB" class="btn btn-info"><span class="glyphicon glyphicon-search"></span> Voir le solde</button>
                                                            </div>
                                                            <div class="col-xs-2"></div>
                                                        </div>
                                                    </c:if>
                                                    <hr/>

                                                    <c:if test="${!empty choixCpteB}">                                                            
                                                        <aside class="row">
                                                            <div class="col-sm-2"></div>
                                                            <div class="col-sm-8">
                                                                <div class="alert alert-success alert-info ">
                                                                    <button type="button" class="close" data-dismiss="alert"> </button>
                                                                    <span class="glyphicon glyphicon-check"></span>&nbsp; N°de compte choisi: ${choixCpteB}<br/>                                                                    
                                                                    <h4>SOLDE A CE JOUR:<b> ${soldeB} F CFA </b></h4>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-2"></div>
                                                        </aside>
                                                    </c:if>

                                                    <section class="row">
                                                        <div class="col-sm-1"></div>
                                                        <div class="col-sm-10">
                                                            <div class="form-group">
                                                                <label for="nom1">Nom </label>
                                                                <input type="hidden" name="codeCliB" value="${clientB.codeClient}">
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
                                                        </div>
                                                        <div class="col-sm-1"></div>
                                                    </section>

                                                    <!--<br/><br/><br/>-->
                                                    <!-- fin panel compte beneficiaire -->

                                                </div>
                                            </div>
                                        </section>
                                    </div>
                                    <!--</form>-->


                                </div>
                                <c:choose> 
                                    <c:when test="${empty soldeE || empty choixCpteB}">
                                        <div class="alert alert-danger alert-dismissable center-block">
                                            selectionnez un N°de compte puis cliquez sur le bouton <b>"voir le solde".</b>  Ceci est valable aussi bien pour <b>l'emeteur</b> que pour le <b>beneficiaire</b>
                                        </div>
                                    </c:when>
                                    <c:when test="${(!empty choixCpteE && !empty choixCpteB) && empty Veffectuer}">
                                        <!--condition verifiant l'existance des deux montants conserné par le virement--> 

                                        <!-- si le montant saisi est inferieur au solde du compte emetteur -->
                                        <c:if test="${!empty message}">
                                            <div class="alert alert-danger alert-dismissable center-block">
                                                <b> ${message}</b>
                                            </div>
                                        </c:if>
                                        <div class="row">
                                            <div class="col-xs-4"></div>
                                            <div class="col-xs-4">
                                                <div class="input-group ">
                                                    <span class="input-group-addon alert-danger">Montant à virer</span>
                                                    <input type="number" pattern="[1-9].{0,}"  name="montant" value="0" title="Entrez un montant SVP" class="form-control center-block" style="text-align: center" id="solde" required>
                                                    <span class="input-group-addon alert-danger">F CFA</span>                   
                                                </div>
                                            </div>
                                            <div class="col-xs-4"></div>
                                        </div>
                                        <br/>
                                        <div class="row">
                                            <div class="col-sm-5"></div>
                                            <div class="col-sm-3" style="padding-bottom: 6px">

                                                <!--================================================== creation du modal ===================================================-->
                                                <div class="col-sm-offset-2">
                                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">
                                                        Virer le montant
                                                    </button>
                                                </div>
                                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">

                                                            <div class="modal-body alert-danger" style="text-align: center">
                                                                <h3>Vous confirmez le virement ?</h3>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="reset" data-dismiss="modal" class="btn btn-primary btn-sm form-button">Annuler</button>
                                                                <button type="submit" name="btnValider" value="btnValider" class="btn btn-danger">Confirmé</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--========================================================================================================-->
                                            </div>
                                            <div class="col-sm-4"></div>
                                        </div>
                                    </c:when>
                                </c:choose>

                        </section>
                    </form>
                </div> 

            </section>

        </div>                                   <!-- fin du contener -->   
        <script src="../bootstrap/js/jquery-1.12.0.min.js"></script>
        <script src="../bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
