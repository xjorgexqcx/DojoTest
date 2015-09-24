// Nuestras variables
var canvas, ctx, img, x, y, step, direction;
var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
img = document.getElementById('img');

// La posición x inicial, variara con cada paso
x = 0;
// La posición y inicial, quedará estatica
y = 25;

// Numerador de paso, lo usaremos para saber que frame dibujar
step = 0;

// Direccion, 1 derecha, -1 izquierda, 9 arriba, -9 abajo
direction = 1;
var tecla=37;
require([ "dojo/on", "dojo/keys" ], function(on, keys) {
	on(document, "keydown", function(event) {
		tecla = event.keyCode;
		if (tecla == 37) {
			direction = -1;
		} else {
			if (tecla == 39) {
				direction = 1;
			}
		}
		if (x <= canvas.width - 32 && tecla ==39) {
			dibujar();
		}
		if(x >= 0 && tecla ==37){
			dibujar();
		}
	});
});
function dibujar(){
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	// Dibujamos el frame adecuado en la posicion correspondiente
	ctx.drawImage(img,(step++ % 4) * 32,[ 52, 0, 104 ][direction + 1],32,52,x,y,32,52);

	// Avance, indistinto de la direccion
	x += 5 * direction; 
}




