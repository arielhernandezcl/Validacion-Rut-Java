package rutvalidacion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese RUT: ");
        String rut = sc.nextLine();

        if (validarRut(rut)) {
            System.out.println("RUT válido");
        } else {
            System.out.println("RUT inválido");
        }
    }

    public static boolean validarRut(String rut) {

        rut = rut.replace(".", "").replace("-", "");

        if (rut.length() < 2) {
            return false;
        }

        int dv = rut.charAt(rut.length() - 1) - '0';
        rut = rut.substring(0, rut.length() - 1);

        int suma = 0;
        int multiplicador = 2;

        for (int i = rut.length()-1; i >= 0; i--) {
            suma += (rut.charAt(i) - '0') * multiplicador;
            multiplicador++;
            if (multiplicador == 8) {
                multiplicador = 2;
            }
        }

        int digitoCalculado = 11 - (suma % 11);

        if (digitoCalculado == 11) {
            digitoCalculado = 0;
        } else if (digitoCalculado == 10) {
            digitoCalculado = 'K';
        }

        return dv == digitoCalculado;

    }

}
