# PROF-2023-Ejercicio3-datos
## pluginTestSmell
Este es el código que desarrolla el plugin que llama a la herramienta **tsDetect tool**. Para ejecutarlo, el plugin necesita que le pasen una seríe de parámetros. Los parámetros son los siguientes:
- mainPaths es la variable en la que se incluyen las rutas a los ficheros sources que quieres testear. Se pueden pasar varias rutas, separadas por una ','.
- testPaths es la variable en la que se incluyen las rutas a los ficheros test que quieres comprobar si tienen test smells. Se pueden pasar varias rutas, separadas por una ','.
- projectName es el nombre que le vas a poner al proyecto que quieres testear.
- csvName es el nombre que vas a poner al fichero csv que pasas como parámetro a la herramienta **tsDetect tool**.
- jarPath es la ruta donde está la herramienta descargada.
- exitPath es la ruta donde quieres que se genere el fichero csv de salida con los test smells de los ficheros test pasados en testPaths.

Para ejecutarlo en mvn se podría hacer de la siguiente manera
`mvn com.github.carloslopllo:pluginTestSmell:1.0:pluginTestSmell -DmainPaths= -DtestPaths= -DprojectName= -DcsvName= -DcsvDirectory= -DjarPath= -DexitPath=` escribiendo rutas tras los '='.
