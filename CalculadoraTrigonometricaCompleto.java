import java.util.Scanner;

//TAREA - CALCULADORA TRIGONOMÉTRICA COMPLETA

public class CalculadoraTrigonometricaCompleto {

    //Operaciones trigonométricas básicas (sin, cos, tan)
    static double sin(double angulo) {
        return Math.sin(Math.toRadians(angulo));
    }

    static double cos(double angulo) {
        return Math.cos(Math.toRadians(angulo));
    }

    static double tan(double angulo) {
        return Math.tan(Math.toRadians(angulo));
    }

    //Inversas de las funciones trigonométricas (arcsin, arccos, arctan)
    static double arcoseno(double valor) {
        return Math.toDegrees(Math.asin(valor));
    }

    static double arcocoseno(double valor) {
        return Math.toDegrees(Math.acos(valor));
    }

    static double arcotangente(double valor) {
        return Math.toDegrees(Math.atan(valor));
    }

    //Funciones trigonométricas hiperbólicas (sinh, cosh, tanh)
    static double senoHiperbolico(double angulo) {
        return Math.sinh(angulo);
    }

    static double cosenoHiperbolico(double angulo) {
        return Math.cosh(angulo);
    }

    static double tangenteHiperbolica(double angulo) {
        return Math.tanh(angulo);
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
        System.out.println("  Funciones Hiperbólicas:");
        System.out.println("    7. Seno hiperbólico (sinh)");
        System.out.println("    8. Coseno hiperbólico (cosh)");
        System.out.println("    9. Tangente hiperbólica (tanh)");
        System.out.println("    10. Apagar calculadora");
        System.out.println();
        System.out.print("Seleccione la operación que desea utilizar: ");
    }

    //Lógica de la calculadora
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //Scanner para leer la terminal
        int operacion = -1;

        while (operacion != 0) {

            System.out.println();
            Menu();

            //Validar que el número sea un entero
            while (!scanner.hasNextInt()) {
                System.out.print("Debe ingresar un número entero, inténtelo nuevamente: ");
                scanner.next(); //Eliminar entrada inválida
            }
            operacion = scanner.nextInt();

            //Apagar calculadora con la opción 10
            if (operacion == 10) {
                System.out.println();
                System.out.println("Calculadora apagada");
                break;
            }

            //Validar que el usuario escoja una opción válida del menú
            if (operacion < 1 || operacion > 9) {
                System.out.println("Debe seleccionar una opción del 1 al 9");
                continue;
            }

            //Obtener el valor del ángulo
            System.out.print("  Ingrese el valor del ángulo: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Debe ingresar un número válido, inténtelo nuevamente: ");
                scanner.next(); //Eliminar entrada inválida
            }
            double ang = scanner.nextDouble();

            //Validación de dominio para arcsin y arccos (rango permitido: -1 a 1)
            if ((operacion == 4 || operacion == 5) && (ang < -1.0 || ang > 1.0)) {
                System.out.println();
                System.out.println("El valor que ingresó está fuera del rango permitido (-1 a 1)");
                continue;
            }

            //Convertir a radianes solo para las funciones hiperbólicas
            double angRadianes = Math.toRadians(ang); //Línea agregada para hiperbólicas

            //Calcular y mostrar resultado
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
                    nombre_funcion = "arctan(" + ang + ")";
                    break;
                case 7:
                    resultado = senoHiperbolico(angRadianes);
                    nombre_funcion = "sinh(" + ang + "°)";
                    break;
                case 8:
                    resultado = cosenoHiperbolico(angRadianes);
                    nombre_funcion = "cosh(" + ang + "°)";
                    break;
                case 9:
                    resultado = tangenteHiperbolica(angRadianes);
                    nombre_funcion = "tanh(" + ang + "°)";
                    break;
            }

            System.out.printf("  Resultado: %s = %.4f%n", nombre_funcion, resultado);
        }

        scanner.close();
    }
}
// finalizada