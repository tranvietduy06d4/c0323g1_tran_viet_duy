package com.example.service;

import com.example.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    void createSong(Song song);

    Song findById(int id);

    void updateSong(Song song);
}
