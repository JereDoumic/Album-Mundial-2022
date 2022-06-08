package Clases;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class ManejoArchivos<T> {
    private Gson gson = new Gson();
    private File file = new File("Archi.json");
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;


    public ManejoArchivos() {
    }


    public void crearArchivo() {
        this.file = new File("Archi.json");
    }

    public void cargarListaDeCuentasAarchivo(LinkedList<Object> obj) {
        if (!file.exists()) {
            System.out.println("se puedo Crear");
            crearArchivo();
        }

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            gson.toJson(obj, obj.getClass(), bufferedWriter);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }


    public LinkedList<Cuenta> leerArchivosAlista() {
        LinkedList<Cuenta> cuentas = new LinkedList<>();
        if (!file.exists()) {
            crearArchivo();
            System.out.println("Ingrese nuevamente");
        }else{
            Type type = new TypeToken<LinkedList<Cuenta>>() {}.getType();
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    cuentas = gson.fromJson(bufferedReader, type);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return cuentas;
    }

    public void mostrarLista(LinkedList<Cuenta> list) {
        for (Object p : list) {
            if (p instanceof Cuenta) {
                System.out.println(p);
            }
        }
    }

    public boolean buscarCuenta(Cuenta c) {
        LinkedList<Cuenta> listCuentas = new LinkedList<>();
        listCuentas = leerArchivosAlista();

        for (Object p: listCuentas) {
            if (p instanceof Cuenta){
                if (c.equals(p)){
                    return true;
                }
            }
        }
        return false;
    }

    public File getFile() {
        return file;
    }
}
