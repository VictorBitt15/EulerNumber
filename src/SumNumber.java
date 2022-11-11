import java.util.concurrent.Callable;

import utils.fatorial;

public class SumNumber implements Callable<Double>{
    private int id;

    public SumNumber(int id) {
        this.id=id;
    }


    @Override
    public Double call() throws Exception {
        double valor = fracao(id);
        System.out.println("Sou a thread: "+Thread.currentThread().getId() + " e calculou o valor: "+valor);
        return valor;
    }


    private Double fracao(int id) {
        return (double) (1.0/fatorial.calcFatorial(id));  
    }
    
}
