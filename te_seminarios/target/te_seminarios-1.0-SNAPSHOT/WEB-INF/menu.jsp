<%
    String opcion = request.getParameter("opcion");
%>
<div class="row bg-dark">
    <div class="col-12">
        <div class="d-flex h-20 w-100 justify-content-between">
            <nav class="nav nav-masthead ">
                <div class="fw-lighter border border-primary p-2 text-primary me-3">Control de Participantes y Seminarios</div>
                <a class="nav-link <%=(opcion.equals("Index")) ? "active" : ""%>" href="index.jsp" aria-current="page">Inicio</a>
                <a class="nav-link <%=(opcion.equals("Seminarios")) ? "active" : ""%>" href="seminarioControlador">Seminarios</a>
                <a class="nav-link <%=(opcion.equals("Participantes")) ? "active" : ""%>" href="participanteControlador">Participantes</a>
            </nav>
        </div>
                            <div class="fw-lighter d-block border border-dark p-2 text-primary me-3">Segundo Parcial TEM-742<br>Nombre: Pedro Luis Condori Cutile<br>Carnet: 9943509 LP</div>
    </div>
</div>


