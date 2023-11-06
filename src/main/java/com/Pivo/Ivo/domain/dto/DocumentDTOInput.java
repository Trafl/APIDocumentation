package com.Pivo.Ivo.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record DocumentDTOInput(
		
		@NotBlank
		@Schema(example = "Document 01")
		String title,
		
		@NotBlank
		@Schema(example = "Lorem ipsum dolor sit amet. A provident consequatur aut earum totam aut veritatis Quis aut placeat sunt ex fuga quisquam! Est corporis rerum non dicta reiciendis ab provident sint sed molestiae alias! Ut assumenda tempore et consequatur dolore eum cupiditate mollitia ut neque consequatur.")
		String text
		
		) {}
