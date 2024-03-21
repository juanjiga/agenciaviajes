package es.juanjiga.agenciaviajes;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.juanjiga.agenciaviajes.domain.repositories.CustomerRepository;
import es.juanjiga.agenciaviajes.domain.repositories.FlyRepository;
import es.juanjiga.agenciaviajes.domain.repositories.HotelRepository;
import es.juanjiga.agenciaviajes.domain.repositories.ReservationRepository;
import es.juanjiga.agenciaviajes.domain.repositories.TicketRepository;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
public class AgenciaviajesApplication implements CommandLineRunner{

	private final HotelRepository hotelRepository;
	private final FlyRepository flyRepository;
	private final TicketRepository ticketRepository;
	private final ReservationRepository reservationRepository;
	private final CustomerRepository customerRepository;
	
	public AgenciaviajesApplication(HotelRepository hotelRepository, FlyRepository flyRepository,
			TicketRepository ticketRepository, ReservationRepository reservationRepository,
			CustomerRepository customerRepository) {
		this.hotelRepository = hotelRepository;
		this.flyRepository = flyRepository;
		this.ticketRepository = ticketRepository;
		this.reservationRepository = reservationRepository;
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AgenciaviajesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var fly = flyRepository.findById(10L).get();

		var hotel = hotelRepository.findById(9L).get();

		//var ticket = ticketRepository.findById(UUID.fromString("22345678-1234-5678-3235-567812345678")).get();

		//var reservation = reservationRepository.findById(UUID.fromString("32345678-1234-5678-1234-567812345678")).get();
		
		//var customer = customerRepository.findById("GOTW771012HMRGR087").get();

		log.info(String.valueOf(fly));

		log.info(String.valueOf(hotel));

		//log.info(String.valueOf(ticket));

		//log.info(String.valueOf(reservation));

		//log.info(String.valueOf(customer));

		System.out.println(".....Vuelos con precio menor de 15 dolares");
		this.flyRepository.selectLessPrice(BigDecimal.valueOf(15)).forEach(f -> System.out.println(f));
		System.out.println(".....Vuelos entre 10 y 20 dolares");
		this.flyRepository.selectBetweenPrice(BigDecimal.valueOf(10), BigDecimal.valueOf(20)).forEach(System.out::println);
		System.out.println(".....Vuelos entre Grecia y Mexico");
		this.flyRepository.selectOriginDestiny("Grecia", "Mexico").forEach(System.out::println);
		System.out.println(".....Vuelos con origen en Canada");
		this.flyRepository.selectOrigin("Canada").forEach(System.out::println);
		System.out.println(".....Vuelos con destino en Islandia");
		this.flyRepository.selectDestiny("Iceland").forEach(System.out::println);

		System.out.println(".....Hoteles con precio menor de 100 dolares");
	    hotelRepository.findByPriceLessThan(BigDecimal.valueOf(100)).forEach(System.out::println);
		System.out.println(".....Hoteles con precio entre de 100 y 200 dolares");
		hotelRepository.findByPriceBetween(BigDecimal.valueOf(100), BigDecimal.valueOf(200)).forEach(System.out::println);
		System.out.println(":::::::::::::::...Hoteles con mas de 4 estrellas");
		hotelRepository.findByRatingGreaterThan(4).forEach(System.out::println);

		var fly2 = flyRepository.findById(1L).get();
		System.out.println(fly2);

		fly2.getTickets().forEach(ticket -> System.out.println(ticket));

		System.out.println("::::::::::::::::::::::::::::::::::::::::::::");

		

		
	}

	

}
