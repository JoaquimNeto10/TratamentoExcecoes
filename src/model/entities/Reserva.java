package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer nroQuarto;
	private Date checkIn, checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	public Reserva() {}
	
	public Reserva(Integer nroQuarto, Date checkIn, Date checkOut) {
		this.nroQuarto = nroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNroQuarto() {
		return nroQuarto;
	}

	public void setNroQuarto(Integer nroQuarto) {
		this.nroQuarto = nroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		//o getTime() me retorna a quantidade de milisegundos da data
		//TimeUnit converte milisegundos em dias
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "As datas para a atualização devem ser futuras";
		} if(!checkOut.after(checkIn)) {
			return "A data do checkout deve ser depois do checkin!";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ nroQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " Noites";
	}

}
