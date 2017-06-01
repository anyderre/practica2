<#include  "header.ftl">
<div class="container">
    <form action="/estudiante/agregar" method="post">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="form-group">
                <label for="matricula">Matricula</label>
                <input type="number" id="matricula" class="form-control" min="10000000"  max="99999999" name="matricula" required>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" class="form-control" name="nombre"  required>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="row"></div>
        <div class="col-md-offset-3 col-md-6">
            <div class="form-group">
                <label for="apellido">Apellido</label>
                <input type="text" id="apellido" class="form-control" name="apellido" required>
            </div>
        </div>
    </div>
       
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="form-group">
                <label for="tel">Telefono</label>
                <input type="tel" id="tel" class="form-control" name="telefono" required>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="form-group">
            <div class="col-md-offset-3 col-md-3 form-group">
                <input type="submit" class="btn btn-primary form-control" value="Agregar">
            </div>
            <div class="col-md-3">
                <input type="reset" class="btn btn-primary form-control" value="Cancelar"/>
            </div>
        </div>
    </div>
    </form>
</div>

<#include "footer.ftl">