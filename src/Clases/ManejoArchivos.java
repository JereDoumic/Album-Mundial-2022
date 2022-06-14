package Clases;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ManejoArchivos<T> {
    private Gson gson = new Gson();
    private File file = new File("Archi.json");
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;


    public ManejoArchivos() {
    }


    public void crearArchivo() {
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void cargarListaDeCuentasAarchivo(LinkedList<Object> obj) {
        crearArchivo();
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


    public void archivoTemporal(Cuenta cu){
        File temp = new File("temporal.json");
        Gson gson = new Gson();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter (new FileWriter(temp));
            //temp.createNewFile();
            gson.toJson(cu,Cuenta.class,bw);
            temp.deleteOnExit();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }




    public LinkedList<Cuenta> leerArchivosAlista() {
        LinkedList<Cuenta> cuentas = new LinkedList<>();
        if (!file.exists()) {
            crearArchivo();
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
        LinkedList<Cuenta> listCuentas;
        listCuentas = leerArchivosAlista();

        for (Object p: listCuentas) {
            if (p instanceof Cuenta){
                if (Objects.equals(((Cuenta) p).getUsuario(), c.getUsuario()) && Objects.equals(((Cuenta) p).getPassword(), c.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean buscarCuentaParaRegistro(Cuenta c){
        LinkedList<Cuenta> listCuentas;
        listCuentas = leerArchivosAlista();

        for (Cuenta lc: listCuentas){
            if (Objects.equals(lc.getDni(), c.getDni())){
                return true;
            }
            if (Objects.equals(lc.getUsuario(), c.getUsuario())){
                return true;
            }
        }
        return false;
    }


    public File getFile() {
        return file;
    }
}