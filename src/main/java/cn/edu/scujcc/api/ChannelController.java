package cn.edu.scujcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import cn.edu.scujcc.model.Channel;
import cn.edu.scujcc.service.ChannelService;

@RestController
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	private ChannelService service;
	
	@GetMapping
	public List<Channel> getAllChannels() {
		return service.getAllChannels();
	}
	
	@GetMapping("/{id}")
	public Channel getChannel(@PathVariable int id) {
		System.out.println("获取频值.id="+id);
		Logger.info("正在读取频道："+id);
		Channel c=service.getChannel(id);
		if(c!=null) {
			return c;
		}else {
			
		return null;
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteChannel(@PathVariable int id) {
		System.out.println("即将删除频道.id"+id);
		boolean result=service.deleteChannel(id);
		if(result) {
			return ResponseEntity.ok().body("删除成功");
		}else {
			return ResponseEntity.ok().body("删除失败");
		}
	
	}	
	@PostMapping
	public Channel createChannel(@RequestBody Channel c) {
		System.out.println("即将新建频道，频道数据:"+c);
		Channel saved=service.createChannel(c);
		return saved;
	}
	@PutMapping
	public Channel updateChannel(@RequestBody Channel c) {
		System.out.println("即将更新频道：频道数据："+c);
		Channel updated=service.updateChannel(c);
		return updated;
	}
}
