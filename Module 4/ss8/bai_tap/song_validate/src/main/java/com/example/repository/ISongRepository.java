package com.example.repository;

import com.example.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ISongRepository extends JpaRepository<Song,Integer> {
}
