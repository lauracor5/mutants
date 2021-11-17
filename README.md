# mutants
_Proyecto que se encarga de detectar si un humano es mutante basandose en su secuencia de ADN._

## Comenzando 🚀
_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._


### Pre-requisitos 📋
_Maven,_
_JDK 11,_
_docker -  docker-compose,_
_Postman_


### Instalación 🔧
###1.Ejecución Local_
__git clone --branch develop https://github.com/lauracor5/mutants.git__

#### Nivel 1
#### Instrucciones Ejecución En consola Consola

```
cd mutantsN1
mvn clean install
cd target
java -jar mutantsN1-1.0-SNAPSHOT.jar
```
_Al ejecutar el programa en java por favor ingresar la información de manera correcta, que el programa ira  pidiendo por consola:_
```
Enter the length of the table => solo acepta núemros (ejemplo 6)
```
_si no se ingresa un valor, el programa vuelve a pedir un valor valido, esta longitud, será el número de filas y columnas que tendrá nuestra tabla, despues de ingresar este valor se pedirá la información por filas del adn que se va analizar_

```
Enter the row values 0 Allowed values (A, T, C, G, C) =>Deacuerdo a la longitud ingresada será el numero ce caracteres que se reciben por filas, si se ingresa un valor no permitido, se volveran a pedir los datos de la fila
```
_al finalizar el analisis del ADN se entregara una respuesta true o false, esta esta se imprimirá en la consola_

#### Nivel 2 - Nievl3
#### Instrucciones Ejecución Api rest en docker
```
cd ms-mutantsN2
mvn -DskipTests clean install
cd..
cd ms -ms-mutantsN3
cd..
docker-compose build
docker-compose up
```
##### Nivel 2
_El nivel 2 es la api con el nombre mutants2, esta se deplegará en el puerto asignado 8001 para consumir esta api se puede realizar por un cliente ejemplo Postman_
_Esta Api cuenta con un servicio  de tipo Post url "http://localhost:8001/mutant" que es el encargado de entrgar la respuesta si el adn ingresado por postman pertence a un mutante o un humano, se debe enviar como request un json de la siguiente manera_
```
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"]

}
```

_Si el ADN enviado pertenece a un mutante el servicio http respone com un ok 200_
_Si el ADN enviado pertenece a un humano el servicio http respone com un FORBIDEN 403_
_Si el ADN enviado tiene algun caracter no permitido el servicio http respone com un BAD REQUEST 400_

##### Nivel 3
_El nivel 2 es la api con el nombre mutants3, esta se deplegará en el puerto asignado 8002, ademas cuenta con una conexión a una base de datos con mysql, para el despliegue en docker se actival el perfil de desarrollo y se conecta a la base de datos que se despliega en docker para consumir esta api se puede realizar por un cliente ejemplo Postman_
_Esta Api cuenta con dos servicios:

```
Post url: "http://localhost:8002/mutant"
```
_servicio encargado de entrgar la respuesta si el adn ingresado por el cliente http pertence a un mutante o un humano, se debe enviar como request un json de la siguiente manera_
```
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"]

}
```
_Si el ADN enviado pertenece a un mutante el servicio http respone com un ok 200_
_Si el ADN enviado pertenece a un humano el servicio http respone com un FORBIDEN 403_
_Si el ADN enviado tiene algun caracter no permitido el servicio http respone com un BAD REQUEST 400_

```
Get url: "http://localhost:8002/stats"
```
_este servicio nos ofrece las estadisiticas cuantos humanos y mutantes se han detectado analizando su adn, este respondera con un json de la siguiente manera_
```
{
    "count_human_dna": 0,
    "count_mutant_dna": 1,
    "ratio": null
}
```

###1.Ejecución producción_
##### Nivel 3
_Se activa el perfil prod ya que este nos da la coenxión a una instancia de una base de datos en mysql, es un servicio que se ofrece en Google App Engine, para el consumo se debe realizar de la siguiente manera_
```
Post url: https://mutantsspringgcpn3.rj.r.appspot.com/mutant
```
_ se envia como request de la siguiente manera_
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"]

}
_Si el ADN enviado pertenece a un mutante el servicio http respone com un ok 200_
_Si el ADN enviado pertenece a un humano el servicio http respone com un FORBIDEN 403_
_Si el ADN enviado tiene algun caracter no permitido el servicio http respone com un BAD REQUEST 400_
```
Get url: "https://mutantsspringgcpn3.rj.r.appspot.com/stats"
```
_" este servicio nos ofrece las estadisiticas cuantos humanos y mutantes se han detectado analizando su adn, este respondera con un json de la siguiente manera_
```
{
    "count_human_dna": 0,
    "count_mutant_dna": 1,
    "ratio": null
}
```
##  pruebas

_Para las pruebas unitarias se utilizó: Junit5, mockito_
_covertura de codigo Api rest :  herramienta utilizada  ide Intellij idea para covertura de codigo_
_Se anexan reporte por cada prueba unitaria en el repositorio_
_Nievl1 carpeta reporteTest - Nivel1- archivo: index.html_
_Nievl2 carpeta reporteTest - Nivel2- archivo: index.html_
_Nievl3 carpeta reporteTest - Nivel3- archivo: index.html_

## Despliegue 📦

_El despliegue a producción se realizo en un cloud computing libre Google App Engine_
_Intancia utilizada F2_
_runtime: java11_
_desplegamos gcloud app deploy_


## Construido con 🛠️

_Nievel 1: Java jdk 11, maven_
_Nievel 2: Java jdk 11, Framework Spring boot, maven_
_Nievel 3: Java jdk 11, Framework Spring boot, base de datos mysql, maven_



## Documentacion 📖

Puedes encontrar mucho más de cómo utilizar este proyecto con nuestra documentación [Documentación swagger](https://mutantsspringgcpn3.rj.r.appspot.com/swagger-ui/)

## Autores ✒️

* **Laura Córdoba* - *Trabajo Inicial* - [lauracor5](https://github.com/lauracor5)


## Expresiones de Gratitud 🎁

* Gracias por el tiempo para ver mi proyecto 🤓.














