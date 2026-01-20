package com.ymrmotors.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String make;
    
    @Column(nullable = false)
    private String model;
    
    @JsonProperty("year")  // 👈 This is the key addition!
    @Column(name = "manufacture_year", nullable = false)
    private Integer manufactureYear;
    
    @Column(nullable = false)
    private Double price;
    
    @Column(nullable = false)
    private Integer mileage;
    
    @Column(nullable = false)
    private String color;
    
    // Default constructor
    public Car() {}
    
    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public String getMake() { 
        return make; 
    }
    
    public void setMake(String make) { 
        this.make = make; 
    }
    
    public String getModel() { 
        return model; 
    }
    
    public void setModel(String model) { 
        this.model = model; 
    }
    
    public Integer getManufactureYear() { 
        return manufactureYear; 
    }
    
    public void setManufactureYear(Integer manufactureYear) { 
        this.manufactureYear = manufactureYear; 
    }
    
    public Double getPrice() { 
        return price; 
    }
    
    public void setPrice(Double price) { 
        this.price = price; 
    }
    
    public Integer getMileage() { 
        return mileage; 
    }
    
    public void setMileage(Integer mileage) { 
        this.mileage = mileage; 
    }
    
    public String getColor() { 
        return color; 
    }
    
    public void setColor(String color) { 
        this.color = color; 
    }
}