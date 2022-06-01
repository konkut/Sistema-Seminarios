<%
    String opcion = request.getParameter("opcion");
%>
<div class="row bg-dark">
    <div class="col-12">
        <div class="d-flex h-20 w-100 justify-content-between">
            <nav class="nav nav-masthead ">
                <div class="fw-lighter border border-primary p-2 text-primary me-3">Punto de venta</div>
                <a class="nav-link <%=(opcion.equals("Index")) ? "active" : ""%>" href="index.jsp" aria-current="page">Inicio</a>
                <a class="nav-link <%=(opcion.equals("Productos")) ? "active" : ""%>" href="productoControlador">Productos</a>
                <a class="nav-link <%=(opcion.equals("Clientes")) ? "active" : ""%>" href="clienteControlador">Clientes</a>
                <a class="nav-link <%=(opcion.equals("Ventas")) ? "active" : ""%>" href="ventaControlador">Ventas</a>
                <a class="nav-link <%=(opcion.equals("Usuarios")) ? "active" : ""%>" href="usuarioControlador">Usuarios</a>
            </nav>
            <a class="btn btn-outline-primary" href="logoutControlador?action=logout">Cerrar Session</a>  
        </div>
    </div>

</div>


