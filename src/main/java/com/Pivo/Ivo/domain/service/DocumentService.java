package com.Pivo.Ivo.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.Pivo.Ivo.domain.dto.DocumentDTOInput;
import com.Pivo.Ivo.domain.dto.DocumentDTOOutput;
import com.Pivo.Ivo.domain.model.Document;
import com.Pivo.Ivo.domain.repository.DocumentRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentService {

	private final DocumentRepository repository;
	
	
	public List<DocumentDTOOutput> getAllDocuments() {
		var documents = repository.findAll();
		
		List<DocumentDTOOutput> documentsDto = documents.stream()
			.map(document -> toDto(document)).toList();
		
		return documentsDto;
	}
	
	public DocumentDTOOutput createdDocument(DocumentDTOInput documentDto) {
		var document = toDomain(documentDto);
		
		document = repository.save(document);
		
		var documentDtoOut = toDto(document);
		
		return documentDtoOut;
	}

	private Document toDomain(DocumentDTOInput documentDto) {
		var document = new Document();
		document.setTitle(documentDto.title());
		document.setText(documentDto.text());
		return document;
	}

	private DocumentDTOOutput toDto(Document document) {
		var documentDtoOut = new DocumentDTOOutput(document.getText(), document.getTitle(), document.getCreated());
		return documentDtoOut;
	}

	public DocumentDTOOutput updateDocument(Long documentId, DocumentDTOInput documentDto) {
		
		var document = repository.findById(documentId).orElseThrow(()-> new EntityNotFoundException());
		
		BeanUtils.copyProperties(documentDto, document,"id");
		
		repository.save(document);
		
		return toDto(document);
	}
	
	public void deleteDocument(Long documentId) {
		repository.deleteById(documentId);
	}
}
