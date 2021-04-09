package ifpb.edu.br;

import ifpb.edu.br.buffers.BufferExemploBlockingQueue;
import ifpb.edu.br.buffers.BufferExemploCircular;
import ifpb.edu.br.consumidores.Consumidor;
import ifpb.edu.br.interfaces.Buffer;
import ifpb.edu.br.produtores.Produtor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BufferBlockingQueueTest {
    public static void main( String[] args ) {
        ExecutorService teste2 = Executors.newFixedThreadPool( 7);
        Buffer localizacaoCompartilhadaCSicronizacao = new BufferExemploBlockingQueue();
        try {
            System.out.println("Buffer Circular\n\n");
            teste2.execute(new Produtor(localizacaoCompartilhadaCSicronizacao));
            teste2.execute(new Consumidor(localizacaoCompartilhadaCSicronizacao));
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
        teste2.shutdown();
    }
}
