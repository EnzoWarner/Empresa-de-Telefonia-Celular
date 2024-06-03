import java.text.SimpleDateFormat;
import java.util.Date;

public class Chamada {
    private Date data;
    private int duracao;
    
    public Chamada(Date data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }
    
    public Date getData() {
        return data;
    }
    
    public int getDuracao() {
        return duracao;
    }
    
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Data: " + sdf.format(data) + ", Duracao: " + duracao + " minutos";
    }
}
