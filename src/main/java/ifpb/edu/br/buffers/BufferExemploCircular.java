package ifpb.edu.br.buffers;

import ifpb.edu.br.interfaces.Buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferExemploCircular implements Buffer {

    private Lock lockDeAcesso = new ReentrantLock();
    private Condition podeGravar = lockDeAcesso.newCondition();
    private Condition poderLer = lockDeAcesso.newCondition();
    private int buffer = -1;
    private boolean ocupado = false;

    @Override
    public void set(int valor) {
        lockDeAcesso.lock();
        try {
            while (ocupado){
                System.out.println("Produtor tenta gravar.");
                mostrarEstado("Buffer Cheio. Produtor aguarda.");
                podeGravar.await();
            }
            buffer = valor;
            ocupado = true;
            mostrarEstado("Produtor grava: "+buffer);
            poderLer.signal();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }finally {
            lockDeAcesso.unlock();
        }
    }

    @Override
    public int get() {
        int valorLido = 0;
        lockDeAcesso.lock();
        try{
            while (ocupado){
                System.out.println("Consumidor tenta ler");
                mostrarEstado("Buffer vazio. Consumidor aguarda");
                poderLer.await();
            }
            ocupado = false;
            valorLido = buffer;
            mostrarEstado("Consumidor lê: "+valorLido);
            podeGravar.signal();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }finally {
            lockDeAcesso.unlock();
        }
        return valorLido;
    }

    public void mostrarEstado(String operacao){
        System.out.printf("%-40s%d\t\t%b\n\n", operacao,buffer,ocupado);
    }
}
