package com.hotel.model;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String roomNumber;
    
    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private Double price;
    
    private String description;
    private Integer capacity;
    private Boolean available;
    private String amenities;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    // Constructors
    public Room() {
        this.available = true;
    }
    
    public Room(String roomNumber, String type, Double price, String description, 
                Integer capacity, Boolean available, String amenities, String imageUrl, Hotel hotel) {
        this();
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.description = description;
        this.capacity = capacity;
        this.available = available;
        this.amenities = amenities;
        this.imageUrl = imageUrl;
        this.hotel = hotel;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
    
    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }
}
