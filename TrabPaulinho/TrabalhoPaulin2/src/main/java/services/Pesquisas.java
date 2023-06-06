package services;

import model.ContaBancaria;

public class Pesquisas {

    public static int pesquisaBinaria(int numPesq, ContaBancaria[] contas) {
        int esquerda, meio, direita;
        esquerda = 0;
        direita = contas.length - 1;

        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;
            if (numPesq == contas[meio].getN()) {
                return meio;
            }
            if (numPesq > contas[meio].getN()) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
        // Pesquisa Linear Nomes
                 //para retornar a conta
    public static ContaBancaria pesquisaLinearNome(String nome_pesquisado, ContaBancaria[] contas) {
            for(ContaBancaria conta : contas){
            if (conta.getTitular().equals(nome_pesquisado)) {
                return conta;
            }
        }
        return null;// se a conta não for encontrada
    }
    
    public static int pesquisaLinearNumeroConta(int numero_pesquisa, ContaBancaria[] contas){
        
        for (int i = 0; i < contas.length; i++) {
            if(numero_pesquisa == contas[i].getN()){
                return i;
            }
        }
        return -1;
    }

}
