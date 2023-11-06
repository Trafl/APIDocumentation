package com.Pivo.Ivo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pivo.Ivo.domain.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
