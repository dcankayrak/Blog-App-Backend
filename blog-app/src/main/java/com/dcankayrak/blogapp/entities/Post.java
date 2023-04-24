package com.dcankayrak.blogapp.entities;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post",schema = "public")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "upload_date")
	private LocalDate uploadDate;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "post",cascade = CascadeType.ALL)
	@Column(name = "comments")
	private List<Comment> comments;
	
}
