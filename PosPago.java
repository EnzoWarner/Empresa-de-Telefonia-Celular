import java.util.Date;

public class PosPago extends Assinante {
    private float assinatura;
    
    public PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }
    
    public void fazerChamada(Date data, int duracao) {
        this.chamadas.add(new Chamada(data, duracao));
        this.numChamadas++;
    }
    
    public void imprimirFatura(int mes) {
        // Imprimir fatura para o mês especificado
    }
    
    public String toString() {
        return super.toString() + ", Assinatura: R$" + assinatura;
    }
}
