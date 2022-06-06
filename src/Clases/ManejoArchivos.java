package Clases;

import com.google.gson.Gson;

import java.io.*;
import java.util.Comparator;

public class ManejoArchivos implements Serializable {

    public ManejoArchivos(){
    }

    public void cargarCuenta(Object obj){
        File file = new File("cuentas.json");
        Gson gson = new Gson();

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            gson.toJson(obj,obj.getClass(), bufferedWriter);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void buscarCuenta(Cuenta c) {
        File file = new File("cuentas.json");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void leerArchivo(){
        File file = new File("cuentas.json");
        Gson gson = new Gson();

        try {
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new FileReader(file));
            Object objFromGson = gson.fromJson(bufferedReader,Cuenta.class);
            System.out.println(objFromGson);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
