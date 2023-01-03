# Java Backend


```
├── dbPruebas.sql
├── LICENSE
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── clasesUtilitarias
│   │   │   │   ├── InterfaceNombreUsuario.java
│   │   │   │   └── NombreLogin.java
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
│   │   │           │   ├── aH-150px.png
│   │   │           │   ├── aH-40px.png
│   │   │           │   ├── busqueda.png
│   │   │           │   ├── calendario.png
│   │   │           │   ├── cancelar.png
│   │   │           │   ├── cerrar-24px.png
│   │   │           │   ├── cerrar-sesion 32-px.png
│   │   │           │   ├── deletar.png
│   │   │           │   ├── disquete.png
│   │   │           │   ├── editar-texto.png
│   │   │           │   ├── Ha-100px.png
│   │   │           │   ├── hotel.png
│   │   │           │   ├── icon-buscar.png
│   │   │           │   ├── icon-reservas.png
│   │   │           │   ├── img-hotel-login-.png
│   │   │           │   ├── login2.png
│   │   │           │   ├── login.png
│   │   │           │   ├── lOGO-50PX.png
│   │   │           │   ├── lupa-1.png
│   │   │           │   ├── lupa2.png
│   │   │           │   ├── menu-img.png
│   │   │           │   ├── papelera-de-reciclaje.png
│   │   │           │   ├── perfil-del-usuario.png
│   │   │           │   ├── persona.png
│   │   │           │   ├── pessoas.png
│   │   │           │   ├── registro.png
│   │   │           │   ├── reservado.png
│   │   │           │   ├── reservas-img-3.png
│   │   │           │   └── reservas.png
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
│   │   └── resources
│   └── test
│       ├── java
│       └── resources
└── target
    ├── classes
    │   ├── clasesUtilitarias
    │   │   ├── InterfaceNombreUsuario.class
    │   │   └── NombreLogin.class
    │   ├── com
    │   │   └── hotelalura
    │   │       ├── ConnectionFactory
    │   │       │   └── PoolConnection.class
    │   │       ├── controller
    │   │       │   ├── BusquedaController.class
    │   │       │   ├── HuespedController.class
    │   │       │   ├── LoginController.class
    │   │       │   └── ReservaController.class
    │   │       ├── dao
    │   │       │   ├── BusquedaDAO.class
    │   │       │   ├── HuespedDAO.class
    │   │       │   ├── InterfaceBusqueda.class
    │   │       │   ├── InterfaceHuespedDAO.class
    │   │       │   ├── InterfaceLogin.class
    │   │       │   ├── InterfaceReservaDAO.class
    │   │       │   ├── LoginDAO.class
    │   │       │   └── ReservaDAO.class
    │   │       ├── imagenes
    │   │       │   ├── aH-150px.png
    │   │       │   ├── aH-40px.png
    │   │       │   ├── busqueda.png
    │   │       │   ├── calendario.png
    │   │       │   ├── cancelar.png
    │   │       │   ├── cerrar-24px.png
    │   │       │   ├── cerrar-sesion 32-px.png
    │   │       │   ├── deletar.png
    │   │       │   ├── disquete.png
    │   │       │   ├── editar-texto.png
    │   │       │   ├── Ha-100px.png
    │   │       │   ├── hotel.png
    │   │       │   ├── icon-buscar.png
    │   │       │   ├── icon-reservas.png
    │   │       │   ├── img-hotel-login-.png
    │   │       │   ├── login2.png
    │   │       │   ├── login.png
    │   │       │   ├── lOGO-50PX.png
    │   │       │   ├── lupa-1.png
    │   │       │   ├── lupa2.png
    │   │       │   ├── menu-img.png
    │   │       │   ├── papelera-de-reciclaje.png
    │   │       │   ├── perfil-del-usuario.png
    │   │       │   ├── persona.png
    │   │       │   ├── pessoas.png
    │   │       │   ├── registro.png
    │   │       │   ├── reservado.png
    │   │       │   ├── reservas-img-3.png
    │   │       │   └── reservas.png
    │   │       ├── models
    │   │       │   ├── Funcionario.class
    │   │       │   ├── Huesped.class
    │   │       │   └── Reserva.class
    │   │       └── views
    │   │           ├── Busqueda$1.class
    │   │           ├── Busqueda$2.class
    │   │           ├── Busqueda$3.class
    │   │           ├── Busqueda$4.class
    │   │           ├── Busqueda$5.class
    │   │           ├── Busqueda$6.class
    │   │           ├── Busqueda$7.class
    │   │           ├── Busqueda$8.class
    │   │           ├── Busqueda$9.class
    │   │           ├── Busqueda.class
    │   │           ├── Exito$1.class
    │   │           ├── Exito.class
    │   │           ├── Login$1.class
    │   │           ├── Login$2.class
    │   │           ├── Login$3.class
    │   │           ├── Login$4.class
    │   │           ├── Login$5.class
    │   │           ├── Login$6.class
    │   │           ├── Login$7.class
    │   │           ├── Login.class
    │   │           ├── MenuPrincipal$1.class
    │   │           ├── MenuPrincipal$2.class
    │   │           ├── MenuPrincipal$3.class
    │   │           ├── MenuPrincipal$4.class
    │   │           ├── MenuPrincipal$5.class
    │   │           ├── MenuPrincipal.class
    │   │           ├── MenuUsuario$1.class
    │   │           ├── MenuUsuario$2.class
    │   │           ├── MenuUsuario$3.class
    │   │           ├── MenuUsuario$4.class
    │   │           ├── MenuUsuario$5.class
    │   │           ├── MenuUsuario$6.class
    │   │           ├── MenuUsuario.class
    │   │           ├── RegistroHuesped$1.class
    │   │           ├── RegistroHuesped$2.class
    │   │           ├── RegistroHuesped$3.class
    │   │           ├── RegistroHuesped$4.class
    │   │           ├── RegistroHuesped$5.class
    │   │           ├── RegistroHuesped$6.class
    │   │           ├── RegistroHuesped$7.class
    │   │           ├── RegistroHuesped$8.class
    │   │           ├── RegistroHuesped.class
    │   │           ├── ReservasView$1.class
    │   │           ├── ReservasView$2.class
    │   │           ├── ReservasView$3.class
    │   │           ├── ReservasView$4.class
    │   │           ├── ReservasView$5.class
    │   │           ├── ReservasView$6.class
    │   │           ├── ReservasView$7.class
    │   │           ├── ReservasView$8.class
    │   │           └── ReservasView.class
    │   └── META-INF
    │       ├── MANIFEST.MF
    │       └── maven
    │           └── com.hotelalura.kurotom
    │               └── hotelalura
    │                   ├── pom.properties
    │                   └── pom.xml
    └── test-classes
```
