package com.dcankayrak.blogapp.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
	
	private int id;
	private int categoryId;
	private String title;
	private String text;
}
