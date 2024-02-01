package Services;

import Models.Product;
import Repository.ProductRepository;

import java.util.List;

public class ProductService extends Service<Product>{

    public ProductService(){
        super(new ProductRepository(Product.class));
    }

    public List<Product> searchByName(String keyword) {
        return ((ProductRepository) repository).searchByName(keyword);
    }

    public List<Product> searchByModel(String keyword) {
        return ((ProductRepository) repository).searchByModel(keyword);
    }

    public List<Product> searchByTechChar(String keyword) {
        return ((ProductRepository) repository).searchByTechChar(keyword);
    }

    public List<Product> searchByPrice(String keyword) {
        return ((ProductRepository) repository).searchByPrice(keyword);
    }

    public List<Product> searchByGuarantee(String keyword) {
        return ((ProductRepository) repository).searchByGuarantee(keyword);
    }
}
