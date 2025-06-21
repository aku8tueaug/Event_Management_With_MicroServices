package com.pluralsight.springboot.events_service.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganiserRepository extends JpaRepository<Organiser,Integer> {
//    private final List<Organiser> organizers = List.of(
//            new Organiser(101, "Globomantics", "Globomantics Technology Corporation"),
//            new Organiser(102, "Carved Rock", "Carved Rock Sports Equipment"));
//
//    public List<Organiser> findAll() {
//        return organizers;
//    }
}
