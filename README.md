# Java Backend

Sistema de registro de reserva, huéspedes de un hotel.

* Agregar, editar, eliminar reservas y huéspedes.

* Búsqueda por apellido de huésped y por número de reserva.

* Sistema de login para funcionarios.


El proyecto sigue el patrón de diseño MVC.

Escrito en Java, utilizando Java Swing para entorno GUI, base de datos MySQL para almacenar los datos manejados.


![Challenge 6 IMG](https://img.youtube.com/vi/4wzjR7SQux4/hqdefault.jpg "Challenge 6")

<p align="center">
	<img src="https://img.youtube.com/vi/4wzjR7SQux4/hqdefault.jpg" alt="Challenge 6"/>
	 <video width="320" height="240" controls>
		<source src="https://youtu.be/4wzjR7SQux4" type="video/mp4">
	</video> 
</p>




> Ejercicio desafío 6 de la formación Java Orientado a Objetos del Programa Oracle ONE - Alura Latam.


# Estructura del proyecto

```
.
├── dbPruebas.sql
├── LICENSE
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── hotelalura
│   │   │           ├── ConnectionFactory
│   │   │           │   └── PoolConnection.java
│   │   │           ├── controller
│   │   │           │   ├── BusquedaController.java
│   │   │           │   ├── HuespedController.java
│   │   │           │   ├── LoginController.java
│   │   │           │   └── ReservaController.java
│   │   │           ├── dao
│   │   │           │   ├── BusquedaDAO.java
│   │   │           │   ├── HuespedDAO.java
│   │   │           │   ├── InterfaceBusqueda.java
│   │   │           │   ├── InterfaceHuespedDAO.java
│   │   │           │   ├── InterfaceLogin.java
│   │   │           │   ├── InterfaceReservaDAO.java
│   │   │           │   ├── LoginDAO.java
│   │   │           │   └── ReservaDAO.java
│   │   │           ├── imagenes
│   │   │           ├── models
│   │   │           │   ├── Funcionario.java
│   │   │           │   ├── Huesped.java
│   │   │           │   └── Reserva.java
│   │   │           └── views
│   │   │               ├── Busqueda.java
│   │   │               ├── Exito.java
│   │   │               ├── Login.java
│   │   │               ├── MenuPrincipal.java
│   │   │               ├── MenuUsuario.java
│   │   │               ├── RegistroHuesped.java
│   │   │               └── ReservasView.java
```


# Paquetes

* *controller*: contiene todos los controladores del proyecto.
* *dao*: contiene todos los ficheros *Data Access Object* del proyecto.
* *models*: contiene los objetos que representan los datos en la base de datos.
* *views*: contiene todos los GUI de la aplicación.
* *ConnectionFactory*: contiene el objeto que crea el pool de conexiones hacia la base de datos.
* *imagenes*: todas las imágenes utilizadas en el proyecto.

