package br.com.idtech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadProps {

    private static Properties properties;

    static {

        try {


            File file = new File("config/app.properties");
            FileInputStream fis = new FileInputStream(file);

            if (file.exists()) {
                properties = new Properties();
                properties.load(fis);
                fis.close();
            }

        } catch (Exception x) {
            File erro = new File("erro.ini");
            try {
                x.printStackTrace(new PrintStream(erro));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadProps.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



    public static String lerProperties(String atributo) {
        String retorno = null;
        try {
            //  File file = new File("app.properties");

            if (properties != null) {
                retorno = properties.getProperty(atributo);
            }

        } catch (Exception x) {
            x.printStackTrace();
        }

        return retorno;
    }
}