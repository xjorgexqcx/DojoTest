<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Tutorial: Hello Dojo!</title>
</head>
<body>
    <!-- load Dojo -->
    <script src="//ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js"
                data-dojo-config="async: true"> </script>
    <script>
    require(["dojo/on", "dojo/domReady!"], function(on) {
        on(document, "keyup", function(event) {
            document.getElementById("keyCode").value = event.keyCode;
        });
    });
    </script>
    <h1>Press any key</h1>
    keyCode value: <input type="text" id="keyCode" size="2">
</body>
</body>
</html>