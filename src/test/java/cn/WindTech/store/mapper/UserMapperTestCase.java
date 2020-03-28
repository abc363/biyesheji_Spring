package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {

	@Autowired
	public UserMapper mapper;

	@Test
	public void findByUsername() {
		String username = "root";
		User result = mapper.findByUsername(username);
		System.err.println(result);
	}


}






