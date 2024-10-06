package br.com.alura;

import br.com.alura.client.ClientHttpConfig;
import br.com.alura.service.AbrigoService;

import java.io.IOException;

public class ListarAbrigoCommand implements Command {

    @Override
    public void execute() {
        try {
            ClientHttpConfig clientHttpConfig = new ClientHttpConfig();
            AbrigoService abrigoService = new AbrigoService(clientHttpConfig);

            abrigoService.listarAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
