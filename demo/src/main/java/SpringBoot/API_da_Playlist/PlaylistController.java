package SpringBoot.API_da_Playlist;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private final String ARQUIVO = "src/main/resources/minha_playlist.txt";

    @GetMapping("/listar")
    public List<Musica> listar() {

        List<Musica> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                Musica musica = new Musica(
                        dados[0],
                        dados[1],
                        dados[2]
                );

                lista.add(musica);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @PostMapping("/adicionar")
    public String adicionar(@RequestBody Musica musica) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true))) {

            bw.newLine();
            bw.write(musica.getTitulo() + ";"
                    + musica.getArtista() + ";"
                    + musica.getAlbum());

            return "Música salva com sucesso!";

        } catch (IOException e) {
            return "Erro ao salvar.";
        }
    }

}


