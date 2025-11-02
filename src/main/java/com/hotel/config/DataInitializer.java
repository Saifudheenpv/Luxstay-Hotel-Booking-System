package com.hotel.config;

import com.hotel.model.Hotel;
import com.hotel.model.Room;
import com.hotel.model.User;
import com.hotel.repository.HotelRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.UserRepository;
import com.hotel.util.SimplePasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private HotelRepository hotelRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Autowired
    private SimplePasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        logger.info("=== DataInitializer started ===");
        
        // Create sample users
        createUsers();
        
        // Create sample hotels
        createHotels();
        
        // Create rooms for hotels
        createRoomsForHotels();
        
        logger.info("=== DataInitializer completed ===");
        logger.info("Total users: {}", userRepository.count());
        logger.info("Total hotels: {}", hotelRepository.count());
        logger.info("Total rooms: {}", roomRepository.count());
    }

    private void createUsers() {
        if (userRepository.count() == 0) {
            logger.info("Creating sample users...");
            
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEmail("admin@hotel.com");
            admin.setFirstName("System");
            admin.setLastName("Administrator");
            admin.setPhone("+1234567890");
            admin.setAddress("Hotel Management System");
            userRepository.save(admin);
            
            User john = new User();
            john.setUsername("john_doe");
            john.setPassword(passwordEncoder.encode("password123"));
            john.setEmail("john.doe@email.com");
            john.setFirstName("John");
            john.setLastName("Doe");
            john.setPhone("+1987654321");
            john.setAddress("123 Main St, New York, NY");
            userRepository.save(john);

            User sarah = new User();
            sarah.setUsername("sarah_williams");
            sarah.setPassword(passwordEncoder.encode("sarah123"));
            sarah.setEmail("sarah.williams@email.com");
            sarah.setFirstName("Sarah");
            sarah.setLastName("Williams");
            sarah.setPhone("+1654321890");
            sarah.setAddress("456 Park Ave, Los Angeles, CA");
            userRepository.save(sarah);
            
            logger.info("Created {} users", userRepository.count());
        } else {
            logger.info("Users already exist, skipping user creation");
        }
    }

    private void createHotels() {
        if (hotelRepository.count() == 0) {
            logger.info("Creating sample hotels...");
            
            try {
                // Hotel 1: Luxury Beach Resort
                Hotel hotel1 = createHotel(
                    "Grand Marina Resort",
                    "Experience luxury at its finest with our beachfront resort featuring world-class amenities, spa services, and gourmet dining. Perfect for romantic getaways and family vacations.",
                    "123 Ocean Drive, Miami Beach",
                    "Miami", "USA", "+1-305-123-4567", "info@grandmarina.com",
                    "https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.8, 5
                );
                
                // Hotel 2: Business Hotel
                Hotel hotel2 = createHotel(
                    "Metropolitan Suites",
                    "Perfect for business travelers, our downtown hotel offers modern amenities, conference facilities, and easy access to business districts. Free high-speed WiFi and business center.",
                    "456 Business Avenue, Manhattan",
                    "New York", "USA", "+1-212-987-6543", "reservations@metropolitansuites.com",
                    "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.5, 4
                );
                
                // REPLACEMENT HOTEL: Luxury City Hotel instead of Alpine Mountain Lodge
                Hotel hotel3 = createHotel(
                    "Royal Plaza Hotel",
                    "Experience urban luxury in the heart of the city with sophisticated accommodations, fine dining, and premium services for the discerning traveler.",
                    "789 Central Boulevard, Chicago",
                    "Chicago", "USA", "+1-312-555-7890", "reservations@royalplaza.com",
                    "https://images.unsplash.com/photo-1584132967334-10e028bd69f7?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.6, 5
                );

                // Hotel 4: Urban Boutique Hotel
                Hotel hotel4 = createHotel(
                    "The Urban Boutique",
                    "A stylish boutique hotel in the heart of the city featuring contemporary design, art exhibitions, and a rooftop bar with panoramic city views.",
                    "321 Arts District, San Francisco",
                    "San Francisco", "USA", "+1-415-555-0123", "hello@urbanboutique.com",
                    "https://images.unsplash.com/photo-1586375300773-8384e3e4916f?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.6, 4
                );

                // Hotel 5: Luxury Desert Resort
                Hotel hotel5 = createHotel(
                    "Oasis Desert Resort",
                    "An exclusive desert retreat featuring private villas, infinity pools, spa treatments, and stunning desert landscapes. Perfect for wellness retreats.",
                    "555 Desert Oasis Road, Scottsdale",
                    "Scottsdale", "USA", "+1-480-777-8888", "reservations@oasisresort.com",
                    "https://images.unsplash.com/photo-1542314831-068cd1dbfeeb?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.9, 5
                );

                // Hotel 6: Historic City Hotel
                Hotel hotel6 = createHotel(
                    "The Grand Heritage",
                    "A beautifully restored historic hotel offering classic elegance with modern comforts. Located in the historic district with period architecture.",
                    "888 Heritage Square, Boston",
                    "Boston", "USA", "+1-617-444-5555", "info@grandheritage.com",
                    "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.7, 5
                );

                // Hotel 7: Beachfront Paradise
                Hotel hotel7 = createHotel(
                    "Paradise Beach Resort",
                    "Direct beach access, water sports, multiple pools, and tropical gardens. Family-friendly resort with kids club and entertainment.",
                    "777 Beach Boulevard, Honolulu",
                    "Honolulu", "USA", "+1-808-222-3333", "aloha@paradiseresort.com",
                    "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.8, 4
                );

                // Hotel 8: Modern Business Hotel
                Hotel hotel8 = createHotel(
                    "Tech Tower Hotel",
                    "Ultra-modern hotel designed for tech professionals featuring smart rooms, coworking spaces, and high-tech meeting facilities.",
                    "444 Innovation Drive, Seattle",
                    "Seattle", "USA", "+1-206-777-9999", "stay@techtower.com",
                    "https://images.unsplash.com/photo-1564501049412-61c2a3083791?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.4, 4
                );

                // Hotel 9: Romantic Getaway
                Hotel hotel9 = createHotel(
                    "Serenity Retreat",
                    "Intimate adults-only resort offering privacy, luxury suites with private pools, and personalized service for romantic escapes.",
                    "222 Lovers Lane, Napa Valley",
                    "Napa", "USA", "+1-707-333-4444", "romance@serenityretreat.com",
                    "https://images.unsplash.com/photo-1522798514-97ceb8c4f1c8?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.9, 5
                );

                // Hotel 10: Family Resort
                Hotel hotel10 = createHotel(
                    "Family Fun Resort",
                    "The ultimate family destination with water parks, kids activities, family suites, and all-inclusive dining options.",
                    "999 Family Avenue, Orlando",
                    "Orlando", "USA", "+1-407-888-0000", "fun@familyresort.com",
                    "https://images.unsplash.com/photo-1571896349842-33c89424de2d?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80",
                    4.6, 4
                );

                // Save all hotels
                hotelRepository.saveAll(Arrays.asList(hotel1, hotel2, hotel3, hotel4, hotel5, 
                                                     hotel6, hotel7, hotel8, hotel9, hotel10));
                
                logger.info("Successfully created {} hotels", hotelRepository.count());
                
            } catch (Exception e) {
                logger.error("Error creating hotels: ", e);
            }
        } else {
            logger.info("Hotels already exist, skipping hotel creation. Current count: {}", hotelRepository.count());
        }
    }

    private Hotel createHotel(String name, String description, String address, String city, 
                             String country, String phone, String email, String imageUrl, 
                             Double rating, Integer starRating) {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setDescription(description);
        hotel.setAddress(address);
        hotel.setCity(city);
        hotel.setCountry(country);
        hotel.setPhone(phone);
        hotel.setEmail(email);
        hotel.setImageUrl(imageUrl);
        hotel.setRating(rating);
        hotel.setStarRating(starRating);
        return hotel;
    }

    private void createRoomsForHotels() {
        if (roomRepository.count() == 0) {
            logger.info("Creating rooms for hotels...");
            
            try {
                List<Hotel> hotels = hotelRepository.findAll();
                logger.info("Found {} hotels to create rooms for", hotels.size());
                
                for (Hotel hotel : hotels) {
                    logger.info("Creating rooms for hotel: {}", hotel.getName());
                    
                    // Create simple rooms first to avoid complex logic errors
                    createSimpleRooms(hotel);
                }
                
                logger.info("Successfully created rooms for all hotels");
                
            } catch (Exception e) {
                logger.error("Error creating rooms: ", e);
            }
        } else {
            logger.info("Rooms already exist, skipping room creation");
        }
    }

    private void createSimpleRooms(Hotel hotel) {
        try {
            // Create 2-3 simple rooms per hotel
            Room room1 = new Room();
            room1.setRoomNumber("101");
            room1.setType("Standard Room");
            room1.setPrice(199.00);
            room1.setDescription("Comfortable standard room with all basic amenities");
            room1.setCapacity(2);
            room1.setAvailable(true);
            room1.setAmenities("WiFi,TV,AC");
            room1.setImageUrl("https://images.unsplash.com/photo-1631049307264-da0ec9d70304?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80");
            room1.setHotel(hotel);
            
            Room room2 = new Room();
            room2.setRoomNumber("102");
            room2.setType("Deluxe Room");
            room2.setPrice(299.00);
            room2.setDescription("Spacious deluxe room with premium amenities");
            room2.setCapacity(2);
            room2.setAvailable(true);
            room2.setAmenities("WiFi,TV,Minibar,AC");
            room2.setImageUrl("https://images.unsplash.com/photo-1590490360182-c33d57733427?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80");
            room2.setHotel(hotel);
            
            Room room3 = new Room();
            room3.setRoomNumber("201");
            room3.setType("Suite");
            room3.setPrice(499.00);
            room3.setDescription("Luxurious suite with separate living area");
            room3.setCapacity(3);
            room3.setAvailable(true);
            room3.setAmenities("WiFi,TV,Minibar,AC,Living Room");
            room3.setImageUrl("https://images.unsplash.com/photo-1566665797739-1674de7a421a?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80");
            room3.setHotel(hotel);
            
            roomRepository.saveAll(Arrays.asList(room1, room2, room3));
            
        } catch (Exception e) {
            logger.error("Error creating rooms for hotel {}: {}", hotel.getName(), e.getMessage());
        }
    }
}