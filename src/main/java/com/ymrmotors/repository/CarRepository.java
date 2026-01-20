package com.ymrmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymrmotors.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}