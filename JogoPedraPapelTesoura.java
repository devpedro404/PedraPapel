import java.util.Random;
import java.util.Scanner;

public class JogoPedraPapelTesoura {
    
    private static final int PEDRA = 1;
    private static final int PAPEL = 2;
    private static final int TESOURA = 3;
    
    private static int vitoriasJogador = 0;
    private static int vitoriasComputador = 0;
    private static int empates = 0;
    private static int totalJogadas = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continuarJogando = true;
        
        System.out.println("======================================");
        System.out.println("   BEM-VINDO AO PEDRA, PAPEL E TESOURA");
        System.out.println("======================================\n");
        
        while (continuarJogando) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Jogar");
            System.out.println("2 - Ver Placar");
            System.out.println("3 - Zerar Placar");
            System.out.println("4 - Sair do Jogo");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    jogarPartida(scanner, random);
                    break;
                case 2:
                    exibirPlacar();
                    break;
                case 3:
                    zerarPlacar();
                    break;
                case 4:
                    continuarJogando = false;
                    System.out.println("\nObrigado por jogar! Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        scanner.close();
    }
    
    private static void jogarPartida(Scanner scanner, Random random) {
        System.out.println("\n--- Nova Rodada ---");
        System.out.println("Escolha sua jogada:");
        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");
        System.out.print("Sua escolha: ");
        
        int escolhaJogador = scanner.next(); // <--- LINHA DO ERRO
        
        if (escolhaJogador < 1 || escolhaJogador > 3) {
            System.out.println("Escolha inválida! Tente novamente.");
            return;
        }
        
        int escolhaComputador = random.nextInt(3) + 1;
        
        System.out.println("\nVocê escolheu: " + getNomeOpcao(escolhaJogador));
        System.out.println("Computador escolheu: " + getNomeOpcao(escolhaComputador));
        
        int resultado = determinarVencedor(escolhaJogador, escolhaComputador);
        
        if (resultado == 0) {
            System.out.println("\n*** EMPATE! ***");
            empates++;
        } else if (resultado == 1) {
            System.out.println("\n*** VOCÊ VENCEU! *** 🎉");
            vitoriasJogador++;
        } else {
            System.out.println("\n*** COMPUTADOR VENCEU! *** 🤖");
            vitoriasComputador++;
        }
        totalJogadas++;
    }
    
    private static int determinarVencedor(int jogador, int computador) {
        
        if (jogador == computador) {
            return 0;  
        }
        
        if ((jogador == PEDRA && computador == TESOURA) ||
            (jogador == PAPEL && computador == PEDRA) ||
            (jogador == TESOURA && computador == PAPEL)) {
            return 1; 
        } else {
            return 2;
        }
    }
    
    private static String getNomeOpcao(int opcao) {
        switch (opcao) {
            case PEDRA:
                return "Pedra 🪨";
            case PAPEL:
                return "Papel 📄";
            case TESOURA:
                return "Tesoura ✂️";
            default:
                return "Desconhecido";
        }
    }
    
    private static void exibirPlacar() {
        System.out.println("\n========== PLACAR ==========");
        System.out.println("Jogador: " + vitoriasJogador + " vitórias");
        System.out.println("Computador: " + vitoriasComputador + " vitórias");
        System.out.println("Empates: " + empates);
        System.out.println("Total de partidas: " + totalJogadas);
        
        if (totalJogadas > 0) {
            double taxaVitoria = (double) vitoriasJogador / totalJogadas * 100;
            System.out.printf("Taxa de vitórias: %.1f%%\n", taxaVitoria);
        }
        System.out.println("=============================");
    }
    
    private static void zerarPlacar() {
        vitoriasJogador = 0;
        vitoriasComputador = 0;
        empates = 0;
        totalJogadas = 0;
        System.out.println("\nPlacar zerado com sucesso!");
    }
}