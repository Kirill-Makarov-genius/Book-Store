package online.shop.BookStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import online.shop.BookStore.domains.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
