package Clases;

import com.google.gson.Gson;

import java.io.*;
import java.util.Comparator;

public class ManejoArchivos implements Serializable {
    private Gson gson = new Gson();
    private File file ;

    public ManejoArchivos(){
    }

    public void cargarCuenta(Cuenta c){
        File file = new File("cuentas.json");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            Gson gson = new Gson();
            if (buscarCuenta(c)==1){
                gson.toJson(c,Cuenta.class, bufferedWriter);
            }else{
                System.out.println("el usuario ya existe");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int buscarCuenta(Cuenta c) {
        file = new File("cuentas.json");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Cuenta cuentaGson = gson.fromJson(bufferedReader,Cuenta.class);
        if (c.compareTo(cuentaGson)==0){
            return 0;
        }else {
            return 1;
        }
    }
}
