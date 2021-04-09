package ifpb.edu.br.buffers;

import ifpb.edu.br.interfaces.Buffer;

public class BufferExemplo  implements Buffer {

    private int buffer = -1;

    @Override
    public void set(int valor) {
        System.out.printf("Produtor grava: \t%2d\n", valor);
        buffer = valor;
    }

    @Override
    public int get() {
        System.out.printf("Consumidor lê: \t%2d\n",buffer);
        return buffer;
    }
}
