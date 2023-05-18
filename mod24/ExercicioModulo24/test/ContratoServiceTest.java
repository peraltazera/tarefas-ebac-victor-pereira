import br.com.vpereira.dao.ContratoDAO;
import br.com.vpereira.service.ContratoService;
import br.com.vpereira.service.IContratoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContratoServiceTest {

    @Test
    public void salvar() {
        IContratoService service = new ContratoService(new ContratoDAO());
        String res = service.salvar();
        Assertions.assertEquals("Salvo", res);
    }

    @Test
    public void buscar() {
        IContratoService service = new ContratoService(new ContratoDAO());
        Boolean res = service.buscar();
        Assertions.assertEquals(true, res);
    }

    @Test
    public void excluir() {
        IContratoService service = new ContratoService(new ContratoDAO());
        Boolean res = service.excluir();
        Assertions.assertEquals(false, res);
    }

    @Test
    public void atualizar() {
        IContratoService service = new ContratoService(new ContratoDAO());
        String res = service.atualizar();
        Assertions.assertEquals("Atualizado", res);
    }
}
