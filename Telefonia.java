import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Telefonia {
    private List<PrePago> prePagos;
    private int numPrePagos;
    private List<PosPago> posPagos;
    private int numPosPagos;
    
    public Telefonia() {
        this.prePagos = new ArrayList<>();
        this.numPrePagos = 0;
        this.posPagos = new ArrayList<>();
        this.numPosPagos = 0;
    }
    
    public void cadastrarAssinante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipo de assinante (1-PrePago, 2-PosPago): ");
        int tipo = scanner.nextInt();
        
        System.out.println("CPF: ");
        long cpf = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.println("Numero: ");
        int numero = scanner.nextInt();
        
        if (tipo == 1) {
            prePagos.add(new PrePago(cpf, nome, numero));
            numPrePagos++;
        } else if (tipo == 2) {
            System.out.println("Assinatura: ");
            float assinatura = scanner.nextFloat();
            posPagos.add(new PosPago(cpf, nome, numero, assinatura));
            numPosPagos++;
        } else {
            System.out.println("Tipo invalido.");
        }
    }
    
    public void listarAssinantes() {
        System.out.println("Assinantes Pre-Pagos:");
        for (PrePago prePago : prePagos) {
            System.out.println(prePago);
        }
        
        System.out.println("Assinantes Pos-Pagos:");
        for (PosPago posPago : posPagos) {
            System.out.println(posPago);
        }
    }
    
    public void fazerChamada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipo de assinante (1-PrePago, 2-PosPago): ");
        int tipo = scanner.nextInt();
        
        System.out.println("CPF: ");
        long cpf = scanner.nextLong();
        
        Assinante assinante = null;
        if (tipo == 1) {
            assinante = localizarPrePago(cpf);
        } else if (tipo == 2) {
            assinante = localizarPosPago(cpf);
        }
        
        if (assinante != null) {
            System.out.println("Data (dd/MM/yyyy): ");
            String dataStr = scanner.next();
            Date data = new Date(); // parsear a dataStr para Date
            
            System.out.println("Duracao (minutos): ");
            int duracao = scanner.nextInt();
            
            if (assinante instanceof PrePago) {
                ((PrePago) assinante).fazerChamada(data, duracao);
            } else if (assinante instanceof PosPago) {
                ((PosPago) assinante).fazerChamada(data, duracao);
            }
        } else {
            System.out.println("Assinante nao encontrado.");
        }
    }
    
    public void fazerRecarga() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CPF: ");
        long cpf = scanner.nextLong();
        
        PrePago assinante = localizarPrePago(cpf);
        
        if (assinante != null) {
            System.out.println("Data (dd/MM/yyyy): ");
            String dataStr = scanner.next();
            Date data = new Date(); // parsear a dataStr para Date
            
            System.out.println("Valor: ");
            float valor = scanner.nextFloat();
            
            assinante.recarregar(data, valor);
        } else {
            System.out.println("Assinante nao encontrado.");
        }
    }
    
    public PrePago localizarPrePago(long cpf) {
        for (PrePago prePago : prePagos) {
            if (prePago.getCpf() == cpf) {
                return prePago;
            }
        }
        return null;
    }
    
    public PosPago localizarPosPago(long cpf) {
        for (PosPago posPago : posPagos) {
            if (posPago.getCpf() == cpf) {
                return posPago;
            }
        }
        return null;
    }
    
    public void imprimirFaturas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mes (1-12): ");
        int mes = scanner.nextInt();
        
        System.out.println("Faturas Pre-Pagos:");
        for (PrePago prePago : prePagos) {
            prePago.imprimirFatura(mes);
        }
        
        System.out.println("Faturas Pos-Pagos:");
        for (PosPago posPago : posPagos) {
            posPago.imprimirFatura(mes);
        }
    }
    
    public static void main(String[] args) {
        Telefonia telefonia = new Telefonia();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar assinante");
            System.out.println("2. Listar assinantes");
            System.out.println("3. Fazer chamada");
            System.out.println("4. Fazer recarga");
            System.out.println("5. Imprimir faturas");
            System.out.println("6. Sair");
            
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    telefonia.cadastrarAssinante();
                    break;
                case 2:
                    telefonia.listarAssinantes();
                    break;
                case 3:
                    telefonia.fazerChamada();
                    break;
                case 4:
                    telefonia.fazerRecarga();
                    break;
                case 5:
                    telefonia.imprimirFaturas();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção invalida.");
            }
        }
    }
}
