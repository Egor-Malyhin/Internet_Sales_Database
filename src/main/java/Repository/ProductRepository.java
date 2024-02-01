package Repository;

import Models.Product;

import java.util.List;

public class ProductRepository extends Repository<Product> {
    public ProductRepository(Class <Product> entity) {
        super(entity);
    }
    public List<Product> searchByName(String keyword) {
        return findByCell("name", keyword);
    }

    public List<Product> searchByModel(String keyword) {
        return findByCell("model", keyword);
    }

    public List<Product> searchByTechChar(String keyword) {
        return findByCell("tech_char", keyword);
    }

    public List<Product> searchByPrice(String keyword) {
        return findByCell("price", keyword);
    }

    public List<Product> searchByGuarantee(String keyword) {
        return findByCell("guarantee_period", keyword);
    }
}
