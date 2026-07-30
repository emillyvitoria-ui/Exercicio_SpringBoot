package com.example.Exercicio03;

    public class RelatorioProcessamento {

        private int quantidadeAprovados;
        private int quantidadeRejeitados;
        private String status;

        public RelatorioProcessamento() {
        }

        public RelatorioProcessamento(int aprovados, int rejeitados, String status) {
            this.quantidadeAprovados = aprovados;
            this.quantidadeRejeitados = rejeitados;
            this.status = status;
        }

        public int getQuantidadeAprovados() {
            return quantidadeAprovados;
        }

        public void setQuantidadeAprovados(int quantidadeAprovados) {
            this.quantidadeAprovados = quantidadeAprovados;
        }

        public int getQuantidadeRejeitados() {
            return quantidadeRejeitados;
        }

        public void setQuantidadeRejeitados(int quantidadeRejeitados) {
            this.quantidadeRejeitados = quantidadeRejeitados;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

