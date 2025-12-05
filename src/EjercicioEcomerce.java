import java.util.Scanner;

public class EjercicioEcomerce {

    public static boolean validarPeso(double peso) {
        if (peso > 0 && peso <= 50) {
            return true;
        } else {
            return false;
        }
    }

    public static double calcularTarifaBase(double peso) {
        if (peso > 0 && peso <= 1) {
            return 5;
        } else if (peso > 1 && peso <= 5) {
            return 10;
        } else if (peso > 5 && peso <= 20) {
            return 20;
        } else if (peso > 20 && peso <= 50) {
            return 50;
        } else {
            return -1;
        }
    }

    public static double calcularRecargoDistancia(int km) {
        if (km < 10) {
            return 0;
        } else if (km <= 50) {
            return 5;
        } else if (km <= 200) {
            return 15;
        } else {
            return 30;
        }
    }

    public static double calcularRecargoTipo(String tipo) {
        tipo = tipo.toLowerCase();
        if (tipo.equals("normal")) {
            return 0;
        } else if (tipo.equals("express")) {
            return 15;
        } else if (tipo.equals("prioritario")) {
            return 30;
        } else {
            return -1;
        }
    }

    public static String generarResumen(double tarifa, double recargoDist, double recargoTipo) {
        double total = tarifa + recargoDist + recargoTipo;

        String linea = "";
        for (int i = 0; i < 30; i++) {
            linea += "-";
        }

        String texto = "";
        texto += linea + "\n";
        texto += "RESUMEN DEL ENVIO\n";
        texto += linea + "\n";
        texto += "Tarifa base: $" + tarifa + "\n";
        texto += "Recargo distancia: $" + recargoDist + "\n";
        texto += "Recargo tipo: $" + recargoTipo + "\n";
        texto += linea + "\n";
        texto += "TOTAL: $" + total + "\n";
        texto += linea;

        return texto;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double peso;
        do {
            System.out.print("Ingrese el peso: ");
            peso = scanner.nextDouble();
        } while (!validarPeso(peso));

        System.out.print("Ingrese la distancia: ");
        int distancia = scanner.nextInt();

        scanner.nextLine();
        String tipo;
        double recargoTipo;
        do {
            System.out.print("Tipo de envio (normal, express, prioritario): ");
            tipo = scanner.nextLine();
            recargoTipo = calcularRecargoTipo(tipo);
        } while (recargoTipo == -1);

        double tarifa = calcularTarifaBase(peso);
        double recargoDist = calcularRecargoDistancia(distancia);

        String resumen = generarResumen(tarifa, recargoDist, recargoTipo);
        System.out.println(resumen);
    }
}
