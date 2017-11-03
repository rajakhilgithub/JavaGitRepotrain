package net.opentrends.carrental.DAOServices;


import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.opentrends.carrental.DAOClasses.BookingDAO;
import net.opentrends.carrental.DTOClasses.BookingDTO;
import net.opentrends.carrental.model.Booking;

@Service
public class BookingDAOServiceImpl implements BookingDAOService{
@Autowired
BookingDAO bookingDao;
	@Override
	public List listAll() {
		// TODO Auto-generated method stub
		return this.bookingDao.listAll();
	}

	@Override
	public BookingDTO save(BookingDTO bookingDto) {
		// TODO Auto-generated method stub
		return this.bookingDao.save(bookingDto);
	}

	@Override
	public void delete(BookingDTO bookingDto) {
		// TODO Auto-generated method stub
		this.bookingDao.delete(bookingDto);
	}

	@Override
	public BookingDTO findByKey(int id) {
		// TODO Auto-generated method stub
		return this.bookingDao.findByKey(id);
	}

	

	@Override
	public int findAvailable(BookingDTO bookingDto) {
		
		return this.bookingDao.findAvailablity(bookingDto);
	}

	@Override
	public BookingDTO setDates(BookingDTO bookingDto) {
		// TODO Auto-generated method stub
		try {
			java.util.Date fromDate= new SimpleDateFormat("yyyy-MM-dd").parse(bookingDto.getfDate());
			java.util.Date toDate= new SimpleDateFormat("yyyy-MM-dd").parse(bookingDto.gettDate());
			bookingDto.setFromDate(fromDate);
			bookingDto.setToDate(toDate);
			

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return bookingDto;
	}

	

}
