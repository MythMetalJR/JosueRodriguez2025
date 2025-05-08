/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.josuerodriguez2025;
import java.util.Scanner;
public class JosueRodriguez2025 {
    
  public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] litros = new double[7];
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

      
        for (int i = 0; i < 7; i++) {
        while (true) {
        System.out.print("Ingrese los litros consumidos el " + dias[i] + ": ");
           double valor = sc.nextDouble();
             if (valor >= 0) {
                litros[i] = valor;
                break;
                } else {
                System.out.println("El consumo debe ser mayor o igual a 0.");
                }
            }
        }

        int opcion;
        do {
            
            System.out.println("--- MENÚ ---");
            System.out.println("1. Total de litros consumidos por semana");
            System.out.println("2. Día con el consumo más cercano al promedio");
            System.out.println("3. Mostrar día de mayor y menor consumo");
            System.out.println("4. Sumar consumos de lunes a miércoles y de viernes a domingo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    double total = 0;
                    for (double l : litros) total += l;
                    System.out.printf("Total semanal: %.2f litros\n", total);
                    break;

                case 2:
                    double suma = 0;
                    for (double l : litros) suma += l;
                    double promedio = suma / 7;

                    double menorDiferencia = Math.abs(litros[0] - promedio);
                    int indiceCercano = 0;
                    for (int i = 1; i < 7; i++) {
                        double diferencia = Math.abs(litros[i] - promedio);
                        if (diferencia < menorDiferencia) {
                            menorDiferencia = diferencia;
                            indiceCercano = i;
                        }
                    }
                    System.out.printf("Consumo más cercano al promedio (%.2f): %s con %.2f litros\n",
                            promedio, dias[indiceCercano], litros[indiceCercano]);
                    break;

                case 3:
                    int indiceMax = 0, indiceMin = 0;
                    for (int i = 1; i < 7; i++) {
                        if (litros[i] > litros[indiceMax]) indiceMax = i;
                        if (litros[i] < litros[indiceMin]) indiceMin = i;
                    }
                    System.out.printf("Mayor consumo: %s con %.2f litros\n", dias[indiceMax], litros[indiceMax]);
                    System.out.printf("Menor consumo: %s con %.2f litros\n", dias[indiceMin], litros[indiceMin]);
                    break;

                case 4:
                    double sumaLunesMiercoles = litros[0] + litros[1] + litros[2];
                    double sumaViernesDomingo = litros[4] + litros[5] + litros[6];
                    System.out.printf("Suma de lunes a miércoles: %.2f litros\n", sumaLunesMiercoles);
                    System.out.printf("Suma de viernes a domingo: %.2f litros\n", sumaViernesDomingo);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}

