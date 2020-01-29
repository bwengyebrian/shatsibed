package com.shatsi.bed.mainservice.domain.controller;

import com.shatsi.bed.mainservice.domain.model.Apartment;
import com.shatsi.bed.mainservice.domain.model.ApartmentByUser;
import com.shatsi.bed.mainservice.domain.model.User;
import com.shatsi.bed.mainservice.domain.repository.ApartmentByUserRepository;
import com.shatsi.bed.mainservice.domain.repository.ApartmentRepository;
import com.shatsi.bed.mainservice.domain.repository.ApartmentRepositoryImpl;
import com.shatsi.bed.mainservice.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class HomeController {
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ApartmentByUserRepository apartmentByUserRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    List<Apartment> home(){
        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setFirstName("Brian");
        user.setFirstName("Bwengye");
        userRepository.save(user);
        Apartment apartment = new Apartment();
        apartment.setId(UUID.randomUUID());
        apartment.setApartmentId("AP0001");
        apartment.setTitle("Brians Best apartments");
        apartment.setDetails("Great with One room, self contained ");
        apartment.setLocation("Fairfield Iowa");
        apartment.setCreated(LocalDateTime.now());
        apartment.setImageUrl("");
        apartment.setOwner(user);
        apartmentRepository.insert(apartment);
        return apartmentRepository.findAll();
    }
    @GetMapping("/user/{id}")
    List<ApartmentByUser> apartmentsByUser(@PathVariable UUID id ){
        System.out.println();
        return apartmentByUserRepository.findApartmentByKeyUserId(id);
    }
    @GetMapping("/users")
    List<User> getUsers(){
        return userRepository.findAll();
    }
}
