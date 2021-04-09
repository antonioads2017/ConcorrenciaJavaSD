package ifpb.edu.br;

import ifpb.edu.br.buffers.BufferExemploCircularBlockingQueue;
import ifpb.edu.br.consumidores.Consumidor;
import ifpb.edu.br.interfaces.Buffer;
import ifpb.edu.br.produtores.Produtor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BufferCircularBlockingQueue {
    public static void main( String[] args ) {
        ExecutorService teste = Executors.newFixedThreadPool(5);
        Buffer localizacaoCompartilhada = new BufferExemploCircularBlockingQueue();
        try {
            System.out.println("Buffer Circular com Blocking Queue \n\n");
            teste.execute(new Produtor(localizacaoCompartilhada));
            teste.execute(new Consumidor(localizacaoCompartilhada));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        teste.shutdown();
    }
}

