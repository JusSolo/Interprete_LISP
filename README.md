# Interprete_LISP

## miembros del grupo:
- Juan Luis Solórzano, carnet: 201598
- Carlos Villagrán,    carnet: 22264
- Jorge Palacios,      carnet: 231385

## Primera face:
[Ver doc con la investicgación](https://docs.google.com/document/d/1gnTj-BvUHW2ATFoACNjD3tx1tIwkDdJFa-MMkx-zV0s/edit?usp=sharing)

## Nota importante:
En la rama master esta todo el código

# Algunas peculiaridades importantes a tomar en cuenta de la Sintaxis de esta implementacion de LISP
## Cadenas de caracteres (String)
Para que el interprete endienda la cadena es indispensable que las comillas (") tengan un espacio despues de la apertura (" ) y antes de el final de la cadena ( "). Como se muesta en los ejemplos abajo
### ejemplo 1:
- String invalido: "Hello world!"
- String válido:   " Hello world "
### ejemplo 2:
- String inválido: "Alan Turin ya estba loco o la lógica lo enloquecio?"
- String válido:   " Alan Turin ya estba loco o la lógica lo enloquecio? "

## Comando Cond
En Lisp es monado cond es una lista de condiciones. Sin embargo para nuestro Código es un if{} else{} combinado. Esto se debe a una mala interpretacion de el comando cond de nuestra parte. Sin embargo para nuestros fines de correr fibonacci y factorial como funciones recursivas esta diferencia no establece un problema. 
### Ejemplo:



