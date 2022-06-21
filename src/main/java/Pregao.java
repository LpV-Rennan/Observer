import java.util.Observable;

public class Pregao extends Observable {
    private float valorDeLance = 0;
    private Lancador ultimoLance ;

    public Pregao(float valorDeLance) {
        this.valorDeLance = valorDeLance;
    }

    public float getValorDeLance() {
        return valorDeLance;
    }

    public void setValorDeLance(float valorDeLance) {
        this.valorDeLance = valorDeLance;
    }

    public Lancador getUltimoLance() {
        return ultimoLance;
    }

    public void setUltimoLance(Lancador ultimoLance) {
        this.ultimoLance = ultimoLance;
    }
    public void darLance(float valor , Lancador lancador){
        if (valor < this.getValorDeLance()) {
            return;
        }
        this.setUltimoLance(lancador);
        this.setValorDeLance(valor);

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return "lance do "+ this.getUltimoLance().getNome() +" de valor "+ this.getValorDeLance();
    }
}
