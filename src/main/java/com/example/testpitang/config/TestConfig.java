package com.example.testpitang.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.testpitang.entities.Category;
import com.example.testpitang.entities.Order;
import com.example.testpitang.entities.OrderItem;
import com.example.testpitang.entities.Product;
import com.example.testpitang.entities.User;
import com.example.testpitang.entities.enums.OrderStatus;
import com.example.testpitang.repositories.CategoryRepository;
import com.example.testpitang.repositories.OrderItemRepository;
import com.example.testpitang.repositories.OrderRepository;
import com.example.testpitang.repositories.ProductRepository;
import com.example.testpitang.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletrodomesticos");
		Category cat2 = new Category(null, "Celulares");
		Category cat3 = new Category(null, "Games"); 
		
		Product p1 = new Product(null, "Xiaomi Mi 9", "Camera 22mgpx, 16gb RAM, Processador Snapdragom 955", 1999.9, "");
		Product p2 = new Product(null, "Lavadora Brastemp", "10 kl, dosagem extra, modo economico", 1190.0, "");
		Product p3 = new Product(null, "God of War 4", "Campeão de franquias o jogo conta com ... PLataforma: PC", 50.0, "");
		Product p4 = new Product(null, "Geladeira Eletrolux", "375 L, Bivolt, Douplex, Espaço Adaptativo ", 2200.0, "");
		Product p5 = new Product(null, "The Witcher 3", "Geralt de Rivia é um bruxo, um mutante com poderes especiais que mata monstros por dinheiro.", 99.9, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p1.getCategories().add(cat1);
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat1);
		p4.getCategories().add(cat3);		
		p5.getCategories().add(cat3);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));		
		
		User u1 = new User(null, "Kelly Key", "kelly@gmail.com", "988888888", "BarbieGirl");
		User u2 = new User(null, "Christian Grey", "chris@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2020-08-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2020-08-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2020-09-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 4, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 7, p5.getPrice()); 
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
	}
	
}
