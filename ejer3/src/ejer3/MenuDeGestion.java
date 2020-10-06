package ejer3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDeGestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; 
 
        while (!salir) {
        	System.out.println("**********************************");
            System.out.println("1. Copiar archivos");
            System.out.println("2. Crear fichero");
            System.out.println("3. Borrar fichero");
            System.out.println("4. Mostrar contenido de un fichero");
            System.out.println("5. Salir");
            System.out.println("**********************************");
            System.out.println("Elige una opción");
            
            try {
 
                
                opcion = sn.nextInt();
 
                Scanner entrada = new Scanner(System.in);
				switch (opcion) {
                    case 1:
                    	InputStream inputStream = null;
                        OutputStream outputStream = null;
                        String archivo;
                        String ruta;
                        entrada = new Scanner(System.in);
                        
                        System.out.println("Archivo que quiere copiar: ");
                        archivo = entrada.nextLine();
                        System.out.println("Ruta donde guardar el archivo con su correspondiente nombre: ");
                        ruta = entrada.nextLine();
                        try {
                            File archivoOriginal = new File(archivo);
                            File archivoCopia = new File(ruta);
                            inputStream = new FileInputStream(archivoOriginal);
                            outputStream = new FileOutputStream(archivoCopia);
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = inputStream.read(buffer)) > 0) {
                                outputStream.write(buffer, 0, length);
                            }
                            inputStream.close();
                            outputStream.close();
                            System.out.println("Archivo copiado correctamente en la ruta indicada.");
                            System.out.println("");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                        
                        
                    case 2:
                    	try {
                    		
                    		String ruta2;
                            String nombrefich;
                            entrada = new Scanner(System.in);
                            
                    		System.out.println("Archivo que quiere crear: ");
                            ruta2 = entrada.nextLine();
                            
                            System.out.println("Ruta donde lo quiere crear: ");
                            nombrefich = entrada.nextLine();
                            File file = new File(ruta2);
                            
                            FileWriter fw = new FileWriter(file);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(nombrefich);
                            bw.close();
                            System.out.println("Archivo creado correctamente en la ruta indicada.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                        
                        
                    case 3:
                    	try {
	                    	System.out.println("Ruta del archivo que quiere borrar: ");
	                        String ruta3 = entrada.nextLine();
	                   
	                    	File fichero = new File(ruta3);
	                    	
	                    	if (fichero.delete())
	                    		   System.out.println("El fichero ha sido borrado satisfactoriamente");
	                    		else
	                    		   System.out.println("El fichero no puede ser borrado");
                    	} catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    	
                    	
                    case 4:
                    	try {
                    		System.out.println("Ruta del archivo que quiere leer: ");
	                        String ruta4 = entrada.nextLine();
                    		FileReader leer = new FileReader(ruta4);
                    		BufferedReader bf = new BufferedReader(leer);
                    		
                    		String cadena= null;
                    		while((cadena = bf.readLine())!= null) {
                    			
                        		System.out.println(cadena);
                    		}
                    		
                    	} catch (Exception e) {
                            e.printStackTrace();
                        }
                    	break;
                    	
                    	
                    case 5:
                        salir = true;
                        System.out.println("Saliendo..");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
	}

}
