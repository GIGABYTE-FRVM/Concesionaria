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

