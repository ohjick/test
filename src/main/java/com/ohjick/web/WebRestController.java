package com.ohjick.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ohjick.posts.PostsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
/*
 * 생성자로 Bean 객체를 주입 받도록 하면 @Autowired와 동일한 효과를 볼수 있다.
*/

public class WebRestController {
	
	private PostsRepository postsRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}
	
	public void savePosts2() {
		
	}
}
