import java.util.Scanner;

//TAREA - CALCULADORA TRIGONOMÉTRICA


public class CalculadoraTrigonometricaCompleto {

    //Operaciones trigonométricas básicas (sin, cos, tan)
    static double sin(double angulo) {  //double para permitir decimales
        return Math.sin(Math.toRadians(angulo));
    }

    static double cos(double angulo) {
        return Math.cos(Math.toRadians(angulo));
    }

    static double tan(double angulo) {
        return Math.tan(Math.toRadians(angulo));
    }

    //Inversas de las funciones trigonométricas (arcsin, arcos, arctan)
    static double arcoseno(double valor) {
        return Math.toDegrees(Math.asin(valor));
    }

    static double arcocoseno(double valor) {
        return Math.toDegrees(Math.acos(valor));
    }

    static double arcotangente(double valor) {
        return Math.toDegrees(Math.atan(valor));
    }

    static void Menu() {
        System.out.println("CALCULADORA TRIGONOMÉTRICA");
        System.out.println();
        System.out.println("  Funciones Trigonométricas básicas:");
        System.out.println("    1. Seno");
        System.out.println("    2. Coseno");
        System.out.println("    3. Tangente");

        System.out.println("  Funciones Inversas:");
        System.out.println("    4. Arcoseno");
        System.out.println("    5. Arcocoseno");
        System.out.println("    6. Arcotangente");
        System.out.println("    7. Apagar calculadora");
        System.out.println();

        System.out.print("Seleccione la operación que desea utilizar: ");
    }


    //Lógica de la calculadora
    public static void main(String[] args) { //String[] args para recibir datos de la terminal

        Scanner scanner = new Scanner(System.in); //Scanner para leer la terminal
        int operacion = -1;


        while (operacion != 0) { //Para que corra solo si selecciona una opción (1 al 6)

            System.out.println();
            Menu();

            // Leer opción
            while (!scanner.hasNextInt()) { //Valudar que el numero sea un entero
                System.out.print("Debe ingresar un número entero, intentelo nuevamente: ");
                scanner.next(); //Eliminar entrada inválida
            }
            operacion = scanner.nextInt();

            
            //Apagar calculadora con la opción 7
            if (operacion == 7) {
                System.out.println();
                System.out.println("Calculadora apagada");
                break;
            }
            
            //Validar que el usuario escoja una opción válida del menú
            if (operacion < 1 || operacion > 6) {
                System.out.println("Debe seleccionar una opcion del 1 al 6");
                continue;
            }

            // Obtener el valor del ángulo
            System.out.print("  Ingrese el valor del ángulo: ");
            while (!scanner.hasNextDouble()) { //Validar que el número ingresado sea entero
                System.out.print("Debe ingresar un número entero, intentelo nuevamente: ");
                scanner.next();
            }
            double ang = scanner.nextDouble();

            // Validaciones de dominio para funciones inversas
            if ((operacion == 4 || operacion == 5) && (ang < -1.0 || ang > 1.0)) {
                System.out.println();
                System.out.println("El valor que ingresó está fuera del rango permitido");       
                continue;
            }


            // Calcular y mostrar resultado
            double resultado = 0;
            String nombre_funcion = "";

            switch (operacion) {
                case 1:
                    resultado = sin(ang);
                    nombre_funcion = "sin(" + ang + "°)";
                    break;
                case 2:
                    resultado = cos(ang);
                    nombre_funcion = "cos(" + ang + "°)";
                    break;
                case 3:
                    resultado = tan(ang);
                    nombre_funcion = "tan(" + ang + "°)";
                    break;
                case 4:
                    resultado = arcoseno(ang);
                    nombre_funcion = "arcsin(" + ang + ")";
                    break;
                case 5:
                    resultado = arcocoseno(ang);
                    nombre_funcion = "arccos(" + ang + ")";
                    break;
                case 6:
                    resultado = arcotangente(ang);
                    nombre_funcion = "arctan(" + ang+ ")";
                    break;
            }

            System.out.printf("  Resultado: %s = %.2f%n", nombre_funcion, resultado);
        }

        scanner.close();
    }
}