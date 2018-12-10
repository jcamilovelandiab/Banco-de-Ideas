

﻿# Banco de Iniciativas
Periodo Académico: 2018-2
Nombre del curso: Procesos de desarrollos de software - Grupo 2

# Banco de Iniciativas
2018-2
Procesos de desarrollos de software - Grupo 2

Nombre de los integrantes:

 - Yohanna Toro Durán
 - John Ibañez Rodriguez	
 - Alejandro Naranjo Guzmán
 - Camilo Velandia Botello


Nombre del profesor: Francisco José Chaves Alonso


Roles asignados:
	
 - Francisco Chaves Alonso - ***Product Owner***
 - Alejandro Naranjo Guzmán -  ***Scrum Master***
 - Yohanna Toro Durán -   ***Scrum team member***
 - John Ibañez Rodriguez  - 	 ***Scrum team member***
 -  Camilo Velandia Botello -  ***Scrum team member***


	

# Descripción del producto

-   Descripción general.
	    La Plataforma banco de iniciativas de proyectos es una herramienta que le permite al personal académico registrar iniciativas o ideas de proyectos para ser realizados o gestionados por la PMO. Adicional a esto cada miembro de la escuela colombiana de ingeniera Julio Garavito dependiendo del rol que posea podrá hacer revisar las iniciativas que ya estén propuestas, mostrar interés por alguna de estas entre otras funcionalidades, estos roles son:
	    
				1. Administrador
				2. PMO ODI
				3. Proponente
				4. Público	    
				
	Los privilegios que tiene cada rol están organizados según la anterior lista, por lo que un usuario con un rol superior a otro puede realizar las mismas acciones y otras adicionales de mayor privilegio.
	
## Usuario público

Un usuario con el rol público puede realizar las siguientes acciones:

### Consultar todas las iniciativas
El usuario tiene la posibilidad de consultar todas las iniciativas registradas en el sistema y filtrarlas u ordenarlas según:

 - Información de la iniciativa
- Cantidad de iniciativas que desea ver (Paginación)

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/ConsultarIniciativas.PNG)

### Consultar Iniciativas por palabras claves
El usuario tiene la posibilidad de consultar todas las iniciativas según los tags que los usuarios
les asignaron cuando la registraron
![](https://github.com/YohannaToro/Banco_De_Ideas/images/ConsultarIniciativasClaves.PNG)

### Comentarios y votos
El usuario tiene la posibilidad de comentar y dar un voto a una iniciativa

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/LikesYComentariosIniciativas.PNG)

## Usuario proponente

El usuario proponente puede realizar las mismas acciones que el usuario público y adicionalmente realiza las siguientes acciones:
### Registrar iniciativa
El usuario puede registrar en el sistema su idea de proyecto.

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/RegistroIniciativas.PNG)

### Consultar iniciativas propias registradas
El usuario puede consultar las iniciativas que haya registrado en el sistema.
![](https://github.com/YohannaToro/Banco_De_Ideas/images/ConsultarIniciativasPropias.PNG)

## Usuario PMO-ODI
El usuario PMO-ODI puede realizar las mismas acciones que realiza el usuario proponente y adicionalmente realiza las siguientes acciones:


### Modificar estado de una iniciativa
El usuario puede modificar cambiar el estado actual de una iniciativa que el desee modificar, puede elegir el estado de la misma de una lista con los estados del sistema.
Estados del sistema:

 - EN ESPERA
 - EN REVISION
 - PROYECTO
 - SOLUCIONADO
 - DESECHADO

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/ModificarEstadoIniciativa.PNG)
![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/ModificarEstadoModal.PNG)




# Arquitectura y diseño detallado. 

## Modelo  E-R.

 - Capa de presentacion:
	 Se ofrece en esta capa una pagina en la cual se puede tener contacto con los datos por medio de los servicios del sistema
 - Capa logica:
 Manipula los datos y representa las base de las funciones de los servicios de la capa de presentacion
 - Capa de persistencia:
 Se almacenan los datos de los usuarios y las iniciativas, de modo que las demas capas puedan prestar sus servicios de una forma correcta

 

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/BancoDeIniciativas-2018-12-08_10_27.png)

## Modelo de clases.

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/ModeloClases.png)



## Arquitectura utilizada.

> JavaScript

> Cascading Style Sheets (CSS)

> Java8

> PostgreSQL

> PrimeFaces

> Bootstrap

> Guice

> XML, Xhtml , Html 

### Capas
 

## Herokuapp.
Enlace para el despliegue de la aplicacion.

* [BancodeIdeas](https://bancoideas.herokuapp.com/faces/index.xhtml)
* Login Administrador
  *  Usr yohanna.toro@mail.escuelaing.edu.co
  *  pass administrador123

* Login publico
  *  Usr john.ibanez@mail.escuelaing.edu.co
  *  pass publico123

* Login PMO
  *  Usr jose.naranjo@mail.escuelaing.edu.co
  *  pass POM123
* Login PROPONENTE
  *  Usr juan.velandia-b@mail.escuelaing.edu.co
  *  pass PROPONENTE123


# Descripcion del proceso.
## Metodología utilizada
## Trello
Enlace de trello para ver proceso del grupo.

* [Trello](https://trello.com/b/bK73jNjp/2018-2-proypdsw-hailyowis)

## Release-burndown
## Sprint.
### Sprint-1.
PAREJAS
 1. Ibañez y Naranjo
 2. Toro y Velandia
 3. Ibañez y Toro
 4. Velandia y Naranjo

En este sprint se enfoco la mayoria del esuerzo en el modelado y se hicieron dos parejas , una que implementara la base de datos (Pareja 1) y otra la logica de la aplicacion en Java (Pareja 2). Al final del sprint se cambiaron las parejas, una de ellas se enfoco en la parte visual de la aplicacion (Pareja 3) y la otra en la parte logica de sus funciones (Pareja 4). Esta division y cambio de parejas favorecio la programacion extrema.
![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/s1.png)

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/s1-2.png)

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/BurndownChartSprint1.png)




### Sprint-2.

Durante el inicio este sprint se mantuvieron las parejas 3 y 4 realizando las mismas funciones que en el sprint anterior, para posteriormente disolverse y trabajar todo el equipo en la parte visual.
![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/s2.png)

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/BurndownChartSprint2.png)

### Sprint-3.
En el ultimo sprint no hubo parejas fijas, se estuvo variando frecuentemente de equipo  y la mayoria del tiempo se trabajo intentando mostrar las funcionalidades en la capa de presentacion. 

![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/s3.png)
![](https://github.com/YohannaToro/Banco_De_Ideas/blob/master/images/BurndownChartSprint3.png)

## Reporte de pruebas.
[![CircleCI](https://circleci.com/gh/YohannaToro/Banco_De_Ideas.svg?style=svg)](https://circleci.com/gh/YohannaToro/Banco_De_Ideas)
