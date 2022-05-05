package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Product;
import ru.gb.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processForm(Product product, Model model) {
            model.addAttribute("productList", productService.save(product));
        return "product-list";
    }

    //localhost:8080/spring/message/{id}?random=true
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductId(Model model, @PathVariable Integer id) {
        model.addAttribute("productId", productService.findById(id));
        return "productId";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "product-list";
    }

//    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
//    public String getIdDelete(Model model, @PathVariable Integer id) {
//        productService.deleteById(id);
//        model.addAttribute("productList", productService.findAll());
//        return "product-list";
//    }

}
