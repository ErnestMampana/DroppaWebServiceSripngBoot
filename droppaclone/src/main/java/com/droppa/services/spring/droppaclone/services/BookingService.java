/**
 * 
 */
package com.droppa.services.spring.droppaclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.droppa.services.spring.droppaclone.common.ClientException;
import com.droppa.services.spring.droppaclone.dto.BookingDTO;
import com.droppa.services.spring.droppaclone.enums.AccountStatus;
import com.droppa.services.spring.droppaclone.enums.BookingStatus;
import com.droppa.services.spring.droppaclone.models.Adress;
import com.droppa.services.spring.droppaclone.models.Booking;
import com.droppa.services.spring.droppaclone.models.DropDetails;
import com.droppa.services.spring.droppaclone.models.UserAccount;
import com.droppa.services.spring.droppaclone.repositories.AddressRespository;
import com.droppa.services.spring.droppaclone.repositories.BookingRepository;
import com.droppa.services.spring.droppaclone.repositories.DropDetailsrepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Ernest Mampana
 *
 */
@Service
@RequiredArgsConstructor
public class BookingService {

	private PartyService partyService;

	private BookingRepository bookingRepository;

	private AddressRespository addressRespository;

	private DropDetailsrepository dropRepo;

	private UserService userService;

	public Booking createBooking(BookingDTO bookingDto) {

		String bookingId;

		// Person person = userService.getUserById(bookingDto.userId).getOwner();

//		if (person.getId() == null)
//			throw new ClientException("Only registered users can create a booking");

		Adress adress = new Adress(bookingDto.pickUpStandNumber, bookingDto.pickUpStreetName, bookingDto.pickUpSuburb,
				bookingDto.pickUpProvince, bookingDto.pickUpPostalCode, bookingDto.dropOffStandNumber,
				bookingDto.dropOffStreetName, bookingDto.dropOffSuburb, bookingDto.dropOffProvince,
				bookingDto.dropOffPostalCode);

		DropDetails dropDetails = new DropDetails(bookingDto.pickUpName, bookingDto.pickUpSurname,
				bookingDto.pickUpContact, bookingDto.dropOffName, bookingDto.dropOffSurname, bookingDto.dropOffContact);

		bookingId = partyService.randomChars(15);

		boolean found = true;
		while (found) {
			Optional<Booking> bookingOptional = bookingRepository.findByBookingId(bookingId);
			if (bookingOptional.isPresent()) {
				bookingId = partyService.randomChars(15);
			} else {
				found = false;
			}
		}

		Booking booking = new Booking(bookingId, adress, bookingDto.userId, dropDetails, bookingDto.date, 0, null,
				BookingStatus.AWAITING_DRIVER);

		UserAccount userAccount = userService.getUserByEmail(bookingDto.userId);

		if (userAccount.getStatus().equals(AccountStatus.ACTIVE)) {
			dropRepo.save(dropDetails);
			addressRespository.save(adress);
			bookingRepository.save(booking);
			return booking;
		} else {
			if (userAccount.getStatus().equals(AccountStatus.AWAITING_CONFIRMATION)) {
				throw new ClientException("Please confirm your account first.");
			} else if (userAccount.getStatus().equals(AccountStatus.AWAITING_PWD_RESET)) {
				throw new ClientException("You haven't set confirmed your new password");
			} else {
				throw new ClientException(
						"Your account has been suspended please contact Droppa Clone for re-activation.");
			}
		}

	}

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(String bookingId) {
		Optional<Booking> bookingOptional = bookingRepository.findByBookingId(bookingId);

		if (bookingOptional.isPresent()) {
			return bookingOptional.get();
		} else {
			throw new ClientException("booking not found");
		}
	}

	public List<Booking> getBookingsByStatus(BookingStatus status) {

		Optional<List<Booking>> bookingOptional = bookingRepository.findAllByStatus(status);

		if (bookingOptional.isPresent()) {
			List<Booking> bookings = bookingOptional.get();
			return bookings;
		} else {
			throw new ClientException("No bookings matching '" + status + "' status");
		}

	}

	public List<Booking> getBookingsByStatusForUser(BookingStatus status, String userId) {

		Optional<List<Booking>> bookingOptional = bookingRepository.findAllByStatusAndUserId(status, userId);

		if (bookingOptional.isPresent()) {
			List<Booking> bookings = bookingOptional.get();
			return bookings;
		} else {
			throw new ClientException(
					"No bookings matching '" + status + "' status for provided user '" + userId + "'.");
		}

	}

	public List<Booking> getBookingsByDriverId(String driverId) {
		Optional<List<Booking>> bookingOptional = bookingRepository.findAllByAssinedDriver(driverId);

		if (bookingOptional.isPresent()) {
			List<Booking> bookings = bookingOptional.get();
			return bookings;
		} else {
			throw new ClientException("No bookings matching assigned driver '" + driverId + "'.");
		}
	}

	public List<Booking> getBookingByUserId(String userId) {
		Optional<List<Booking>> bookingOptional = bookingRepository.findAllByUserId(userId);

		if (bookingOptional.isPresent()) {
			List<Booking> bookings = bookingOptional.get();
			return bookings;
		} else {
			throw new ClientException("No bookings matching assigned driver '" + userId + "'.");
		}
	}

	@Transactional
	public Booking cancelBooking(String bookingId, String userId) {
		Booking booking = getBookingById(bookingId);
		if (booking.getBookingId() != null && booking.getStatus() != BookingStatus.CANCELLED
				&& booking.getUserId().equals(userId) && booking.getStatus() != BookingStatus.COMPLETE) {

			booking.setStatus(BookingStatus.CANCELLED);
			return booking;
		} else {
			if (booking.getStatus().equals(BookingStatus.COMPLETE)) {
				throw new ClientException("This is booking is completed and cant be edited.");
			} else {
				throw new ClientException("Something went wrong, please try again");
			}
		}
	}

}
