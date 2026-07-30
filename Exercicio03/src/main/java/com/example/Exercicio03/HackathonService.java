package com.example.Exercicio03;
import com.example.Exercicio03.Desenvolvedor;
import com.example.Exercicio03.Designer;
import com.example.Exercicio03.Participante;
import com.example.Exercicio03.RelatorioProcessamento;
import org.springframework.stereotype.Service;

import java.io.*;
@Service
public class HackathonService {


        public RelatorioProcessamento processarInscricoes() {

            int aprovados = 0;
            int rejeitados = 0;

            try (
                    BufferedReader br = new BufferedReader(
                            new FileReader("inscricoes_brutas.txt"));

                    BufferedWriter aprovadosWriter =
                            new BufferedWriter(
                                    new FileWriter("aprovados_hackathon.txt"));

                    BufferedWriter pendenciasWriter =
                            new BufferedWriter(
                                    new FileWriter("pendencias_inscricao.txt"));
            ) {

                String linha;

                while ((linha = br.readLine()) != null) {

                    try {

                        String[] dados = linha.split(";");

                        String tipo = dados[0];
                        String nome = dados[1];
                        int idade = Integer.parseInt(dados[2]);
                        String equipe = dados[3];

                        Participante participante;

                        if (tipo.equalsIgnoreCase("DEV")) {
                            participante = new Desenvolvedor(nome, idade, equipe);
                        } else {
                            participante = new Designer(nome, idade, equipe);
                        }

                        aprovadosWriter.write(participante.toString());
                        aprovadosWriter.newLine();

                        aprovados++;

                    } catch (Exception e) {

                        pendenciasWriter.write(linha);
                        pendenciasWriter.newLine();

                        rejeitados++;
                    }

                }

            } catch (IOException e) {

                return new RelatorioProcessamento(
                        0,
                        0,
                        "Erro ao abrir o arquivo."
                );
            }

            return new RelatorioProcessamento(
                    aprovados,
                    rejeitados,
                    "Processamento concluído com sucesso!"
            );
        }
    }

