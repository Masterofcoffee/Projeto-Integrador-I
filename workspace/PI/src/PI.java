import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PI {
	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Scanner input = new Scanner(System.in, "utf-8");
		int selecao = 0;
		do {
			System.out.println("\tBem-vindo. Escolha o processo que deseja realizar: ");
			System.out.println("1. CIFRAR ou DECIFRAR uma frase em Cifra de César");
			System.out.println("2. Conversão de Decimal/Binário/Hexadecimal");
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
				System.err.println("Entrada inválida.");
			}
		} while (selecao != 0);
	}

	public static void codec() {
		Scanner input = new Scanner(System.in, "utf-8");
		int selecao = 0;
		do {
			System.out.println("\tVocê entrou no menu interativo para CIFRAR e DECIFRAR! Selecione:");
			System.out.println("1. CIFRAR ou DECIFRAR a Cifra em arquivo TXT");
			System.out.println("2. CIFRAR ou DECIFRAR a Cifra no console.");
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
				System.err.println("Entrada inválida.");
			}
		} while (selecao != 0);
	}

	public static void codectxt() {
		Scanner input = new Scanner(System.in, "utf-8");
		int selecao = 0;
		do {
			System.out.println("\tSelecione se deseja codificar ou decodificar o texto do arquivo .txt:");
			System.out.println("1. CIFRAR(TXT)");
			System.out.println("2. DECIFRAR(TXT)");
			System.out.println("3. Voltar para o menu anterior");
			System.out.println("4. Sair do programa");
			selecao = input.nextInt();

			switch (selecao) {
			case 1:
				codtxt();
				break;
			case 2:
				dectxt();
				break;
			case 3:
				codec();
				break;
			case 4:
				System.out.println("Adeus!");
				System.exit(0);
			default:
				System.err.println("Entrada inválida.");
			}
		} while (selecao != 0);
	}

	public static void codecin() {
		Scanner input = new Scanner(System.in, "utf-8");
		int selecao = 0;
		do {
			System.out.println("\tSelecione se deseja codificar ou decodificar o texto:");
			System.out.println("1. CIFRAR (CONSOLE)");
			System.out.println("2. DECIFRAR (CONSOLE)");
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
				System.err.println("Entrada inválida.");
			}
		} while (selecao != 0);
	}

	public static void codtxt() {
		Scanner input = new Scanner(System.in, "utf-8");
		int totalm, totalM, menosM, menosm, letraCifradaASCII;
		System.out.println("Insira o caminho do arquivo txt para CIFRAR seu conteúdo: ");
		String caminho = input.nextLine();
		System.out.println("Informe a chave: ");
		int k = input.nextInt();

		try {
			try (FileReader arq = new FileReader(caminho)) {
				BufferedReader lerArquivo = new BufferedReader(arq);
				String linha = lerArquivo.readLine();
				for (int i = 0; i < linha.length(); i++) {

					if ((int) linha.charAt(i) >= 97 && (int) linha.charAt(i) <= 122) {
						if ((int) linha.charAt(i) + k > 122) {
							totalm = (linha.charAt(i) + k);
							menosm = totalm - 122;
							letraCifradaASCII = 96 + menosm;
							System.out.print((char) (letraCifradaASCII));
						} else {
							letraCifradaASCII = (int) (linha.charAt(i) + k);
							System.out.print((char) (letraCifradaASCII));
						}
					} else {
						letraCifradaASCII = (linha.charAt(i));
						System.out.print((char) (letraCifradaASCII));
					}

				}
				System.out.println("\n");
				linha = lerArquivo.readLine();
			}
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: " + caminho + "\n", e.getMessage());
		}
	}

	public static void dectxt() {
		Scanner input = new Scanner(System.in, "utf-8");
		int totalm, totalM, menosM, menosm, letraCifradaASCII;
		System.out.println("Insira o caminho do arquivo txt para DECIFRAR seu conteúdo: ");
		String caminho = input.nextLine();
		System.out.println("Informe a chave: ");
		int k = input.nextInt();

		try {
			try (FileReader arq = new FileReader(caminho)) {
				BufferedReader lerArquivo = new BufferedReader(arq);
				String linha = lerArquivo.readLine();
				for (int i = 0; i < linha.length(); i++) {

					if ((int) linha.charAt(i) >= 97 && (int) linha.charAt(i) <= 122) {
						if ((int) linha.charAt(i) - k < 97) {
							totalm = (linha.charAt(i) - k);
							menosm = totalm + 122;
							letraCifradaASCII = menosm - 96;
							System.out.print((char) (letraCifradaASCII));
						} else {
							letraCifradaASCII = (int) (linha.charAt(i) - k);
							System.out.print((char) (letraCifradaASCII));
						}
					} else {
						letraCifradaASCII = (linha.charAt(i));
						System.out.print((char) (letraCifradaASCII));
					}

				}
				System.out.println("\n");
				linha = lerArquivo.readLine();
			}
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: " + caminho + "\n", e.getMessage());
		}
	}

	public static void cod() {
		int totalm, totalM, menosM, menosm, letraCifradaASCII;

		Scanner input = new Scanner(System.in);

		System.out.println("Informe a mensagem a ser CIFRADA:");
		String texto = input.nextLine();
		System.out.println("Informe a chave: ");
		int k = input.nextInt();

		for (int i = 0; i < texto.length(); i++) {

			if ((int) texto.charAt(i) >= 97 && (int) texto.charAt(i) <= 122) {
				if ((int) texto.charAt(i) + k > 122) {
					totalm = (texto.charAt(i) + k);
					menosm = totalm - 122;
					letraCifradaASCII = 96 + menosm;
					System.out.print((char) (letraCifradaASCII));
				} else {
					letraCifradaASCII = (int) (texto.charAt(i) + k);
					System.out.print((char) (letraCifradaASCII));
				}
			} else {
				letraCifradaASCII = (texto.charAt(i));
				System.out.print((char) (letraCifradaASCII));
			}
		}
		
	}

	public static void dec() {
		int totalm, totalM, menosM, menosm, letraCifradaASCII;
		Scanner input = new Scanner(System.in, "utf-8");
		System.out.println("Informe a mensagem a ser DECIFRADA:");
		String texto = input.nextLine();
		System.out.println("Informe a chave: ");
		int k = input.nextInt();
		for (int i = 0; i < texto.length(); i++) {

			// Letras minusculas
			if ((int) texto.charAt(i) >= 97 && (int) texto.charAt(i) <= 122) {
				if ((int) texto.charAt(i) - k < 97) {
					totalm = (texto.charAt(i) - k);
					menosm = totalm + 122;
					letraCifradaASCII = menosm - 96;
					System.out.print((char) (letraCifradaASCII));
				} else {
					letraCifradaASCII = (int) (texto.charAt(i) - k);
					System.out.print((char) (letraCifradaASCII));
				}
			} else {
				letraCifradaASCII = (texto.charAt(i));
				System.out.print((char) (letraCifradaASCII));
			}
		}
		System.out.println("\n");
	}

	public static void conv() {
		Scanner input = new Scanner(System.in, "utf-8");
		int selecao = 0;
		do {
			System.out.println("Informe a base:");
			System.out.println("1. BINÁRIA (2)");
			System.out.println("2. DECIMAL (9)");
			System.out.println("3. HEXADECIMAL (16)");
			System.out.println("4. Voltar para o menu anterior");
			System.out.println("5. Sair do programa");
			selecao = input.nextInt();

			switch (selecao) {
			case 1:
				System.out.println("Insira o valor a ser convertido:");
				String nB = input.next();
				int nB2 = Integer.parseInt(nB);
				int potencia = 0, binPDecimal = 0, aux = 0;
				for (int i = nB.length() - 1; i >= 0; i--) {
					binPDecimal += Math.pow(2, potencia) * Character.getNumericValue(nB.charAt(i));
					potencia++;
				}
				int nDecimalBin = binPDecimal;
				char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
				String binPHex = "";
				aux = 0;
				while (nDecimalBin > 0) {
					aux = nDecimalBin % 16;
					binPHex = hex[aux] + binPHex;
					nDecimalBin = nDecimalBin / 16;
				}
				System.out.printf("BINÁRIO: %s\nDECIMAL: %d\nHEXADECIMAL: %s", nB, binPDecimal, binPHex);
				System.out.println("");
				break;
			case 2:
				int nD, nD2, nD3;
				System.out.println("Insira o valor a ser convertido:");
				nD = input.nextInt();
				nD2 = nD;
				nD3 = nD;
				StringBuilder binario = new StringBuilder();
				while (nD > 0) {
					int b = nD % 2;
					binario.append(b);
					nD = nD / 2;
				}
				char hexD[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
				String hexa = "";
				int auxD = 0;
				while (nD3 > 0) {
					auxD = nD3 % 16;
					hexa = hexD[auxD] + hexa;
					nD3 = nD3 / 16;
				}
				System.out.printf("BINÁRIO: %s\nDECIMAL: %d\nHEXADECIMAL: %s", binario.reverse().toString(), nD2, hexa);
				System.out.println("");
				break;
			case 3:
				String digitoshex2dec = "0123456789ABCDEF";
				System.out.println("Insira o valor a ser convertido:");
				String nH = input.next();
				int hexPDec = Integer.parseInt(nH, 16);
				int i = Integer.parseInt(nH, 16);
				String hexPBin = Integer.toBinaryString(i);
				System.out.printf("BINÁRIO: %s\nDECIMAL: %d\nHEXADECIMAL: %s", hexPBin, hexPDec, nH);
				System.out.println("");
				break;
			case 4:
				menu();
				break;
			case 5:
				System.out.println("Adeus");
				System.exit(0);
			default:
				System.err.println("Entrada inválida.");
			}
		} while (selecao != 0);
	}
}
