import br.com.vpereira.dao.ContratoDAO;
import br.com.vpereira.dao.IContratoDAO;
import br.com.vpereira.service.ContratoService;
import br.com.vpereira.service.IContratoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContratoDAOTest {

    @Test
    public void salvar() {
        IContratoDAO dao = new ContratoDAO();
        String res = dao.salvar();
        Assertions.assertEquals("Salvo", res);
    }

    @Test
    public void buscar() {
        IContratoDAO dao = new ContratoDAO();
        Boolean res = dao.buscar();
        Assertions.assertEquals(true, res);
    }

    @Test
    public void excluir() {
        IContratoDAO dao = new ContratoDAO();
        Boolean res = dao.excluir();
        Assertions.assertEquals(false, res);
    }

    @Test
    public void atualizar() {
        IContratoDAO dao = new ContratoDAO();
        String res = dao.atualizar();
        Assertions.assertEquals("Atualizado", res);
    }
}
