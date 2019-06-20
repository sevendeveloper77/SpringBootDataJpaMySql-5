package com.app.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;

@Component
public class ConsoleRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
		/*Product p=repo.getData(2);
		System.out.println(p.getProdCode()); //may throw nullPointer Exception
		*/
		
		Optional<Product> p=repo.getInfo(5);
		if(p.isPresent()) {   //avoids NullPointerException
			Product prd=p.get();
			System.out.println(prd.getProdCode());
		}else {
			System.out.println("No Data Found");
		}
		
	}

}
