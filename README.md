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


En este programa se supone que los enemigos no pueden equipar armas y que además son del tipo enemigo.
No hay restricción para las armas que puede equipar cada jugador.

Los test se puede ejecutar con Test in ‘final-reality.test’ with coverage.

Lógica detrás del problema:
Se necesitan crear jugadores y enemigos además de armas, las cuales solo pueden ser equipadas por los jugadores.
Para esto por un lado trabajamos con Character, que representan a los jugadores y enemigos, estos poseen características en común que están descritas en AbstractCharacter, tales como el nombre el lugar, la cola entre otros. De esta clase padre se desprender 2 clases hijas, Enemy y PlayerCharacter (la cual es abstracta). En Enemy se encuentran métodos específicos para los enemigos, y en la PlayerCharacter están los métodos comunes a todos los jugadores tales como equipar arma (ya que aún no se implementa restricciones). Y por último PlayerCharacter tiene 5 clases hijas las cuales representan a cada tipo de jugador (Caballero, Ingeniero, Ladrón, Mago Negro y Mago Blanco) cada uno con sus características.
Por otro lado, tenemos las armas las cuales están en una clase Weapon donde están los métodos comunes para todas ellas y como clases hijas se tiene a cada arma en específico.
Además, todo esto se implementa con las interfaces ICharacter e IWeapon.
las cuales solo pueden ser equipadas los jugadores.
