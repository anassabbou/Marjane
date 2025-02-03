package com.abbou.marjane.repository;


import com.abbou.marjane.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
