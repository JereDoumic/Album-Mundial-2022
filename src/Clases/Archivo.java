package Clases;

import Clases.Jugador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

    private static List<Object> elementos = new ArrayList<>();

    public static void escrbirArchivo() throws IOException {
        BufferedWriter file = new BufferedWriter( new FileWriter(new File("archivoo.txt")));
        try {//abro
            BufferedWriter fSalida = new BufferedWriter(new FileWriter("archivo.tex"));
            fSalida.close();
        }catch (IIOException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void leerArchivo() throws IOException {
        BufferedReader fEntrada = new BufferedReader(new FileReader(new File("archivo.txt")));

        if (!(new File("archivo.txt")).exists()) {
            return; //si existe lo retorna
        }
        try {
            String linea=null;
            while ((linea=fEntrada.readLine()) != null) {
                System.out.println(linea);
            }
            fEntrada.close();//cierra
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void agregarArchivoCualquiera() {
        //Object obj = new Object();
        // elementos.add(...);

    }

    public static void guardarElementos() {

        //Contenedor<Object> objectContenedor = new Contenedor<>(100);
        //objectContenedor.agregarElementos(new Object());
        //Contenedor<Jugador> jugadorContenedor = new Contenedor<>(30);
        // jugadorContenedor.agregarElementos(new Jugador());
    }

    public static void leerElementos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fSalida = null;

        try {
            fSalida = new BufferedWriter(new FileWriter(new File("ob.json")));

            gson.toJson(elementos, elementos.getClass(), fSalida);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if(fSalida != null) {
                try {
                    fSalida.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}