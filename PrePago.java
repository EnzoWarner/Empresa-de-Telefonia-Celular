import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrePago extends Assinante {
    private List<Recarga> recargas;
    private int numRecargas;
    private float creditos;
    
    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.recargas = new ArrayList<>();
        this.numRecargas = 0;
        this.creditos = 0;
    }
    
    public void fazerChamada(Date data, int duracao) {
        float custo = duracao * 1.45f;
        if (creditos >= custo) {
            this.creditos -= custo;
            this.numChamadas++;
            this.chamadas.add(new Chamada(data, duracao));
        } else {
            System.out.println("Creditos insuficientes.");
        }
    }
    
    public void recarregar(Date data, float valor) {
        this.creditos += valor;
        this.numRecargas++;
        this.recargas.add(new Recarga(data, valor));
    }
    
    public void imprimirFatura(int mes) {
        // Imprimir fatura para o mês especificado
    }
    
    public String toString() {
        return super.toString() + ", Creditos: " + creditos + ", Recargas: " + numRecargas;
    }
}
