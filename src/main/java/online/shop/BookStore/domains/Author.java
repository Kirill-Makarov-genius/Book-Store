package online.shop.BookStore.domains;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name="authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Enter author's full name")
	@Size(max=50, message="Name can not exceed 50 characters")
	@Column(name="full_name")
	private String fullName;
	
	@NotNull(message="Enter author's date of birth")
	@DateTimeFormat(pattern="dd-MM-YY")
	@Column(name="date_birth")
	private Date dateBirth;
	
	@NotNull(message="Enter author's date of death")
	@DateTimeFormat(pattern="dd-MM-YY")
	@Column(name="date_death")
	private Date dateDeath;
	
	@NotNull
	@OneToMany(mappedBy="author")
	private Set<Book> books;
	
}
