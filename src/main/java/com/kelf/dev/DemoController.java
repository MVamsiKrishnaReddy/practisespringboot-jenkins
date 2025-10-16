package com.kelf.dev;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
	
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/")
	public String jenkins() {
		return "jenkins is working successfully";
	}
	
	@GetMapping("/posts")
	public List<Object> userdata() {
		Object[] data=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Object[].class);
		return Arrays.asList(data);
	}
	
	@GetMapping("/posts/{id}")
    public Object getPostById(@PathVariable int id) {
        Object data = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Object.class);
        return data;
    }
	
	@GetMapping("/comments")
	public List<Object> todos() {
		Object[] data=restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Object[].class);
		return Arrays.asList(data);
	}
	
	@GetMapping("/comments/{id}")
    public Object getCommentById(@PathVariable int id) {
        Object data = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments/" + id, Object.class);
        return data;
    }
}