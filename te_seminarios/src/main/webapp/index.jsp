
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Pagina de venta de productos tecnologicos">
        <meta name="author" content="Pedro Luis Condori Cutile">
        <link rel="canonical" href="loginControlador">
        <link rel="icon" href="IMG/imagen.ico">
        <link href="CSS/styles.css" rel="stylesheet"> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <title>Inicio</title>
    </head>
    <body class="d-flex align-content-start h-100 flex-wrap text-start text-white bg-dark">
        <div class="container">
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="Index"/>
            </jsp:include>
            <div class="row bg-dark">
                <div class="col-12">
                    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
                        <header class="mb-auto">
                        </header>

                        <main class="px-3">
                            <h1 class="text-center fw-bolder">Bienvenido a la pagina</h1>
                            <p class="text-center fw-light">Sistema de seminarios que contiene las operaciones de registrar, actualizar, eliminar para los modulos participantes y seminarios</p>
                            <div id="myCarousel" class="carousel slide h-70" data-bs-ride="carousel">
                                <div class="carousel-indicators ">
                                    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                    <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                </div>
                                <div class="carousel-inner h-70">
                                    <div class="carousel-item active" data-bs-interval="10000">
                                        <img class="d-block h-50 w-100" src="https://thumbs.dreamstime.com/z/altavoz-del-seminario-del-negocio-que-hace-la-presentaci%C3%B3n-y-el-entrenamiento-profesional-74591093.jpg" alt="alt"/>
                                    </div>
                                    <div class="carousel-item" data-bs-interval="2000">
                                        <img class="d-block h-50 w-100" src="https://significado.net/wp-content/uploads/2015/06/Seminario.-Ilustraci%C3%B3n.png" alt="alt"/>
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                        </main>

                        <footer class="mt-auto text-white-50 text-center">
                            <p class="fw-lighter fs-6">Mas sobre mi: <a href="https://luiskonkut.com" class="text-white">Portafolio</a>, <a href="https://github.com/konkut" class="text-white">Github</a></p>
                        </footer>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
