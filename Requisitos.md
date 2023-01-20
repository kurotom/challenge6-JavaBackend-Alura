# Hotel Casucha

Control de las reservaciones hechas por sus clientes se desarrolló un sistema de reserva que contenga:

* Sistema de autenticación de usuario para que solo usuarios pertenecientes al hotel consigan acceder al sistema.

* Permitir crear, editar y eliminar una reserva para los clientes.

* Buscar en la base de datos todas las informaciones tanto de los clientes como de las reservas.

* Registrar, editar y eliminar datos de los huéspedes.

* Calcular el valor de la reserva en base a la cantidades de días de la reserva y a una tasa diaria que puede ser asignada por ti y en la moneda local de tu país, por ejemplo si tenemos una reserva de 3 dias y el valor de nuestra diaria son 20$ debemos multiplicar esos 3 dias por el valor de la diaria que serian 60$, todo esto deberá ser hecho automaticamente y mostrado al usuario antes de guardar la reserva.

* Base de datos para almacenar todos los datos pedidos anteriormente.

![](entidad-relacion.png "diagrama relacion DB")

* Crear un *README.md* con la descripción del proyecto.



# Menu principal

El menú principal de nuestra aplicación es nuestra presentación, podemos ver que contiene diferentes elementos:

* Imagen de wallpaper.

* Logo del Hotel.

* Botón Login que al ser clickado debe llevar a la ventana de iniciar sesión.

* Botón salir que debe preguntar al usuario si realmente desea salir de la aplicación.




# Ventana Login

Esta ventana debe permitir al usuario ingresar su usuario y contraseña.
Por detrás de la cortina debemos verificar si los datos ingresados son correctos o incorrectos y notificar al usuario de este estatus, por ejemplo si los datos son incorrectos debe ser mostrado una mensaje al usuario diciendo *"Usuario y Contraseña inválidos"*

Para realizar esta tarea puedes crear usuarios predeterminados a través del código, que seria una opción más simple, o crear una tabla en tu base de datos para realizar esta autenticación e inclusive adicionar nuevos usuarios.

* Debe llevar una imágen de fondo.

* Usuario predeterminado
```
usuario: admin
contraseña: admin
```



# Ventana Usuario

En esta ventana se presentarán las opciones cuando el usuario autenticado está dentro del sistema, tienes las siguientes opciones:

* Debe llevar una imágen de fondo.
* Reservar: Deve llevar a la ventana de Reservas
* Búsqueda: Deve llevar a la ventana de Sistema de búsqueda.
* Salir del Sistema: Deve llevar a la ventana de Login



# Ventana Registro de Reservas

La ventana de Reservas debe permitir al usuário registrar los siguientes datos:

* Debe llevar una imágen de fondo.
* Dia de Entrada
* Dia de Salida
* Valor de la reserva que será calculada en base a un valor de diaria fijo que tú mismo podrás elegir.
* Forma de Pago donde el usuário podrá elegir entre:
  * Tarjeta de crédito
  * Tarjeta de débito
  * Dinero en efectivo
* Botón continuar


Es importante que al momento de guardar nuestros datos sea generado un número de reserva (un **UUID** y una llave primaria) que será utilizado en la sección de registro de huéspedes de forma automática ya que será un campo que el usuário no podrá manipular.

Recuerda que debes notificar al usuário tanto para registro satisfactorio de los datos como si ocurrió algún error.



# Ventana de Registro de Huésped

Esta sección tendrá los datos personales de los huéspedes con los siguientes campos:

* Debe llevar una imágen de fondo.
* Nombre
* Apellido
* Fecha de Nacimiento
* Nacionalidad
* Teléfono
* Número de reserva que fue generada anteriormente.

Recuerda que debes notificar al usuário tanto para registro satisfactorio de los datos como si ocurrió algún error.

* Mostrar como mensaje al usuario el número de reserva.



# Sistema de Búsqueda

Esta sección debe permitir al usuario buscar las informaciones que están dentro de nuestra base de datos.

* Debe llevar una imágen de fondo.

Existen dos critério de búsqueda:
- Apellido
- Número de Reserva

Estos datos serán presentado a través de dos tablas, al seleccionar cualquier registro el usuario podrá, editar o eliminar dicho registro.



# Editar Datos Reservas

Si el usuario necesita hacer la edición de alguna información, al hacer click en el registro que se desea modificar y en el icono de editar debe conseguir editar los datos y una vez hecha la modificación el usuario deverá ser notificado de que los cambios fueron guardados o si hubo algún error.



# Editar Datos Huésped

Si el usuario necesita hacer la edición de alguna información, al hacer click en el registro que se desea modificar y en el icono de editar debe conseguir editar los datos y una vez hecha la modificación el usuario deverá ser notificado de que los cambios fueron guardados o si hubo algún error.



# Eliminar Datos Reservas

Si el usuario necesita eliminar algún registro, al hacer click en el registro que se desea eliminar y en el icono de eliminar debe conseguir eliminar los datos y una vez hecha la eliminación el usuario deverá ser notificado de que los cambios fueron hechos o si hubo algún error, además de actualizar los datos de la tabla y mostrarlo en pantalla

Tip: Para actualizar la base de datos después de eliminar algún registro tal vez podamos llamar nuevamente a nuestro método Buscar.




# Eliminar Datos Huésped

Si el usuario necesita eliminar algún registro, al hacer click en el registro que se desea eliminar y en el icono de eliminar debe conseguir eliminar los datos y una vez hecha la eliminación el usuario deverá ser notificado de que los cambios fueron hechos o si hubo algún error, además de actualizar los datos de la tabla y mostrarlo en pantalla

Tip: Para actualizar la base de datos después de eliminar algún registro tal vez podamos llamar nuevamente a nuestro método Buscar.




# OPCIONAL

* Si deseas puedes implementar un menú bar para tu sistema.
* Puedes también registrar el tipo de habitación seleccionada.

