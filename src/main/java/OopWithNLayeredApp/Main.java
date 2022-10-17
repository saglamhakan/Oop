package OopWithNLayeredApp;

import OopWithNLayeredApp.business.ProductManagerService;
import OopWithNLayeredApp.core.logging.DatabaseLogger;
import OopWithNLayeredApp.core.logging.FileLogger;
import OopWithNLayeredApp.core.logging.Logger;
import OopWithNLayeredApp.core.logging.MailLogger;
import OopWithNLayeredApp.dataaccess.HibernateProductDao;
import OopWithNLayeredApp.dataaccess.JdbcProductDao;
import OopWithNLayeredApp.entities.Product;

public class Main {
    public static void main(String[] args) throws Exception {
        Product product1=new Product(1, "Iphone Xr", 10000);
        Logger[] loggers={new DatabaseLogger(), new FileLogger(), new MailLogger()};

        ProductManagerService productManagerService=new ProductManagerService(new JdbcProductDao(), loggers);
        productManagerService.add(product1);

    }
}
