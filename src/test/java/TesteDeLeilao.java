import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteDeLeilao {

    private Lancador rennan;

    @Test
    void deveNotificarUmLancador() {
        Pregao pregao = new Pregao(12.00f);
        Lancador lancador = new Lancador("Rennan");

        lancador.ingerssarPregao(pregao);
        pregao.darLance(33.00f, lancador);

        assertEquals("Rennan, lance do Rennan de valor 33.0", lancador.getUltimaNotificacao());
    }

    @Test
    void deveNotificarLancadores() {
        Pregao pregao = new Pregao(12.00f);
        Lancador lancador1 = new Lancador("Rennan");
        Lancador lancador2 = new Lancador("Matheus");
        Lancador lancador3 = new Lancador("Falci");

        lancador1.ingerssarPregao(pregao);
        lancador2.ingerssarPregao(pregao);
        lancador3.ingerssarPregao(pregao);

        pregao.darLance(33.00f, lancador2);

        assertEquals("Rennan, lance do Matheus de valor 33.0", lancador1.getUltimaNotificacao());
        assertEquals("Matheus, lance do Matheus de valor 33.0", lancador2.getUltimaNotificacao());
        assertEquals("Falci, lance do Matheus de valor 33.0", lancador3.getUltimaNotificacao());
    }

    @Test
    void naodeveNotificarLancadores(){
        Pregao pregao = new Pregao(12.00f);
        Lancador lancador1 = new Lancador("Rennan");
        Lancador lancador2 = new Lancador("Matheus");
        Lancador lancador3 = new Lancador("Falci");

        lancador1.ingerssarPregao(pregao);
        lancador2.ingerssarPregao(pregao);
        lancador3.ingerssarPregao(pregao);

        pregao.darLance(3.00f, lancador2);

        assertEquals(null, lancador1.getUltimaNotificacao());
        assertEquals(null, lancador2.getUltimaNotificacao());
        assertEquals(null, lancador3.getUltimaNotificacao());
    }
    @Test
    void ndeveNotificarLancadores1e2(){
        Pregao pregao = new Pregao(12.00f);
        Lancador lancador1 = new Lancador("Rennan");
        Lancador lancador2 = new Lancador("Matheus");
        Lancador lancador3 = new Lancador("Falci");

        lancador1.ingerssarPregao(pregao);
        lancador2.ingerssarPregao(pregao);

        pregao.darLance(33.00f, lancador2);

        assertEquals("Rennan, lance do Matheus de valor 33.0", lancador1.getUltimaNotificacao());
        assertEquals("Matheus, lance do Matheus de valor 33.0", lancador2.getUltimaNotificacao());
        assertEquals(null, lancador3.getUltimaNotificacao());
    }
}
