<%-- 
    Document   : editerclient
    Created on : 29 juin 2016, 01:07:49
    Author     : Achi Blay Kevin C. <Achi Blay Kevin C. at blay12cedric@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale = 1"/>

        <title></title>

        <!-- Fichier CSS de Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/editerclient.css" rel="stylesheet"/>
    </head>

    <body>
        <%@include file="headerNavBar.jsp" %>    

        <div class="container">
            <div class="panel panel-primary my-info-panel">
                <div class="panel-heading">
                    MISE A JOUR INFORMATIONS CLIENT
                </div>
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">
                        <div class="alert alert-success" role="alert" style="text-align: center"><b><h4>Mettez Ã  jour les informations concernant un Client
                                    donné en utilisant le formulaire ci-dessous.</h4></b>
                        </div>
                        <form class="panel-body" action="editerclient" method="post">


                            <div class="col-md-4">    
                                <div class="label-input">
                                    <label for="nom">Nom</label>
                                    <input type="hidden" value="${client.codeClient}" name="codeCli"/>
                                    <input type="text" class="form-control" value="${client.nom}" name="nom" required/>
                                </div>
                                <div class="label-input">
                                    <label for="prenom">Prénoms</label>
                                    <input type="text" class="form-control" value="${client.prenoms}" name="prenom" required/>
                                </div>
                            </div>

                            <div class="col-md-4">
                                <div class="label-input">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" value="${client.email}" name="email" required/>
                                </div>
                                <div class="label-input">
                                    <label for="adresse">Adresse</label>
                                    <input type="text" class="form-control" value="${client.adresse}" name="adresse" required/>
                                </div>
                            </div>
                            <c:if test="${empty clientAJour}">
                                <div class="col-md-4">                    
                                    <div class="my-button pull-right" style="margin-top: 85px">                                        
                                        <!--=====================================================================================================-->

                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">
                                            Enregistrer
                                        </button>
                                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">

                                                    <div class="modal-body alert-danger" style="text-align: center">
                                                        <h3>Etes vous  sur de vouloir enregistrer ?</h3>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">Non</button>
                                                        <button type="submit" name="valider" value="valider" style="margin-right: 10px;" class="btn btn-danger btn-sm form-button" >Oui</button>
                                                        <!--<button type="button" class="btn btn-primary">Send message</button>-->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!--========================================================================================================-->
                                    </div>
                                </div>
                            </c:if>
                        </form>
                        <c:if test="${!empty clientAJour}">
                            <hr/>
                            <div class="alert alert-success" role="alert" style="text-align: center"><b><h4><span class="glyphicon glyphicon-ok"></span>&nbsp; Les informations ont été mises à jour avec succes</h4> </b></div>
                            <div class="col-md-4">    
                                <div class="label-input">
                                    <label for="nom">Nom</label>
                                    <input type="text" class="form-control" value="${clientAJour.nom}" disabled/>
                                </div>
                                <div class="label-input">
                                    <label for="prenom">Prénoms</label>
                                    <input type="text" class="form-control" value="${clientAJour.prenoms}" disabled/>
                                </div>
                            </div>

                            <div class="col-md-4">
                                <div class="label-input">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" value="${clientAJour.email}" disabled/>
                                </div>
                                <div class="label-input">
                                    <label for="adresse">Adresse</label>
                                    <input type="text" class="form-control" value="${clientAJour.adresse}" disabled/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-1"></div>
                    </div><br/><hr/>
                </c:if>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script src="../bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>