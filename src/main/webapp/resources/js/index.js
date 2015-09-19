require([ "dojo/_base/xhr", 'dojo/dom' ], function(xhr, dom) {
	xhr.post({
		url : "posiciones",
		handleAs : "json",
		load : function(jsonData) {
			var objeto = dom.byId("info");
			objeto.innerHTML = JSON.stringify(jsonData) + "<br/>";
			for(x in jsonData) {
				objeto.innerHTML += "<br/>Nombres  : " + jsonData[x].nombre;
				objeto.innerHTML += "<br/>Apellidos: " + jsonData[x].apellidos;
				objeto.innerHTML += "<br/>Cargo: " + jsonData[x].cargo;
				objeto.innerHTML += "<br/>--------------------------";
			}
		},
		error : function() {
			console.log("No se pudo acceder al servidor");
		}
	});
});