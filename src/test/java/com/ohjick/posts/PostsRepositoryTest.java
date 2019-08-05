package com.ohjick.posts;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
//		postsRepository.deleteAll();
	}
	
	@Test
	public void testWirteAndCheck() {
		postsRepository.save(Posts.builder().title("�׽�Ʈ �Խñ�").content("�׽�Ʈ ����")
				.author("ohjick@gmail.com").build());
		
		List<Posts> postsList = postsRepository.findAll();
		
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("�׽�Ʈ �Խñ�"));
		assertThat(posts.getContent(), is("�׽�Ʈ ����"));
	}
	
	@Test
	public void testBaseTimeEntity() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder().title("�׽�Ʈ �Խñ�").content("�׽�Ʈ ����")
				.author("ohjick@gmail.com").build());
		
		//when
		
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts post = postsList.get(0);
		assertTrue(post.getCreatedDate().isAfter(now));
		assertTrue(post.getModifiedDate().isAfter(now));
	}

}
