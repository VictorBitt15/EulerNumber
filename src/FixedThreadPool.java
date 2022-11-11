import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPool {
    private static final int NUM_THREADS =5;
    public static void main(String[] args) throws Exception {
        int qtd_tasks=0;
        if(args.length!= 1){
            System.out.println("Por favor forneça um valor como argumento");
            System.exit(1);
        }else{
            try {
                qtd_tasks = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Passe um valor numérico válido por argumento.");
            }
        }
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<Future<Double>> results = new ArrayList<>();

        for(int i=1; i<=qtd_tasks; i++){
            Callable<Double> eulerCallable = new SumNumber(i);
            Future<Double> valoresResultados = executor.submit(eulerCallable);
            results.add(valoresResultados);
        }
        Double valorFinal = 1.0;
        try {
            for(Future<Double> result: results){
            
                valorFinal+=result.get();
            }
            System.out.println("A quantidade de termos para ser calculada foi: "+qtd_tasks);
            System.out.println("O número de Euler com essa quantidade chegou a esse valor: "+valorFinal);
            System.out.println("Foram usadas: "+NUM_THREADS+" threads");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }finally{
            executor.shutdown();
        }
        
        
    }
}
