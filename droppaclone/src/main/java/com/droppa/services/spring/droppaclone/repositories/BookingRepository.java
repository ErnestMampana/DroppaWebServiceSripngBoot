/**
 * 
 */
package com.droppa.services.spring.droppaclone.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droppa.services.spring.droppaclone.enums.BookingStatus;
import com.droppa.services.spring.droppaclone.models.Booking;

/**
 * @author Ernest Mampana
 *
 */
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	Optional<Booking> findByBookingId(String bookingId);

	Optional<List<Booking>> findAllByStatus(BookingStatus status);
	
	Optional<List<Booking>> findAllByAssinedDriver(String status);

	Optional<List<Booking>> findAllByStatusAndUserId(BookingStatus status, String userId);
	
	Optional<List<Booking>> findAllByUserId(String status);
	
	Optional<Booking> deleteByBookingId(String bookingId); 
}
