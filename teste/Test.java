import br.com.idtech.model.dao.SenhasDAO;
import br.com.idtech.model.entity.Senha;

import java.time.LocalDate;
import java.util.*;

import static br.com.idtech.util.AppUtil.toDate;

public class Test {

    public static void main(String[] args) {
        SenhasDAO dao = new SenhasDAO();

        LocalDate datein = LocalDate.of(2016,11,25);
        LocalDate datefim = LocalDate.of(2016,11,27);

        List<Senha> senhas = dao.getAllPassBetween(toDate(datein),toDate(datefim));
        Set<String> usuarios = new LinkedHashSet<>();
        Map<String,Long> senhasPorServico = new HashMap<>();


       /* senhas.forEach( s -> usuarios.add(s.getUsuarioId().getNome()));
        usuarios.forEach(s ->{
            long count = senhas.stream()
                    .filter(p -> p.getServicoId().getDescricao().equalsIgnoreCase(s))
                    .count();
            senhasPorServico.put(s,count);
        });*/

       senhas.forEach( s ->{
           System.out.println("User: "+s.getUsuarioId().getNome());
       });



        System.out.println("Total senhas emitidas por usuarios: "+senhasPorServico);
        System.exit(0);
    }


}