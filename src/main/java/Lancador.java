import java.util.Observable;
import java.util.Observer;

public class Lancador implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Lancador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
    public void ingerssarPregao(Pregao pregao ){
        pregao.addObserver(this);
    }

    public void setUltimaNotificacao(String ultimaNotificacao) {
        this.ultimaNotificacao = ultimaNotificacao;
    }

    @Override
    public void update(Observable pregao, Object arg) {
        this.setUltimaNotificacao(this.getNome() + ", "+pregao.toString());

    }
}
