package ru.gb.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.repository.EntityManagerProductDao;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final EntityManagerProductDao managerProductDao;

    public List<Product> save(Product product) {
        managerProductDao.save(product);
        return findAll();
    }


    public Product findById(Integer id) {
        return managerProductDao.findById(id);
    }

    public List<Product> findAll() {
        return managerProductDao.findAll();
    }

}
