package ru.gb.web.category.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.web.category.domain.Category;
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
