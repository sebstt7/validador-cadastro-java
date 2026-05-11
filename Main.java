import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        exibirInstrucoes();

        String resultado = cadastro(sc);
        System.out.println(resultado);

        String idFinal = nome(sc);
        System.out.println("ID Gerado: " + idFinal);

        nascimento(sc);
        cpfs(sc);
        String cursoS = escola(sc);
        System.out.println("Hashtag do curso: " + cursoS);
        sc.close();
    }

    public static void exibirInstrucoes() {
        System.out.println("==========================================");
        System.out.println("       SISTEMA DE CADASTRO ACADÊMICO       ");
        System.out.println("==========================================");
        System.out.println("Para prosseguir, siga as regras abaixo:");
        System.out.println("1. E-MAIL: Deve terminar com '@empresa.com.br'.");
        System.out.println("2. SENHA: Mínimo 8 caracteres, deve conter (@, * ou $)");
        System.out.println("   e não pode iniciar com 'senha' ou terminar com '1234'.");
        System.out.println("3. MATRÍCULA: Deve conter exatamente 8 dígitos.");
        System.out.println("4. DATA: Use o formato dd/mm/aaaa.");
        System.out.println("5. CPF: Digite apenas os 11 números (sem pontos).");
        System.out.println("6. CURSO: Comece com # (ex: #Sistemas).");
        System.out.println("==========================================\n");
    }

    public static String cadastro(Scanner sc) {
        String usuario, verificao = "";
        boolean emailValido = false, senhaValida = false;

        System.out.println("== CADASTRO ACADÊMICO ==");
        do {
            System.out.print("Digite seu email: ");
            usuario = sc.nextLine().toLowerCase();

            if (!usuario.contains("@")) {
                System.out.println("Erro: O email não possui @");
            } else if (!usuario.endsWith("@empresa.com.br")) {
                System.out.println("Erro: Deve terminar com @empresa.com.br");
            } else {
                verificao = usuario.substring(0, usuario.indexOf("@"));
                if (verificao.length() < 3) {
                    System.out.println("Erro: Nome de usuário muito curto.");
                } else {
                    emailValido = true;
                    System.out.println("Usuário cadastrado!");
                }
            }
        } while (!emailValido);

        do {
            System.out.print("Crie uma senha: ");
            String senha = sc.nextLine();
            if (senha.length() < 8) {
                System.out.println("Erro: Mínimo 8 caracteres.");
            } else if (senha.toLowerCase().startsWith("senha")) {
                System.out.println("Erro: Não pode começar com 'senha'.");
            } else if (senha.endsWith("1234")) { // Adicionei essa verificação que estava no seu menu!
                System.out.println("Erro: A senha não pode terminar com '1234'.");
            } else if (!senha.contains("@") && !senha.contains("*") && !senha.contains("$")) {
                System.out.println("Erro: Use ao menos um especial (@, *, $)");
            } else {
                senhaValida = true;
                System.out.println("Senha aceita!");
            }
        } while (!senhaValida);

        return "Cadastro de " + usuario + " finalizado!";
    }

    public static String nome(Scanner sc) {
        System.out.print("Digite seu nome completo: ");
        String nomeCompleto = sc.nextLine().toUpperCase().trim();

        char primeira = nomeCompleto.charAt(0);
        int indiceEspaco = nomeCompleto.indexOf(" ");
        char ultima = (indiceEspaco != -1) ? nomeCompleto.charAt(indiceEspaco + 1) : '?';

        System.out.println("Iniciais: " + primeira + ". " + ultima + ".");

        String matricula;
        boolean matriculaValida = false;
        do {
            System.out.print("Matrícula (8 dígitos): ");
            matricula = sc.nextLine();
            if (matricula.length() == 8) {
                matriculaValida = true;
            } else {
                System.out.println("Erro: Deve ter 8 números.");
            }
        } while (!matriculaValida);

        return gerarId(nomeCompleto, matricula);
    }

    public static String gerarId(String nome, String mat) {
        return nome.substring(0, 3) + mat.substring(4, 8);
    }

    public static void nascimento(Scanner sc) {
        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String data = sc.nextLine();

        int diaNasc = Integer.parseInt(data.substring(0, 2));
        int mesNasc = Integer.parseInt(data.substring(3, 5));
        int anoNasc = Integer.parseInt(data.substring(6, 10));

        int diaRef = 11, mesRef = 5, anoRef = 2026;

        long totalNasc = (anoNasc * 360L) + (mesNasc * 30L) + diaNasc;
        long totalRef = (anoRef * 360L) + (mesRef * 30L) + diaRef;
        long diff = totalRef - totalNasc;

        System.out.println("Idade: " + (diff / 360) + " anos.");
    }

    public static void cpfs(Scanner sc) {
        boolean cpfValido = false;
        do {
            System.out.print("CPF (11 números): ");
            String cpf = sc.nextLine();
            if (cpf.length() == 11) {
                cpfValido = true;
                System.out.printf("Formatado: %s.%s.%s-%s\n",
                        cpf.substring(0, 3), cpf.substring(3, 6),
                        cpf.substring(6, 9), cpf.substring(9, 11));
            } else {
                System.out.println("Erro: Digite 11 números.");
            }
        } while (!cpfValido);
    }

    public static String escola(Scanner sc) {
        System.out.print("Seu curso: ");
        String curso = sc.nextLine().toLowerCase().replace(" ", "");
        return curso.startsWith("#") ? curso : "#" + curso;
    }
}