package Clases;

import com.google.gson.Gson;

import java.io.*;
import java.util.Comparator;

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

}
