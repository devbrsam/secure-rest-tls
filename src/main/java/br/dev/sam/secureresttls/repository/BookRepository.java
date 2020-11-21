package br.dev.sam.secureresttls.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.dev.sam.secureresttls.domain.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {}