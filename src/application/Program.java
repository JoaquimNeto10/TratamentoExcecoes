package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data do check-in (dd/mm/aaaa): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data do check-out (dd/mm/aaaa): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva: A data do checkout deve ser depois do checkin!");
		} else {
			Reserva reserva = new Reserva(numero, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data que deseja atualizar a reserva:");
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			checkout = sdf.parse(sc.next());
			
			String error = reserva.updateDates(checkin, checkout);
			
			if (error != null) {
				System.out.println("Erro na reserva: " + error); 				
			} else {
				System.out.println("Reserva: " + reserva);
			}
		}		
		sc.close();
	}

}
