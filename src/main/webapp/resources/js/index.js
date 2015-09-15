function ejecutaLibreria(){
	require([
	 		'dojo/dom'
	 	],function(dom){
		var titulos = dom.byId("titulo");
		alert(titulos.innerHTML);
	});
}