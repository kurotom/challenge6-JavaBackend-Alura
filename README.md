# Java Backend

Sistema de registro de reserva, huéspedes de un hotel.

* Agregar, editar, eliminar reservas y huéspedes.

* Búsqueda por apellido de huésped y por número de reserva.

* Sistema de login para funcionarios.


El proyecto sigue el patrón de diseño MVC.

Escrito en Java, utilizando Java Swing para entorno GUI, base de datos MySQL para almacenar los datos manejados.


<p align="center">
	<img src="https://doc-0k-0k-docs.googleusercontent.com/docs/securesc/v11egt6mtf4gkleqsoko4hs52bch5h92/h874jdk4t5bcaplhv2ou1epc7emb25fa/1672844100000/12739533963501015635/12739533963501015635/1iAP4wGui49EyWQWb0g_r8YarkOJHqBrF?e=view&ax=ALjR8sxCHYAwN7-zYjluZtT79jzQY5U-k1J17LzDlohZJtAVn5woZlhxm2WVhbGgmnrA5zv_vfWzREKodg_2blEDfWjt0pYgC5GPxfRCtauCJclMo4C0pT6ORnsXECCk_1p7KwyOZacNf6r4_b5gnVXdOln0CpT1R4Gim3PEQjFKq0DyQHR3ZHAvWm55D9ZVp-7PGbaQqCnd2eu9Q1VWedrI-9oZa68S2ueboYS5rKYVTC0TVY7CkToAI1NVAI7ZnnMqyj4-l4ptvJsikOwPmuFD-rpE0ntckboBvaz6DCT5IwowyP8IYwcRTSO33_mkJM2_vS2ubnqmXwL1b7hWuVVX97nypx9-WvQebCgn6dBUOphJsMgqqwlbMA_bRHSulO_QRxTUq4xStcQ9dRhqGYwWMf0GUFhF_U7TdBd490cmFdfeX8oHLiBDBRHPuoISEoWbKQUxSAdSUxHn20NEsNfm94WIi8cOo0PGu7wmZ83CtPdfoysQqVV-y0XEoVxHYmEFfeyvCF5JPYlBscWLDxKoKBKKy-vTGBsnda0E-4nfFHHOWTZFis5XQYinB0L9U7xIJuP4Ujax5agPIbwsFpK46aaBzj8Poczk00Qck_KjDb9x4tvGrv__RLpuL0Yz9XhATGYzQVFTzACHR-GPcerHecRvTmAn3z60BcDDehxfcIdlxGyWfI456B6e0esuyHiDQtoCX_ET53PC-40GhLXHFRo_1ptDPiuSVLA9sXAhdS_cYiSPQYMtMxR9tYKDMn5_UJNk3G7-DbWlf9T5oRM18ni4RyzrfZd3zLitRHHYTxT6q21Qs9lrmdnmvrYxqVPutLfOn2R5V0eK3QC7DrrO6jmtsHV_J0LYmXPHggcDpwr2ogzqL0qJI2_85h2oQRKTJJNB9vLO2xxzpVUJ5tjJzadlUvx4zg6GORc&uuid=f68937d1-11d5-4978-84c5-c01c0230fcdd&authuser=0&nonce=rb64ggs723kqu&user=12739533963501015635&hash=4mb55lsp7n3ediqkd1qjd3rr335p31hc" alt="challenge6"/>
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

