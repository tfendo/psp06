# Tarea para PSP06

## Ejercicio 1

Para realizar este primer ejercicio primero desarrollé los patrones que han de validar las entradas del usuario, creando bucles para volver a pedir otra entrada en caso de que el usuario introduzca datos erroneos. También he ido insertando instrucciones que van introduciendo entradas en un archivo log según se vaya ejecutando la aplicación.

Debido a las restricciones impuestas a través del patrón para el nombre del archivo, he forzado por código a que el programa ya busque por defecto el nombre del archivo introducido por el usuario en el directorio **`C:/datos`**.

Para comprobar el funcionamiento del programa lo ejecuté desde una terminal del sistema y el resultado se puede comprobar a continuación:

![Captura Lenguajes](/Users/HugoGuillin/Desktop/TareaPSP01/Actividad_2/Capturas/Captura4.png) 


## Ejercicio 2

Para realizar este segundo ejercicio lo primero que he hecho ha sido firmar digitalmente la aplicación para poder utilizarla con el Security Manager activado. Los pasos realizados se pueden observar en la siguiente captura:

![Captura Lenguajes](/Users/HugoGuillin/Desktop/TareaPSP01/Actividad_2/Capturas/Captura4.png) 

A continuación he abierto la utilidad **`policytool`** con permisos de administrador para poder realizar cambios en el archivo **`java.policy`**. He especificado la ruta del almacén de claves y he creado las entradas de política necesarias para poder ejecutar la aplicación firmada con el Security Manager activado.

En la siguiente captura se puede apreciar el funcionamiento de la aplicación antes y después de dar permiso para leer el directorio **`C:/datos`**.

![Captura Lenguajes](/Users/HugoGuillin/Desktop/TareaPSP01/Actividad_2/Capturas/Captura4.png) 

Y por último presento la captura de las entradas añadidas al archivo **`java.policy`** para que la aplicación funcione tal y como se pide:

![Captura Lenguajes](/Users/HugoGuillin/Desktop/TareaPSP01/Actividad_2/Capturas/Captura4.png) 