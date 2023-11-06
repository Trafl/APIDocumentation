package com.Pivo.Ivo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Pivo.Ivo.controller.openapi.DocumentControllerSwagger;
import com.Pivo.Ivo.domain.dto.DocumentDTOInput;
import com.Pivo.Ivo.domain.dto.DocumentDTOOutput;
import com.Pivo.Ivo.domain.service.DocumentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController implements DocumentControllerSwagger {

	private final DocumentService service;

	@GetMapping
	public ResponseEntity<List<DocumentDTOOutput>> getDocuments() {

		var documents = service.getAllDocuments();

		return ResponseEntity.ok(documents);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<DocumentDTOOutput> createdDocument(@Valid @RequestBody DocumentDTOInput documentInput) {

		var document = service.createdDocument(documentInput);

		ResponseEntity.ok(document);
		return ResponseEntity.status(201).build();
	}

	@PutMapping("/{documentId}")
	public ResponseEntity<DocumentDTOOutput> updateDocumentById(@PathVariable Long documentId,
			@Valid @RequestBody DocumentDTOInput documentInput) {

		var document = service.updateDocument(documentId, documentInput);

		return ResponseEntity.ok(document);
	}

	@DeleteMapping("/{documentId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteDocument(@PathVariable Long documentId) {

		service.deleteDocument(documentId);

		return ResponseEntity.noContent().build();
	}
}
