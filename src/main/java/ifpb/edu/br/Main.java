package ifpb.edu.br;

import ifpb.edu.br.buffers.BufferExemplo;
import ifpb.edu.br.consumidores.Consumidor;
import ifpb.edu.br.interfaces.Buffer;
import ifpb.edu.br.produtores.Produtor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main( String[] args ) {
        ExecutorService teste = Executors.newFixedThreadPool( 2 );
        Buffer localizacaoCompartilhada= new BufferExemplo();
        try {
            teste.execute( new Produtor( localizacaoCompartilhada) );
            teste.execute( new Consumidor( localizacaoCompartilhada) );
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
        teste.shutdown();
    }
}
