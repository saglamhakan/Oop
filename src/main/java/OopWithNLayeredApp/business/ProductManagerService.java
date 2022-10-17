package OopWithNLayeredApp.business;

import OopWithNLayeredApp.core.logging.DatabaseLogger;
import OopWithNLayeredApp.core.logging.Logger;
import OopWithNLayeredApp.dataaccess.JdbcProductDao;
import OopWithNLayeredApp.dataaccess.ProductDao;
import OopWithNLayeredApp.entities.Product;

import java.util.List;

public class ProductManagerService {
    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManagerService(JdbcProductDao jdbcProductDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers=loggers;
    }

    public void add(Product product) throws Exception {
        //İş kuralları
        if (product.getUnitPrice() < 10) {
            throw new Exception("Ürün fiyatı 10 dan aşağı olamaz.");
        }
        JdbcProductDao productDao = new JdbcProductDao();
        productDao.add(product);
        for(Logger logger:loggers){
            logger.log(product.getName());
        }

    }
}
