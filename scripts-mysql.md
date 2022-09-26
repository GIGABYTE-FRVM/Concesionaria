# SCRIPTS DE MYSQL

## Marca
~~~
DROP TABLE IF EXISTS `marca`;
CREATE TABLE `marca` ( `id` bigint(20) NOT NULL, `codigo` varchar(255) DEFAULT NULL, `descripcion` varchar(255) DEFAULT NULL, `nombre` varchar(255) DEFAULT NULL, `id_pais` int(11) NOT NULL ) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
~~~

## Pais
~~~
DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` ( `id` int(11) NOT NULL, `nombre` varchar(50) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
~~~

## Personal
~~~
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal` ( `id` int(11) NOT NULL, `nombre` varchar(50) NOT NULL, `apellido` varchar(50) NOT NULL, `direccion` varchar(50) NOT NULL, `documento` varchar(50) NOT NULL, `email` varchar(50) NOT NULL, `telefono` varchar(50) NOT NULL, `fechaNacimiento` varchar(50) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
~~~

## Modelo
~~~
DROP TABLE IF EXISTS `modelo`;
CREATE TABLE `modelo` ( `id` int(11) NOT NULL, `nombre` varchar(50) DEFAULT NULL, `version` varchar(50) NOT NULL, `añoLanzamiento` varchar(50) NOT NULL, `id_marca` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
~~~


## Combustible
~~~
DROP TABLE IF EXISTS `combustible`;
CREATE TABLE `combustible` ( `id` int(11) NOT NULL, `nombre` varchar(50) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
~~~

## Auto
~~~
DROP TABLE IF EXISTS `auto`; CREATE TABLE `auto` ( `id` bigint(20) NOT NULL, `anioFabricacion` int(10) NOT NULL, `color` varchar(255) NOT NULL, `id_combustible` int(11) NOT NULL, `id_marca` int(11) NOT NULL, `id_modelo` int(11) NOT NULL, `precio` double NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
~~~
