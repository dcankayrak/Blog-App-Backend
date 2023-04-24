package com.dcankayrak.blogapp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateRequest {

	private String title;
	private int categoryId;
	private String text;
	private String image;
}
