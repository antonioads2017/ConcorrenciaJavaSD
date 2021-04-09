package ifpb.edu.br.buffers;

import ifpb.edu.br.interfaces.Buffer;

import java.util.concurrent.ArrayBlockingQueue;

public class BufferExemploBlockingQueue implements Buffer {

    private ArrayBlockingQueue<Integer> buffer;

    public BufferExemploBlockingQueue (){
        buffer = new ArrayBlockingQueue<Integer>(3);
    }
    @Override
    public void set(int valor) {
        try {
            buffer.put( valor);
            System.out.printf( "%s%2d\t%s%d\n", "Produtor grava: ", valor, "Buffers ocupados: ", buffer.size() );
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
    }

    @Override
    public int get() {
        int lerValor = 0;
        try {
            lerValor = buffer.take();
            System.out.printf( "%s %2d\t%s%d\n", "Consumidor lê: ", lerValor, "Buffers ocupados: ", buffer.size() );
        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
        return lerValor;
    }
}
