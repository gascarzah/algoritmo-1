package prueba2;

import java.util.HashMap;
import java.util.Map;

public class Problema1 {

	public static void main(String[] args) {
//		String[] empleados = { "N" };
		String[] empleados = { "NNYN", "NNYN", "NNNN", "NYYN", "NNYN" };

		calcularSueldo(empleados);
	}

	private static void calcularSueldo(String[] empleados) {
		int salario = 0;
		if (empleados.length == 1 && empleados[0].equals("N")) {
			salario = 1;
		} else {

			System.out.println("salario = " + salario);

			Integer[] salarios = new Integer[empleados.length];

			int numJefesY = 0;
			int numJefesYY = 0;
			int conta = 0;

			int sueldoTotal = 0;

			for (int i = 0; i < empleados.length; i++) {
				String empleado = empleados[i].replace("Y", "").trim();
				conta++;
				if (empleado.length() == 3) {
					numJefesY++;
				} else if (empleado.length() == 2) {
					numJefesYY++;
					int salarioYY = 0;
					for (int k = 1; k <= 2; k++) {
						salarioYY += salarios[getSalariosCompletos(salarios) - k];
					}
					salarios[i] = salarioYY;
					numJefesY = 0;

				} else {

					if (numJefesY > 0) {
						//conta - 1
						for (int j = 0; j < numJefesY; j++) {
							if (salarios[j] == null) {
								salarios[j] = 1;
							} else {
								salarios[j] = salarios[j] + 1;
							}

						}
						salarios[i] = 1;

					}

				}
			}

			if (salarios[empleados.length - 1] == null) {
				salarios[empleados.length - 1] = 1;
			}

			for (int i = 0; i < empleados.length; i++) {

				System.out.println("empleado = " + empleados[i] + " salario = " + salarios[i]);
				sueldoTotal += salarios[i];
			}
			System.out.println("Sueldo total = " + sueldoTotal);
		}

	}

	public static int getSalariosCompletos(Integer[] salarios) {
		int completos = 0;
		for (int i = 0; i < salarios.length; i++) {
			if (salarios[i] != null) {
				completos++;
			}

		}

		return completos;
	}
}
