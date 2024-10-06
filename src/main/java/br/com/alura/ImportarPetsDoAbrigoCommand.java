package br.com.alura;

import br.com.alura.client.ClientHttpConfig;
import br.com.alura.service.PetService;

import java.io.IOException;

public class ImportarPetsDoAbrigoCommand implements Command {

    @Override
    public void execute() {
        try {
            ClientHttpConfig clientHttpConfig = new ClientHttpConfig();
            PetService petService = new PetService(clientHttpConfig);

            petService.importarPets();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
