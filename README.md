# caja-unapec


Para poder ejecutar el proyecto debes tener un servidor de MySQL corriendo.

Luego actualizar el archivo `src/main/resources/application.properties` con la siguientes informaciones:

```
spring.datasource.url=<tu url a la base de datos> 
spring.datasource.username=<tu nombre de usuario>
spring.datasource.password=<tu contraseña>
```

Este es un ejemplo de como se veria luego de actualizarlo:

```
spring.datasource.url=jdbc:mysql://localhost:3306/caja-unapec
spring.datasource.username=root
spring.datasource.password=
```