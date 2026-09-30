import java.util.ArrayList;
import java.util.List;

public class GestorDescargas {
    public static void main(String[] args){
        String[] archivos = {
                "cuarzos.png","meditacion.mp4","mantras.mp3","horoscopo.pdf"
        };
        List<Descarga> listaDescargas = new ArrayList<>(); //Hacer un arraylist para los 4 nombres
        //crear los hilos
        for (String archivo : archivos){
            listaDescargas.add(new Descarga(archivo));
        }
        long inicio = System.currentTimeMillis();
        //Primero arracar todos los hilos
        for (Descarga d : listaDescargas){
            d.start();
        }
        //despues esperar a que terminen con join()
        for (Descarga d : listaDescargas){
            try {
                d.join();
            } catch (InterruptedException e) {
                System.err.println("interrumpido para: " +d.getNombreArchivo());
            }
        }
        long finReal = System.currentTimeMillis(); //para el tiempo real
        long tiempoRealTotal = finReal - inicio;
        //para sumar los tiempos
        long acumulado = 0;
        for (Descarga d : listaDescargas) {
            acumulado += d.getTiempoTotal();
        }


        System.out.println("Todas las descargas han terminado");
        System.out.println("Tiempo real: " + tiempoRealTotal + "ms");
        System.out.println("Si se hubieran descargado una detras de otra: " +acumulado +"ms");

    }
}
