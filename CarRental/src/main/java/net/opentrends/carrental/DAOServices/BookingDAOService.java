package net.opentrends.carrental.DAOServices;

import java.util.List;

import net.opentrends.carrental.DTOClasses.BookingDTO;
import net.opentrends.carrental.model.Booking;

public interface BookingDAOService {
	public List listAll();
	public BookingDTO save(BookingDTO bookingDto);
	public void delete(BookingDTO bookingDto);
	public BookingDTO findByKey(int id);
	public BookingDTO setDates(BookingDTO bookingDto);
	public int findAvailable(BookingDTO bookingDto);
}
