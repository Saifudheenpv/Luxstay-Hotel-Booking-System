package com.hotel.config;

import com.hotel.model.Hotel;
import com.hotel.model.Room;
import com.hotel.model.User;
import com.hotel.repository.HotelRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.UserRepository;
import com.hotel.util.SimplePasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    
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
        // Create sample users
        if (userRepository.count() == 0) {
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
        }
        
        // Create sample hotels
        if (hotelRepository.count() == 0) {
            // Hotel 1: Luxury Beach Resort
            Hotel hotel1 = new Hotel();
            hotel1.setName("Grand Marina Resort");
            hotel1.setDescription("Experience luxury at its finest with our beachfront resort featuring world-class amenities, spa services, and gourmet dining.");
            hotel1.setAddress("123 Ocean Drive, Miami Beach");
            hotel1.setCity("Miami");
            hotel1.setCountry("USA");
            hotel1.setPhone("+1-305-123-4567");
            hotel1.setEmail("info@grandmarina.com");
            hotel1.setImageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80");
            hotel1.setRating(4.8);
            hotel1.setStarRating(5);
            hotelRepository.save(hotel1);
            
            // Hotel 2: Business Hotel
            Hotel hotel2 = new Hotel();
            hotel2.setName("Metropolitan Suites");
            hotel2.setDescription("Perfect for business travelers, our downtown hotel offers modern amenities, conference facilities, and easy access to business districts.");
            hotel2.setAddress("456 Business Avenue, Manhattan");
            hotel2.setCity("New York");
            hotel2.setCountry("USA");
            hotel2.setPhone("+1-212-987-6543");
            hotel2.setEmail("reservations@metropolitansuites.com");
            hotel2.setImageUrl("https://images.unsplash.com/photo-1551882547-ff40c63fe5fa?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80");
            hotel2.setRating(4.5);
            hotel2.setStarRating(4);
            hotelRepository.save(hotel2);
            
            // Hotel 3: Mountain Retreat
            Hotel hotel3 = new Hotel();
            hotel3.setName("Alpine Mountain Lodge");
            hotel3.setDescription("Escape to nature in our cozy mountain lodge featuring breathtaking views, outdoor activities, and rustic luxury.");
            hotel3.setAddress("789 Mountain Road, Aspen");
            hotel3.setCity("Aspen");
            hotel3.setCountry("USA");
            hotel3.setPhone("+1-970-456-7890");
            hotel3.setEmail("stay@alpinelodge.com");
            hotel3.setImageUrl("https://images.unsplash.com/photo-1596394516093-9ba7a5f3b5a1?ixlib=rb-4.0.3&auto=format&fit=crop&w=1200&q=80");
            hotel3.setRating(4.7);
            hotel3.setStarRating(4);
            hotelRepository.save(hotel3);
            
            // Create rooms for hotel1
            Room room1 = new Room("101", "Deluxe Ocean View", 299.00, 
                "Spacious room with king bed and private balcony overlooking the ocean", 
                2, true, "WiFi,TV,Minibar,AC,Ocean View,Balcony", 
                "https://images.unsplash.com/photo-1611892440504-42a792e24d32?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel1);
            
            Room room2 = new Room("102", "Premium Suite", 499.00, 
                "Luxurious suite with separate living area and jacuzzi", 
                3, true, "WiFi,TV,Minibar,AC,Jacuzzi,Living Room", 
                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel1);
            
            Room room3 = new Room("201", "Standard Room", 199.00, 
                "Comfortable room with queen bed and garden view", 
                2, true, "WiFi,TV,AC", 
                "https://images.unsplash.com/photo-1631049307264-da0ec9d70304?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel1);
            
            // Create rooms for hotel2
            Room room4 = new Room("301", "Executive Room", 349.00, 
                "Modern room designed for business travelers with work desk", 
                2, true, "WiFi,TV,Minibar,AC,Work Desk", 
                "https://images.unsplash.com/photo-1566665797739-1674de7a421a?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel2);
            
            Room room5 = new Room("302", "Conference Suite", 599.00, 
                "Large suite with meeting area and conference facilities", 
                4, true, "WiFi,TV,Minibar,AC,Conference Table", 
                "https://images.unsplash.com/photo-1590490360182-c33d57733427?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel2);
            
            Room room6 = new Room("303", "Standard Business", 279.00, 
                "Comfortable room with all essential business amenities", 
                2, true, "WiFi,TV,AC,Work Desk", 
                "https://images.unsplash.com/photo-1559599189-fe84dea4eb79?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel2);
            
            // Create rooms for hotel3
            Room room7 = new Room("401", "Mountain View Suite", 399.00, 
                "Cozy suite with fireplace and stunning mountain views", 
                2, true, "WiFi,TV,Fireplace,AC,Mountain View,Balcony", 
                "https://images.unsplash.com/photo-1595526051245-4506e0005bd0?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel3);
            
            Room room8 = new Room("402", "Family Cabin", 459.00, 
                "Spacious cabin perfect for families with separate bedrooms", 
                4, true, "WiFi,TV,Fireplace,AC,Kitchenette", 
                "https://images.unsplash.com/photo-1445019980597-93fa8acb246c?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel3);
            
            Room room9 = new Room("403", "Standard Mountain Room", 259.00, 
                "Comfortable room with all essential amenities", 
                2, true, "WiFi,TV,AC", 
                "https://images.unsplash.com/photo-1590490360182-c33d57733427?ixlib=rb-4.0.3&auto=format&fit=crop&w=600&q=80", hotel3);
            
            roomRepository.saveAll(Arrays.asList(room1, room2, room3, room4, room5, room6, room7, room8, room9));
        }
    }
}
