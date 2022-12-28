package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Cotacao;
import model.Indice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectToJsonTest {
    private static final String JSON_ESPERADO = "{\"id\":200,\"indice\":\"IPCA\",\"dataColeta\":[2022,12,26],\"mesReferencia\":\"TESTE\",\"valor\":500000,\"dataValidade\":null}";

    private Cotacao cotacao;

    @BeforeEach
    public void preencheCotacao() {
        this.cotacao = new Cotacao();
        LocalDate data = LocalDate.of(2022, 12, 26);

        this.cotacao.setId(200L);
        this.cotacao.setDataColeta(data);
        this.cotacao.setValor(new BigDecimal(500000));
        this.cotacao.setIndice(Indice.IPCA);
        this.cotacao.setMesReferencia("TESTE");
        this.cotacao.setDataColeta(data);
    }

    @Test
    public void testConversaoDeObjectoParaJson() throws JsonProcessingException {
        String jsonConverted = new ObjectToJson().convert(this.cotacao);

        assertEquals(JSON_ESPERADO, jsonConverted);
    }
}
