# Dragolandia (RPG game)
## Tarea realizada en clase

Se guarda todo en tablas de MySQL empleando JPA cuando creamos las clases.

Es un juego basado en una partida de rol clásico de dragones y mazmorras.

### Roles propuestos
En nuestro juego el Mago tendrá el rol de combatir a los monstruos, proteger el bosque y
colaborar con el dragón.
El Monstruo amenazará a los magos dentro del bosque.
El Monstruo jefe, el cual es un monstruo especial del bosque en el que estamos jugando,
será el obstáculo principal. Será el líder de los monstruos y objetivo de los magos y del
dragón.
El bosque es el escenario principal del juego y contiene monstruos y el monstruo jefe.
El Dragón es el protector del bosque y combate a los monstruos.

### Soluciones y cambios realizados
Los cambios que he propuesto son sobre las mecánicas del juego:

He preferido añadir una pequeña probabilidad de fallar al lanzar un hechizo (20%), que hace una cantidad de daño a la vida como un método para no hacer invencible al mago.
El dragón es inmortal y sólo ataca al jefe, los monstruos intentan dañarlo pero fallan inevitablemente.
####
La lógica me resulta más satisfactoria como un sólo mago, un sólo dragón y múltiples monstruos, crea la sensación de una batalla más justa.
El mago además cuenta con unos hechizos por defecto que va usando aleatoriamente, por lo tanto la victoria o la derrota sólo depende
de las probabilidades y de los valores de daño y de vida. Por lo tanto podría desbalancearse el juego deliveradamente creando unos valores muy altos para el mago o los monstruos.

### Código realizado

Al ejecutar el programa se recoge por consola un sólo mago, un sólo monstruo y un entorno bosque para facilitar las pruebas del juego.
Los demás monstruos y el dragón se crean de manera predeterminada, pero se podrían crear por consola también. Una vez
creado el entorno empieza la batalla hasta que uno de los bandos salga ganador.