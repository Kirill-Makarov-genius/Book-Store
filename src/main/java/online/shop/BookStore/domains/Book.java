package online.shop.BookStore.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="The book should have name")
	@Size(max=50, message="Book's name should be less 50 letters")
	@Column(name="name")
	private String name;
	
	@NotNull(message="The book should have bookcover")
	@Column(name="bookcover")
	private String bookcover;
	

	@NotNull(message="The book should have overview")
	@Size(min=100, max=2000, message="length of overview should between 100 and 2000 characters")
	@Column(name="overview")
	private String overview;
	
	
	
	@ManyToOne
	@JoinColumn(name="author")
	private Author author;
	
	
}
