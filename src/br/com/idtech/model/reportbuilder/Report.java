package br.com.idtech.model.reportbuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by DOM on 06/02/2015.
 * Email - douglas.janerson@gmail.com
 */
public class Report {

    private static final String PATH = "br/com/idtech/";

    //public static final String DATA_BETWEEN  = new File(PATH+"view/report/report_between.jasper").getPath();
    public static final String DATA_BETWEEN  = Report.class
            .getResource("report_between.jasper")
            .getPath();

    public static FileInputStream getReport() throws FileNotFoundException {
        return new FileInputStream(Report.class.getResource("report_between.jasper").getFile());
    }


}

