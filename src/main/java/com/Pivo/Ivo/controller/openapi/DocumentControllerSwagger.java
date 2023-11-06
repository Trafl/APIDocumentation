package com.Pivo.Ivo.controller.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.Pivo.Ivo.domain.dto.DocumentDTOInput;
import com.Pivo.Ivo.domain.dto.DocumentDTOOutput;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Documents", description = "Document manager")
public interface DocumentControllerSwagger {

	@Operation(summary = "List the documents", description = "Lists documents registered in the database.")
	public ResponseEntity<List<DocumentDTOOutput>> getDocuments();

	@Operation(summary = "Register a document", description ="Registers a document in the database.", 
		responses = {
			@ApiResponse(responseCode = "400", description = "Error validating the fields entered",
					content = @Content(schema = @Schema(ref = "ProblemDetail"))) })
	public ResponseEntity<DocumentDTOOutput> createdDocument(DocumentDTOInput documentInput);

	 @Operation(summary = "Update a document", description = "Updates a document in the database.",
			 responses = {
					  @ApiResponse(responseCode = "200"),
				 	  
					  @ApiResponse(responseCode = "400", description = "Error validating the fields entered",
				 	  content = @Content(schema = @Schema(ref = "ProblemDetail"))),
				 	  
				 	  @ApiResponse(responseCode = "404", description = "Document not found",
				 	  content = @Content(schema = @Schema(ref = "ProblemDetail")))
		})
	public ResponseEntity<DocumentDTOOutput> updateDocumentById(@PathVariable Long documentId,
			DocumentDTOInput documentInput);

	 @Operation(summary = "Delete a document", description = "Delete a document in the database.",
			 responses = {
					 @ApiResponse(responseCode = "204"),
				 	  
					 @ApiResponse(responseCode = "400", description = "Error validating the fields entered",
				 	  content = @Content(schema = @Schema(ref = "ProblemDetail"))),
				 	  
				 	  @ApiResponse(responseCode = "404", description = "Document not found",
				 	  content = @Content(schema = @Schema(ref = "ProblemDetail")))
					})
	public ResponseEntity<Void> deleteDocument(Long documentId);
}
