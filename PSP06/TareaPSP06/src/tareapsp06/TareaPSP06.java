package tareapsp06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author hugo
 */
public class TareaPSP06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Logger logger = Logger.getLogger("MiLog");
        FileHandler fh;
        try {
            fh = new FileHandler("./registro.log", true);
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.INFO);
            SimpleFormatter sf = new SimpleFormatter();
//            XMLFormatter sf = new XMLFormatter();
            fh.setFormatter(sf);
        }catch(IOException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        String entrada;
        boolean b = false;
        Pattern usuario = Pattern.compile("[a-z]{8}");
        Pattern archivo = Pattern.compile("\\w{1,8}[.][a-z]{3}");
        Matcher matcher;
        File fichero;
        
        //****************Introduccion del nombre de usuario*******************
        System.out.println("Introduce tu nombre de usuario (8 letras minusculas)");
        entrada = scanner.nextLine();
        matcher = usuario.matcher(entrada);
        while(!(matcher.matches())){
            //Mensaje log
            logger.log(Level.WARNING, "El usuario ha introducido un nombre NO valido");
            
            System.err.println("Recuerda que el nombre de usuario solo puede estar formado por 8 letras minusculas");
            entrada = scanner.nextLine();
            matcher = usuario.matcher(entrada);
        }
        
        //Mensaje log
        logger.log(Level.INFO, "El usuario ha introducido un nombre correcto");
        
        System.out.println("==========================================");
        System.out.println("Hola "+ entrada + ", has ingresado correctamente");
        System.out.println("==========================================\n");
        //*****************************************************************
        
        
        //*******************Solicitar nombre de fichero*******************
        System.out.println("Introduce el nombre del fichero que deseas mostrar");
        do{
            entrada = scanner.nextLine();
            matcher = archivo.matcher(entrada);
            while(!(matcher.matches())){
                //Mensaje log
                logger.log(Level.WARNING, "El usuario ha introducido un nombre NO valido");
            
                System.err.println("El nombre del fichero puede tener 8 caracteres max. Ejemplo 'aaaaaaaa.bbb'");
                System.out.println("Prueba de nuevo");
                entrada = scanner.nextLine();
                matcher = archivo.matcher(entrada);
            }
            fichero = new File(entrada);
            if(fichero.exists()){
                b = true;
                //Mensaje log
                logger.log(Level.INFO, "El usuario ha introducido un nombre de archivo correcto");
        
                Path path = Paths.get(entrada);
                try(Stream<String> stream = Files.lines(path)){
                    stream.forEach(System.out::println);
                } catch(IOException e){
                    e.printStackTrace();                    
                    System.err.println("No se ha podido abrir el archivo");
                }
            } else{
                //Mensaje log
                logger.log(Level.WARNING, "El archivo no existe en el sistema");
                System.err.println("El archivo indicado no existe en el sistema");
                System.out.println("Prueba de nuevo");
            }
        }while(!b);
    }
    
}
