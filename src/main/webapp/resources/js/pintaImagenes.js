var canvas = document.getElementById("mundo");
var ctx = canvas.getContext("2d");
var naruto,sakura;
var teclasNaruto=[37,38,39,32,40];
var teclasSakura=[65,87,68,83,67];
var posicion_Inicial_Naruto = {	
		x:140,
		y:180,
		url:'resources/sprites/naruto/narutoDerecha.png'
};
var posicion_Inicial_Sakura = {	
		x:310,
		y:180,
		url:'resources/sprites/sakura/sakuraStand.gif'
};

function pintadoInicial() {
	pintarFondo();
	pintaNaruto();
	pintaSakura();
	asignaActividad();
}
function pintadoConstante(){
	pintarFondo();
	pintaNaruto();
	pintaSakura();
}
function pintarFondo(){
	var img = new Image();
	img.src = "resources/sprites/fondo.png";
	img.onload = function() {
		ctx.drawImage(img, 0,0);
	}
}
function pintaNaruto(){
	var img = new Image();
	img.src = posicion_Inicial_Naruto["url"];
	img.onload = function() {
		ctx.drawImage(img, posicion_Inicial_Naruto["x"], posicion_Inicial_Naruto["y"]);
	}
	return img;
}
function pintaSakura(){
	var img = new Image();
	img.src = posicion_Inicial_Sakura["url"];
	img.onload = function() {
		ctx.drawImage(img, posicion_Inicial_Sakura["x"], posicion_Inicial_Sakura["y"]);
	}
	return img;
}
function asignaActividad(){
	require(["dojo/on", "dojo/keys"], function(on,keys) {
	    on(document, "keydown", function(event) {
	    	var tecla = event.keyCode;
	    	for(var movimiento in teclasNaruto){
	    		if(teclasNaruto[movimiento] == tecla){
	    			mueveNaruto(tecla);
	    			break;
	    		}
	    	}
	    });
	});
}

function mueveNaruto(orientacion){
	if(orientacion == 32){
		posicion_Inicial_Naruto["url"] = 'resources/sprites/naruto/transformar.png'; 
		pintadoConstante();
	}else{
		if(orientacion == 37){
			posicion_Inicial_Naruto["x"] = posicion_Inicial_Naruto["x"]-10;
			posicion_Inicial_Naruto["url"] = 'resources/sprites/naruto/narutoIzquierda.png';
		}else if(orientacion == 38){
			posicion_Inicial_Naruto["y"] = posicion_Inicial_Naruto["y"]-10;
		}else if(orientacion == 39){
			posicion_Inicial_Naruto["x"] = posicion_Inicial_Naruto["x"]+10;
			posicion_Inicial_Naruto["url"] = 'resources/sprites/naruto/narutoDerecha.png';
		}else if(orientacion == 40){
			posicion_Inicial_Naruto["y"] = posicion_Inicial_Naruto["y"]+10;
		}
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		pintadoConstante();
	}
}
