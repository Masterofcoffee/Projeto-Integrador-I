
import java.util.Scanner;

public class PIYury {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);

        int selecao = 0;

        do {
            System.out.println("\tBem-vindo. Escolha o processo que deseja realizar: ");
            System.out.println("1. Codificar/Decodificar Cifra de C�sar");
            System.out.println("2. Convers�o de Decimal/Bin�rio/Hexadecimal");
            System.out.println("Selecione:\n");
            selecao = input.nextInt();

            switch (selecao) {
                case 1:
                    codec();
                    break;
                case 2:
                    conv();
                    break;
                default:
                    System.err.println("Entrada inv�lida.");
            }
        } while (selecao != 0);

    }

    public static void codec() {

        Scanner input = new Scanner(System.in);

        int selecao = 0;

        do {
            System.out.println("\tVoc� entrou no menu interativo para codificar e decodificar! Selecione:");
            System.out.println("1. Codificar/Decodificar Cifra de C�sar (TXT)");
            System.out.println("2. Codificar/Decodificar Cifra de C�sar");
            System.out.println("3. Voltar para o menu anterior");
            System.out.println("4. Sair do programa");
            selecao = input.nextInt();

            switch (selecao) {
                case 1:
                    codectxt();
                    break;
                case 2:
                    codecin();
                    break;
                case 3:
                    menu();
                    break;
                case 4:
                    System.out.println("Adeus!");
                    System.exit(0);
                default:
                    System.err.println("Entrada inv�lida.");
            }

        } while (selecao != 0);
    }

    public static void codectxt() {

        Scanner input = new Scanner(System.in);

        int selecao = 0;

        do {
            System.out.println("\tSelecione se deseja codificar ou decodificar o texto do arquivo .txt:");
            System.out.println("1. Codificar(TXT)");
            System.out.println("2. Decodificar(TXT)");
            System.out.println("3. Voltar para o menu anterior");
            System.out.println("4. Sair do programa");
            selecao = input.nextInt();

            switch (selecao) {
                case 1:
                    codtxt();
                    break;
                case 2:

                    break;
                case 3:
                    codec();
                    break;
                case 4:
                    System.out.println("Adeus!");
                    System.exit(0);
                default:
                    System.err.println("Entrada inv�lida.");
            }

        } while (selecao != 0);

    }

    public static void codecin() {

        Scanner input = new Scanner(System.in);

        int selecao = 0;

        do {
            System.out.println("\tSelecione se deseja codificar ou decodificar o texto:");
            System.out.println("1. Codificar");
            System.out.println("2. Decodificar");
            System.out.println("3. Voltar para o menu anterior");
            System.out.println("4. Sair do programa");
            selecao = input.nextInt();

            switch (selecao) {
                case 1:
                    cod();
                    break;
                case 2:
                    dec();
                    break;
                case 3:
                    codec();
                    break;
                case 4:
                    System.out.println("Adeus!");
                    System.exit(0);
                default:
                    System.err.println("Entrada inv�lida.");
            }

        } while (selecao != 0);

    }

    public static void codtxt() {

        Scanner input = new Scanner(System.in);

        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        int k = 0;
        StringBuilder resultado = new StringBuilder();

        System.out.println("Insira o caminho do arquivo txt:");
        String original = input.nextLine();
        System.out.println("Insira o n�mero de deslocamento:");
        k = input.nextInt();

        for (char ch : original.toLowerCase().toCharArray()) {
            if (ch == ' ') {
                resultado.append(' ');
                continue;
            }
            int chr = ch - alfabeto.charAt(0);
            chr = (chr + k) % alfabeto.length();
            if (chr < 0) {
                chr += alfabeto.length();
            }
            chr += alfabeto.charAt(0);
            resultado.append((char) chr);
        }

        System.out.println(resultado.toString());

    }

    public static void cod() {

        Scanner input = new Scanner(System.in);

        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        // Alfabeto
        int k = 0;
        // shift
        StringBuilder resultado = new StringBuilder();
        // String mut�vel

        System.out.println("Insira o texto:");
        String original = input.nextLine();
        // Texto a ser cifrado
        System.out.println("Insira o n�mero de deslocamento:");
        k = input.nextInt();
        // Shift

        // for each para cada caracter da string ORIGINAL
        for (char ch : original.toCharArray()) {
            // se um dos caracteres inseridos pelo usu�rio for espa�o, CONCATENA um espa�o no SYSOUT
            if (ch == ' ') {
                resultado.append(' ');
                continue;
            } else if (ch == '?') {
                resultado.append('?');
                continue;
            } else if (ch == '!') {
                resultado.append('!');
                continue;
            }

            int chr = ch - alfabeto.charAt(0);
            chr = (chr + k) % alfabeto.length();
            if (chr < 0) {
                chr += alfabeto.length();
            }
            chr += alfabeto.charAt(0);

            resultado.append((char) chr);
        }

        System.out.println(resultado.toString());

    }

    public static void dec() {

        Scanner input = new Scanner(System.in);

        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        int k = 0;
        StringBuilder resultado = new StringBuilder();

        System.out.println("Insira o texto:");
        String original = input.nextLine();
        System.out.println("Insira o n�mero de deslocamento:");
        k = input.nextInt();

        for (char ch : original.toLowerCase().toCharArray()) {
            if (ch == ' ') {
                resultado.append(' ');
                continue;
            } else if (ch == '?') {
                resultado.append('?');
                continue;
            } else if (ch == '!') {
                resultado.append('!');
                continue;
            }
            int chr = ch - alfabeto.charAt(0);
            chr = (chr - k) % alfabeto.length();
            if (chr < 0) {
                chr += alfabeto.length();
            }
            chr += alfabeto.charAt(0);
            resultado.append((char) chr);
        }

        System.out.println(resultado.toString());

    }

    public static void conv() {

        Scanner input = new Scanner(System.in);

        int selecao = 0;

        do {
            System.out.println(
                    "\tVoc� entrou no menu interativo para converter n�meros decimais/bin�rios/hexadecimais, escolha:");
            System.out.println("1. Bin�rio ---> Decimal");
            System.out.println("2. Bin�rio ---> Hexadecimal");
            System.out.println("3. Decimal ---> Bin�rio");
            System.out.println("4. Decimal ---> Hexadecimal");
            System.out.println("5. Hexadecimal ---> Decimal");
            System.out.println("6. Hexadecimal ---> Bin�rio");
            System.out.println("7. Voltar ao menu anterior");
            System.out.println("8. Sair do programa");
            selecao = input.nextInt();

            switch (selecao) {
                case 1:
                    System.out.println("Insira o valor (bin�rio) para converter para decimal:");
                    String n1 = input.next();
                    int potencia = 0,
                     binPDecimal = 0;
                    for (int i = n1.length() - 1; i >= 0; i--) {
                        binPDecimal += Math.pow(2, potencia) * Character.getNumericValue(n1.charAt(i));
                        potencia++;
                    }
                    System.out.println(n1 + "(bin�rio) em decimal �: " + binPDecimal);
                    break;
                case 2:
                    System.out.println("Insira o valor (bin�rio) para converter para hexadecimal:");
                    String n2 = input.next();
                    int potenciahex = 0,
                     decimal = 0;
                    for (int i = n2.length() - 1; i >= 0; i--) {
                        decimal += Math.pow(2, potenciahex) * Character.getNumericValue(n2.charAt(i));
                        potenciahex++;
                    }

                    String digitos = "123456789ABCDEF",
                     binPHex = "";
                    int base = 16;

                    while (decimal > 0) {
                        int digito = decimal % base;
                        binPHex = digitos.charAt(digito) + binPHex;
                        decimal = decimal / base;
                    }
                    System.out.println(n2 + "(bin�rio) em hexadecimal �: " + binPHex);

                    break;
                case 3:
                    System.out.println("Insira o valor (decimal) para converter para bin�rio:");
                    int n3 = input.nextInt();
                    StringBuilder binario = new StringBuilder(); // guarda os dados
                    while (n3 > 0) {
                        int b = n3 % 2;
                        binario.append(b);
                        n3 = n3 / 2;
                    }
                    System.out.println(binario.reverse().toString()); // inverte a ordem e imprime
                    break;
                case 4:
                    char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                    String hexa = "";
                    String digitoshexa = "0123456789ABCDEF";
                    System.out.println("Insira o valor (decimal) para converter para hexadecimal:");
                    int num4 = input.nextInt();
                    int n4 = 0;
                    while (num4 > 0) {
                        n4 = num4 % 16;
                        hexa = hex[n4] + hexa;
                        num4 = num4 / 16;
                    }
                    System.out.println(hexa);
                    //String decPHex = Integer.toHexString(n4);
                    //System.out.println(n4 + "\t (decimal) em hexadecimal �: " + decPHex);
                    break;
                case 5:
                    String digitoshex2dec = "0123456789ABCDEF", hexadecimal = "";
                    System.out.println("Insira o valor (hexadecimal) para converter para decimal");
                    hexadecimal = input.next();
                    hexadecimal = hexadecimal.toUpperCase();
                    int val = 0;
                    
                    break;
                case 6:
                    System.out.println("Insira o valor (hexadecimal) para converter para bin�rio:");
                    String n6 = input.next();
                    int i = Integer.parseInt(n6, 16);
                    String hexPBin = Integer.toBinaryString(i);
                    System.out.println(n6 + "(hexadecimal) para bin�rio � " + hexPBin);
                    break;
                case 7:
                    menu();
                    break;
                case 8:
                    System.out.println("Adeus");
                    System.exit(0);

                default:
                    System.err.println("Entrada inv�lida.");
            }

        } while (selecao
                != 0);
    }

}
