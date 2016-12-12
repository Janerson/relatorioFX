package br.com.idtech.model.reportbuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by DOM on 06/02/2015.
 * Email - douglas.janerson@gmail.com
 */
public class Report {

   private InputStream relJasper ;

    public Report(String path) {
        relJasper = getClass().getResourceAsStream(path);
    }

    public Report() {
    }

    public InputStream getRelJasper() {
        return relJasper;
    }
    public  InputStream getReportImage(String path) {
        InputStream is= null;
        try {
            is = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return is;
    }
}

