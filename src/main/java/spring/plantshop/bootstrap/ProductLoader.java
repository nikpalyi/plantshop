package spring.plantshop.bootstrap;

import spring.plantshop.domain.Product;
import spring.plantshop.repositories.ProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = LogManager.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("ZZ Plant (Zanzibar Gem");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://www.thespruce.com/thmb/HktOLOzDO1hEqs_YG62Bn1jKruk=/960x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/zz-zanzibar-gem-plant-profile-4796783-02-e80e5506091f4dcfb226c5a21718deb6.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved ZZ Plant - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("SWISS CHEESE PLANT (MONSTERA)");
        mug.setImageUrl("https://greenlifestylestore.nl/wp-content/uploads/2020/03/Monstera-deliciosa-%C3%98215.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Swiss Cheese Plant - id:" + mug.getId());
    }
}
