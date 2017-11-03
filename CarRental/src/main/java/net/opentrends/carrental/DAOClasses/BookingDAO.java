package net.opentrends.carrental.DAOClasses;

import java.util.List;

import net.opentrends.carrental.DTOClasses.BookingDTO;
import net.opentrends.carrental.model.Booking;

public interface BookingDAO {
	public List listAll();
	public BookingDTO save(BookingDTO bookingdto);
	public void delete(BookingDTO bookingdto);
	public BookingDTO findByKey(int id);
	public int findAvailablity(BookingDTO bookingDto);
}
