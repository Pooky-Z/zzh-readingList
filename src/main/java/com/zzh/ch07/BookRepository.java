package com.zzh.ch07;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findAllByReader(String reader);
}
