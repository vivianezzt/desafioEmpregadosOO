package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("NOME DO DEPARTAMENTO: ");
		String deptName = sc.nextLine();
		System.out.print("DIA DO PAGAMENTO: ");
		int payDay = sc.nextInt();
		System.out.print("EMAIL: ");
		String email = sc.next();
		System.out.print("TELEFONE: ");
		String phone = sc.next();
		Address address = new Address(email, phone);
		Department dept = new Department(deptName, payDay, address);
		
		System.out.print("QUANTOS FUNCIONÁRIOS EXISTEM NO DEPARTAMENTO? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("DADOS DO FUNCIONÁRIO: " + i);
			System.out.print("NOME: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("SALÁRIO: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(name, salary);
			
			dept.addEmployee(employee);
			System.out.println();
			
			showReport(dept);
		}
		
		
		
		
		sc.close();
	}
	
	private static void showReport(Department dept) {
		StringBuilder sb = new StringBuilder();
		System.out.println("====================================");
		sb.append("FOLHA DE PAGAMENTO:\n");
		sb.append("DEPARTAMENTO DE VENDAS = R$ " + String.format("%.2f\n", dept.payroll()));
		sb.append("PAGAMENTO REALIZADO NO DIA: " + dept.getPayDay() + "\n");
		sb.append("FUNCIONÁRIOS:\n");
		for (Employee e : dept.getEmployee()) {
			sb.append(e + "\n");
			
		}
		sb.append("PARA DÚVIDAS FAVOR ENTRE EM CONTATO: " + dept.getAddress().getEmail());
		System.out.println(sb);
		
	}

}

