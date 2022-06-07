package Clases;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class ManejoArchivos implements Serializable {
    private Gson gson = new Gson();
    private File file = new File("cuentas.json");
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;


    public ManejoArchivos() {
    }

    public void cargarCuenta(Object obj) {
        File file = new File("cuentas.json");
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


    public Cuenta leerArchivo() {
        Cuenta objFromGson = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            objFromGson = gson.fromJson(bufferedReader, Cuenta.class);
            System.out.println(objFromGson);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return objFromGson;
    }

    public boolean buscarCuenta(Cuenta c) {
        Cuenta aux = new Cuenta();

        while (file.canRead()) {

            try {
                bufferedReader = new BufferedReader(new FileReader(file));

            aux = gson.fromJson(bufferedReader, Cuenta.class);
            System.out.println(aux);
            if (c.equals(aux)) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                return true;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return false;
    }

    public List<Cuenta> cargarListaCuenta(String rutaArchivo, Class<Cuenta> listaCuenta){
        File file = new File(rutaArchivo);
        LinkedList<Cuenta> cuentas = new LinkedList<>();

        Type tipoDeCollection = TypeToken.getParameterized(LinkedList.class,listaCuenta).getType();

        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                cuentas=gson.fromJson(bufferedReader,tipoDeCollection);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return cuentas;

    }

    public boolean buscarCuentaEnLL(Cuenta c){
        Class<Cuenta> classCuentas = null;
        LinkedList<Cuenta> listCuentas = new LinkedList<>();
        listCuentas = (LinkedList<Cuenta>) cargarListaCuenta("cuentas.json",classCuentas);
        for (Cuenta cc: listCuentas) {
            if (c.equals(cc)){
                return true;
            }
        }
        return false;
    }

}
