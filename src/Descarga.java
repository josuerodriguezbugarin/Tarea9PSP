

public class Descarga extends Thread {
    public static final int ajuste_bloque = 1; //ajuste bloque es para ajustar el tiempo de cada bloque
    private final String nombreArchivo;
    private final long tiempoBloque;
    private long tiempoTotal;

    public Descarga(String nombreArchivo) { //constructor de la clase descarga
        super("descarga: " + nombreArchivo); //Coge el nombre del archivo y calcula un tiempo aleatorio entre 100 y 500 ms
        this.nombreArchivo = nombreArchivo;
        this.tiempoBloque = (long) (Math.random() *401) +100;
        this.tiempoTotal = 0;
    }

    public long getTiempoTotal() { //devuelve el tiempo que ha tardado
        return tiempoTotal;
    }
    public String getNombreArchivo(){ //devuelve el nombre del archivo
        return nombreArchivo;
    }
    public void run(){
        long inicio = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++){
            try {
                Thread.sleep(tiempoBloque*ajuste_bloque);
            } catch (InterruptedException e){
                System.err.println("La descarga: " + nombreArchivo + "a tenido un error");
            }
            int porcentaje = i * 10;
            System.out.println("["+nombreArchivo+"] completada en " + porcentaje + "%");

        }
        long fin = System.currentTimeMillis();
        this.tiempoTotal = fin - inicio;
        System.out.println("["+ nombreArchivo +"] completada en " + tiempoTotal + " ms");
    }
}
