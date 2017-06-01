<#include  "header.ftl"/>
<div class="container">
    <h3>Lista de estudiantes</h3>
   <table class="table table-hover">
       <thead class="thead-inverse">
           <tr>
               <th>#</th>
               <th>Matricula</th>
               <th>Nombre</th>
               <th>Apellido</th>
               <th>Telefono</th>
               <th>Edit</th>
               <th>Delete</th>
           </tr>
       </thead>
        <tbody>

        <#list estudiantes?keys as estudiante>

                <tr>
                    <th scope="row" id="id">${estudiante}</th>
                    <td>${estudiantes[estudiante]["matricula"]?string["0"]}</td>
                    <td id="nombre">${estudiantes[estudiante]["nombre"]}</td>
                    <td id="nombre">${estudiantes[estudiante]["apellido"]}</td>
                    <td>${estudiantes[estudiante]["telefono"]}</td>
                    <td><a href="/estudiante/${estudiante}/update"><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></a> </td>
                    <td><a href="/estudiante//delete/"><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></a></td>

                </tr>


        </#list>
        </tbody>
   </table>
</div>


    <#--<!-- Modal &ndash;&gt;-->
    <#--<div class="modal fade" id="myModal" role="dialog">-->
        <#--<div class="modal-dialog">-->

            <#--<!-- Modal content&ndash;&gt;-->
            <#--<div class="modal-content">-->
                <#--<div class="modal-header">-->
                    <#--<button type="button" class="close" data-dismiss="modal">&times;</button>-->
                    <#--<h3 class="modal-title">Deseas realmente eliminar el estudiante?</h3>-->
                <#--</div>-->
                <#--<div class="modal-body">-->
                    <#--<h4 id="estudiante"></h4>-->

                <#--</div>-->
                <#--<div class="modal-footer">-->
                    <#--<form method="post" action="/estudiante/delete">-->
                        <#--<input type="hidden" name="id" id="hiddenValue" value="">-->
                        <#--<button type="button" class="btn btn-priamry" data-dismiss="modal">Cancel</button>-->
                        <#--<button type="submit" class="btn btn-primary" data-dismiss="modal">Delete</button>-->
                    <#--</form>-->
                <#--</div>-->
            <#--</div>-->

        <#--</div>-->
    <#--</div>-->



<#--<script>-->
    <#--$(document).ready(function(){-->
        <#--$(".delete").click(function(){-->
            <#--$("#estudiante").val($(this).data('nombre')+" "+ $(this).data('apellido'));-->
            <#--$("#hiddenValue").val($(this).data('id'));-->
        <#--});-->
            <#--$("#myModal").modal();-->
        <#--});-->


<#include "footer.ftl"/>