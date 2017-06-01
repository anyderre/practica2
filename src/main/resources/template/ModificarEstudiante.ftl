<#include "header.ftl">
<h1 id="modificar">Modificar estudiante</h1>
<div class="container">
    <form action="/estudiante/modificar" method="post">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="form-group">
                <label for="matricula">Matricula</label>
                <input type="number" id="matricula" name="matricula" class="form-control" value="${estudiante["matricula"]?string["0"]}" required>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" class="form-control" value="${estudiante["nombre"]}" required />
            </div>
        </div>
    </div>
    <div class="row">
        <div class="row"></div>
        <div class="col-md-offset-3 col-md-6">
            <div class="form-group">
                <label for="apellido">Apellido</label>
                <input type="text" id="apellido" name="apellido" class="form-control" value="${estudiante["apellido"]}" required/>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="form-group">
                <label for="tel">Telefono</label>
                <input type="tel" id="tel" name="telefono" class="form-control" value="${estudiante["telefono"]}" required/>
            </div>

        </div>
    </div>


        <div class="row">
        <div class="form-group">
            <div class="col-md-offset-3 col-md-3 form-group">
                <input type="submit" class="btn btn-primary form-control" value="Modificar">
            </div>
            <div class="col-md-3">
                <input type="reset" class="btn btn-primary form-control" value="Cancelar"/>
            </div>
        </div>
        </div>
            <input type="hidden" name="id" value="${estudiante["id"]}"/>
    </form>
</div>

<#include  "footer.ftl">