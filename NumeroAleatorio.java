
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class NumeroAleatorio {

        private static final DecimalFormat df = new DecimalFormat("0.00");
        static void llenarArray(int maximo ,int minimo,int[] pArray){
            int rango = (maximo-minimo)+1;

            for(int i=0;i<pArray.length;i++){
                int aleatorio = (int)(Math.random() *rango)+minimo;
                pArray[i] = aleatorio;
                System.out.println("Listando el arreglo: " + pArray[i]);
            }
        }
        static void mostrarRepetidos(int[] pArray){

            int repetido[] = new int[pArray.length];
            int flag = -1;
            for(int i=0;i<pArray.length-1;i++){
                int contador=1;
                for(int j=i+1; j<pArray.length; j++){
                    if( pArray[i]==pArray[j] ) {
                        contador++;
                        //Para evitar contar el mismo elemento de nuevo
                        repetido[j] = flag;
                    }
                }
                if(repetido[i] != flag)
                    repetido[i] = contador;
            }

            for(int i = 0; i < repetido.length; i++){
                if(repetido[i] != flag  && repetido[i] > 1 )
                    System.out.println("    " + pArray[i] + "    |    " + repetido[i]);
            }

        }

        static void NumerosPares(int[] pArray) {
        int suma=0;
        for (int i = 0; i < pArray.length - 1; i++) {
            if (pArray[i] % 2 == 0)
            {  suma+=pArray[i];
                System.out.println(" Es Par   " + pArray[i]);
            }
        }
    }

    static void NumerosImpaPares(int[] pArray) {
        int suma=0;
        for (int i = 0; i < pArray.length - 1; i++) {
            if (pArray[i]%2 != 0)
            {   suma+=pArray[i];
                System.out.println(" Es Impar   " + pArray[i]);
             }
        }

    }



        static void calculoNumero(int[] pArray) {
            int suma=0, sumPar= 0, sumImpar = 0;
            int contPar=0, contImpar=0;
            Double promedioPar= 0.0, promedioImpar=0.0;
            int[] par= new int[pArray.length];
            int[] impar= new int[pArray.length];

            for (int i = 0; i < pArray.length; i++) {
                if ( pArray[i] % 2 == 0) {
                    par[i] = pArray[i];
                    sumPar += pArray[i];
                    if (par[i] > 0) contPar++;
                }
                else{
                    impar[i] = pArray[i];
                    sumImpar+=pArray[i];
                    if(impar[i] > 0 ) contImpar++;

                }
            }
            promedioPar = (double)sumPar/contPar;
            promedioImpar = (double)sumImpar/contImpar;
            System.out.println(" Promedio de los pares es : "+ df.format(promedioPar));
            System.out.println(" Promedio de los impares es : " + df.format(promedioImpar));
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int i;
            int numeros[] = new int[10];
            int maximo ;
            int minimo ;
            System.out.println("==================================================");
            System.out.println("Listar los numeros del arreglo generado");
            System.out.println("==================================================");
            llenarArray(1,6,numeros);
            System.out.println("=================================================");
            System.out.println("Mostrar el total de coincidencias por cada numero");
            mostrarRepetidos(numeros);
            System.out.println("=================================================");
            System.out.println("Lista Numeros Pares =============================");
            NumerosPares(numeros);
            System.out.println("Lista Numeros Impares =============================");
            NumerosImpaPares(numeros);
            System.out.println("Calculo de Pares y Impares=========================");
            calculoNumero(numeros);
            System.out.println("=================================================");
        }
    }
