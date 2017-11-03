package net.opentrends.carrental.DAOClasses;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.opentrends.carrental.DTOClasses.BookingDTO;
import net.opentrends.carrental.model.Booking;
import net.opentrends.carrental.model.Customer;
import net.opentrends.carrental.model.Model;


@Repository
public class BookingDAOImpl implements BookingDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List listAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Booking.class);
		List<Booking> bookingList= criteria.list();
		List<BookingDTO> bookingDtoList=new ArrayList<>();
		for(Booking booking:bookingList) {
			BookingDTO bookingDto=new BookingDTO();
			BeanUtils.copyProperties(booking, bookingDto);
			bookingDto.setCustomerId(booking.getCustomer().getCustomerID());
			bookingDto.setModelId(booking.getModel().getModelID());
			bookingDtoList.add(bookingDto);
		}
		return bookingDtoList;
	}

	@Override
	public BookingDTO save(BookingDTO bookingDto) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Booking booking=new Booking();
		BeanUtils.copyProperties(bookingDto, booking);
		booking.setCustomer(session.get(Customer.class, bookingDto.getCustomerId()));
		booking.setModel(session.get(Model.class,bookingDto.getModelId()));
		session.save(booking);
		return bookingDto;
	}

	@Override
	public void delete(BookingDTO bookingdto) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Booking booking=session.get(Booking.class, bookingdto.getBookingId());
		session.delete(booking);
	}

	@Override
	public BookingDTO findByKey(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Booking booking= session.get(Booking.class, id);
		BookingDTO bookingDto=new BookingDTO();
		BeanUtils.copyProperties(booking, bookingDto);
		bookingDto.setCustomerId(booking.getCustomer().getCustomerID());
		bookingDto.setModelId(booking.getModel().getModelID());
		return bookingDto;
	}

	@Override
	public int findAvailablity(BookingDTO bookingDto) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.openSession().createCriteria(Booking.class);
		Criterion model= Restrictions.eq("model.modelID", bookingDto.getModelId());
		Criterion fromDateGreater=Restrictions.le("fromDate", bookingDto.getFromDate());
		Criterion fromDateLesser= Restrictions.ge("toDate", bookingDto.getFromDate());
		Criterion fromAnd=Restrictions.and(fromDateGreater, fromDateLesser);
		
		Criterion toDateGreater=Restrictions.le("fromDate", bookingDto.getToDate());
		Criterion toDateLesser= Restrictions.ge("toDate", bookingDto.getToDate());
		Criterion toAnd=Restrictions.and(toDateGreater, toDateLesser);
		
		Criterion dateInBetweenLess=Restrictions.gt("fromDate",bookingDto.getFromDate());
		Criterion dateInBetweenGreater=Restrictions.lt("toDate",bookingDto.getToDate());
		Criterion dateInBetween=Restrictions.and(dateInBetweenLess, dateInBetweenGreater);
		
		Criterion orFromTo=Restrictions.or(fromAnd, toAnd);
		Criterion orFromToBetween=Restrictions.or(orFromTo, dateInBetween);
		Criterion finalQuery=Restrictions.and(orFromToBetween, model);
		
		criteria.add(finalQuery);
		int booked=criteria.list().size();
		int stock=sessionFactory.openSession().get(Model.class, bookingDto.getModelId()).getStock();
		return stock-booked;
		
	}

}
