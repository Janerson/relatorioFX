package br.com.idtech.model.reportbuilder;

/**
 * Created by DOM on 06/02/2015.
 * Email - douglas.janerson@gmail.com
 */
public class Report {

    //TODO - Refatorar
    public static final String FICHA_ALUNO          = Report.class.getResource("../FichaDoAluno.jasper").getPath();
    public static final String BOLETIM              = Report.class.getResource("../boletim.jasper").getPath();
    public static final String ATESTADO_MATRICULA   = Report.class.getResource("../atestado_matricula.jasper").getPath();
    public static final String ATESTADO_VAGA        = Report.class.getResource("../atestado_vaga.jasper").getPath();
    public static final String HISTORICO_5_ANOS     = Report.class.getResource("../historico-.jasper").getPath();
    public static final String HISTORICO_8_ANOS     = Report.class.getResource("../historico8.jasper").getPath();
    public static final String HISTORICO_9_ANOS     = Report.class.getResource("../historico9.jasper").getPath();
    public static final String LISTA_DE_CHAMADA     = Report.class.getResource("../Lista_de_chamada.jasper").getPath();
    public static final String BACKGROUND_REPORT    = Report.class.getResource("../imagens/fundo.png").getPath();

}

