/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package traborde.trabalhoordenacao;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Nathan Graebin
 */
public class TrabalhoOrdenaPesquisa {

    public static Scanner Ler = new Scanner(System.in);
    public static int valorPesquisado;
    public static int posicaoNoVetor;
    public static int resultadoDaPesquisa;
    public static String numerosNaoOrdenados;

    public static void main(String[] args) {

        int tamanhoVetor;

        int opcao = -1;
        System.out.println("INFORME O TAMANHO DO VETOR");
        tamanhoVetor = Ler.nextInt();

        int vetor[] = new int[tamanhoVetor];
        

        while (opcao != 0) {
            System.out.println("=============MENU=============");
            System.out.println("[1] ORDENAR VETOR - INSERÇÃO");
            System.out.println("[2] ORDENAR VETOR - SELEÇÃO");
            System.out.println("[3] ORDENAR VETOR - BOLHA");
            System.out.println("==============================");
            System.out.println("[4] PESQUISA - LINEAR");
            System.out.println("[5] PESQUISA - BINARIA");
            System.out.println("==============================");
            System.out.println("[6] MOSTRAR VETOR NÃO ORDENADO");
            System.out.println("[0] SAIR");
            System.out.println("==============================");
            opcao = Ler.nextInt();
            switch (opcao) {
                case 1 ->
                    ordenaInsercao(vetor);
                case 2 ->
                    ordenaSelecao(vetor);

                case 3 ->
                    ordenaBolha(vetor);
                case 4 ->
                    iniciadorPesquisaLinear(vetor);
                case 5 ->
                    iniciarPesquisaBinaria(vetor);
                case 6 -> System.out.println(numerosNaoOrdenados);                   
                case 0 -> 
                    opcao = 0;
                default -> {
                }

            }

        }
    }

    public static void ordenaInsercao(int vetor[]) {
        long inicio = System.currentTimeMillis();
        Random NumertoAleatorio = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = NumertoAleatorio.nextInt(1000000);
        }
        System.out.println("NUMEROS NÃO ORDENADOS");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
            numerosNaoOrdenados += vetor[i]+ "\n";
        }
        int j;

        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            for (j = i - 1; (j >= 0 && vetor[j] > chave); j--) {
                vetor[j + 1] = vetor[j];
            }
            
            vetor[j + 1] = chave;
        }
        
        
        System.out.println("=========================");
        System.out.println("SEU VETOR FOI ORDENADO ");
        System.out.println("VETOR DEPOIS DA ORDENAÇÃO");
        for (int i = 0; i < vetor.length - 1; i++) {
            System.out.println(vetor[i]);
        }
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        System.out.println("TEMPO DE EXECUÇÃO: " + tempoExecucao);
        System.out.println("TEMPO DE EXECUÇÃO: " + (fim - inicio) / 1000 + " SEGUNDOS");
    }

    public static void ordenaSelecao(int vetor[]) {
        long inicio = System.currentTimeMillis();
        Random NumertoAleatorio = new Random();
        

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = NumertoAleatorio.nextInt(10000000);

        }
        System.out.println("NUMEROS NÃO ORDENADOS");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);

        }
      

        for (int i = 0; i < vetor.length - 1; i++) {

            int posicaoMenor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[posicaoMenor]) {
                    posicaoMenor = j;
                }
            }
            if (posicaoMenor != i) {
                int aux = vetor[i];
                vetor[i] = vetor[posicaoMenor];
                vetor[posicaoMenor] = aux;
            }
        }
        System.out.println("=========================");
        System.out.println("SEU VETOR FOI ORDENADO ");
        System.out.println("VETOR DEPOIS DA ORDENAÇÃO");
        for (int i = 0; i < vetor.length - 1; i++) {
            System.out.println(vetor[i]);
        }

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("TEMPO DE EXECUÇÃO: " + tempoExecucao + "ms");
        System.out.println("TEMPO DE EXECUÇÃO: " + (fim - inicio) / 1000 + " SEGUNDOS");
    }

    public static void ordenaBolha(int vetor[]) {
        long inicio = System.currentTimeMillis();
        Random NumertoAleatorio = new Random();
        numerosNaoOrdenados = "";

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = NumertoAleatorio.nextInt(1000000);

        }
        System.out.println("NUMEROS NÃO ORDENADOS");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);

        }

        boolean houveTroca = true;
        while (houveTroca) {
            houveTroca = false;

            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;

                    houveTroca = true;

                }
            }

        }
        System.out.println("=========================");
        System.out.println("SEU VETOR FOI ORDENADO ");
        System.out.println("VETOR DEPOIS DA ORDENAÇÃO");
        for (int i = 0; i < vetor.length - 1; i++) {
            System.out.println(vetor[i]);
        }

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("TEMPO DE EXECUÇÃO: " + tempoExecucao);
        System.out.println("TEMPO DE EXECUÇÃO: " + (fim - inicio) / 1000 + " SEGUNDOS");

    }

    public static void iniciadorPesquisaLinear(int[] vetor) {

        System.out.println("======PESQUISA LINEAR=====");
        System.out.println("INFORME UM NÚMERO PARA PESQUISAR: ");
        valorPesquisado = Ler.nextInt();

        long inicio = System.currentTimeMillis();

        resultadoDaPesquisa = pesquisaLinear(valorPesquisado, vetor);

        if (resultadoDaPesquisa >= 0) {
            System.out.println("====================================");
            System.out.println("O NÚMERO " + valorPesquisado + " foi encontrado.");
            System.out.println("POSIÇÃO " + resultadoDaPesquisa);
        } else {
            System.out.println("O NÚMERO " + valorPesquisado + " NÃO FOI ENCONTRADO.");
        }

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("TEMPO DE EXECUÇÃO: " + tempoExecucao + "MS");
        System.out.println("TEMPO DE EXECUÇÃO: " + (fim - inicio) / 1000 + " SEGUNDOS");
    }

    public static void iniciarPesquisaBinaria(int[] vetor) {

        System.out.println("======PESQUISA BINARIA=====");
        System.out.println("INFORME UM NÚMERO PARA PESQUISAR: ");
        valorPesquisado = Ler.nextInt();

        long inicio = System.currentTimeMillis();
        resultadoDaPesquisa = pesquisaBinaria(valorPesquisado, vetor);

        if (resultadoDaPesquisa >= 0) {
            System.out.println("====================================");
            System.out.println("O NÚMERO " + valorPesquisado + " foi encontrado.");
            System.out.println("Posição " + resultadoDaPesquisa);
        } else {
            System.out.println("O NÚMERO " + valorPesquisado + " NÃO FOI ENCONTRADO.");
        }
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("TEMPO DE EXECUÇÃO: " + tempoExecucao + "MS");
        System.out.println("TEMPO DE EXECUÇÃO: " + (fim - inicio) / 1000 + " SEGUNDOS");

    }

    public static int pesquisaLinear(int valor, int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            if (valor == vetor[i]) {
                return i;
            }

        }

        return -1;
    }

    public static int pesquisaBinaria(int valor, int[] vetor) {
        int esquerda = 0, meio;
        int direita = vetor.length - 1;

        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;
            if (valor == vetor[meio]) {
                return meio;
            }
            if (valor > vetor[meio]) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }

        }

        return -1;
    }
    
    
}
