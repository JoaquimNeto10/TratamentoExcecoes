package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			Date checkout = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numero, checkin, checkout);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com a data que deseja atualizar a reserva:");
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			checkout = sdf.parse(sc.next());

			reserva.updateDates(checkin, checkout);

			System.out.println("Reserva: " + reserva);
			
		} catch (ParseException e) {
			System.out.println("Formato de data inválido");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();
	
	}

}
