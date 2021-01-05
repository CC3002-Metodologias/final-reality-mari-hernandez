Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

Para correr este juego se debe abrir el archivo en intellij, ir a la carpeta gui y correr finalreality.main().Ademas, debe disponer de internet para poder visualizar las imágenes del juego.

Aparecerá una pantalla de inicio con 2 botones, uno para ir a ver las instrucciones, y el otro para ir a la selección de jugadores para el juego.

En la selección de jugadores, debe elegir 3 jugadores a los cuales les debe asignar un nombre, esta escena tiene un botón para continuar, si no ha creado 3 jugadores el juego no continuará.

Luego de iniciado el juego, puede ir al inventario para cambiar el arma del personaje que está jugando actualmente, en caso de escoger un arma que ese tipo de personaje no puede equipar, se mantendrá el arma anteriormente equipada. Las armas que puede equipar cada tipo están en las instrucciones del juego.
En la pantalla aparecerá de quien es el turno, para terminar su turno debe atacar a un enemigo, para ello debe apretar algun botón que diga Attack y el nombre del enemigo.

No hay indicador de que se ha acabado el juego, pero cuando todos los personajes de un equipo tienen vida 0, se asume el fin del juego.


En este programa existen 2 tipos de personajes, players y enemys.

Los enemys son controlados por el computador, estos no pueden equipar armas.

Los players pueden equipar armas dependiendo de su tipo:
Caballero: Espada, Hacha y Cuchillo
Ingeniero: Hacha y Arco
Ladrón: Espada, Bastón y Arco
M. Negro: Cuchillo y Bastón
M. Blanco: Bastón
Y pueden tener 1 arma a la vez.

Existe un inventario sin límite de espacio, en el cual se guardan las armas de los players.

Los players se agrupan en una party, la cual contiene 3 players.
El juego no comienza si es que no hay 3 players.

Los enemigos se juntan en una Enemies party la cual tiene como máximo 5 enemys y como mínimo 2.

Los test se puede ejecutar con Test in ‘final-reality.test’ with coverage.

Lógica detrás del problema:
Se crean jugadores y enemigos, los primeros pueden equipar armas usando double dispatch, los ataques entre personajes 
también se implementan usando double dispatch.

Existe un controller el cual es un intermediario entre usuario y los objetos del modelo.
El controller es capaz de crear y asignar objetos pertenecientes al modelo, saber cuáles son los personajes del jugador,
tener conocimiento de los enemigos y sus datos, manejar el inventario, equipar una arma y hacer que se ataquen.

Además se puede saber inmediatamente cuando un jugador muere o cuando termina una partida por medio del patrón de diseño 
observer pattern.

También se utiliza el patrón de diseño State pattern, para la toma de turnos.Los estados funcionan de la siguiente forma:
1.	Start State: aquí comienza el juego, se ponen en fila la party del juagor y la enemies party
2.	Begin Turn State: si existe alguien en la cola, lo sacamos y será su turno de jugar.
3.	Selecting State: en este momento el jugador puede cambiar el arma y escoger a quien quiere atacar, y si es el enemigo el que juega debe escoger a quien atacar(Lo cual es aleatorio).
4.	Attacking State: aquí se efectúa el ataque, de este estado puede pasar a 3 estados distintos. Si no queda ningún enemigo vivo pasamos al Players Win State. Si no queda ningún jugador vivo pasamos al Enemies Win State. Y si no es ninguno de esos casos pasamos a End Turn State.
5.	En Turn State: aquí volvemos a ingresar a la cola al personaje. En caso de haber otros ICharacters en la cola, le toca el siguiente(Vuelve al punto 2). En caso contrario hay un observer esperando a que alguien entre a la cola y así poder iniciar otro turno(Volver al punto 2).

Todos los dibujos en este juego fueron dibujados por mí.







