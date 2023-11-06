package com.Pivo.Ivo.domain.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

public record DocumentDTOOutput(
		
		@Schema(example = "Document 01")
		String title,
		
		@Schema(example = "Lorem ipsum dolor sit amet. A provident consequatur aut earum totam aut veritatis Quis aut placeat sunt ex fuga quisquam! Est corporis rerum non dicta reiciendis ab provident sint sed molestiae alias! Ut assumenda tempore et consequatur dolore eum cupiditate mollitia ut neque consequatur.")
		String text,
		
		@Schema(example = "2023-10-16T19:32:54.253417400Z")
		LocalDate created
		
		) {

}
