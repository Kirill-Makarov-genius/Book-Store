package online.shop.BookStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import online.shop.BookStore.domains.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	
}
