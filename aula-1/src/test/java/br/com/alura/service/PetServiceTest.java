package br.com.alura.service;

import br.com.alura.client.ClientHttpConfig;
import br.com.alura.domain.Abrigo;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    private ClientHttpConfig clienteHttpConfig = mock(ClientHttpConfig.class);
    PetService petService = new PetService(clienteHttpConfig);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private Abrigo abrigo = new Abrigo("Teste", "123456789", "abrigo_alura");


    @Test
    public void deveVerificarSeDispararRequisicaoPostSeraChamado() throws IOException, InterruptedException {
        String userInput = String.format("Teste%spets.csv",
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        when(clienteHttpConfig.dispararRequisicaoPost(anyString(), any())).thenReturn(response);

        petService.importarPets();
        verify(clienteHttpConfig.dispararRequisicaoPost(anyString(), anyString()), atLeast(1));
    }

}
