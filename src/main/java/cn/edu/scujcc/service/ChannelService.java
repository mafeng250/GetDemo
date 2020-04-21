package cn.edu.scujcc.service;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.scujcc.dao.ChannelRepository;
import cn.edu.scujcc.model.Channel;

@Service
public class ChannelService {
	@Autowired
	private ChannelRepository repo;
	private List<Channel> channels;
	
	public ChannelService() {
		//模拟生成10条频道数据
		channels=new ArrayList<>();
		for(int i=0;i<10;i++) {
			Channel c=new Channel();
		  //c.setId(i+1);
			c.setTitle("中央"+(i+1)+"台");
			c.setUrl("http://www.cctv.com");
			channels.add(c);
		}
	}
	/**
	 * 获取所有的频道的数据
	 * @return 频道List
	 */
	public List<Channel> getAllChannels(){
		return this.channels;
	}
	/**
	 * 获取一个的频道的数据
	 * @param channelId 频道编号
	 * @return 频道对象，若未找到则返回为空
	 */
	public Channel getChannel(int channelId){
		Channel result=null;
		//循环查找指定的频道
		for(Channel c:channels) {
			//if(c.getId()==channelId) {
				//result=c;
				//break;
			//}
		}
		return result;
	}
	/**
	 * 删除指定的频道
	 * @param channelId 待删除的频道编号
	 * @return 若删除成功则返回true,否则返回false;
	 */
	public boolean deleteChannel(int channelId) {
		boolean result=false;
		Channel c=getChannel(channelId);
		if(c!=null) {
			channels.remove(c);
			result=true;
		}
		return result;
	}
	/**
	 * 保存频道
	 * @param c 待保存的频道对象(没有id值)
	 * @return保存后的频道（有id值）
	 */
	public Channel createChannel(Channel c) {
		//找到目前最大的id，并增加1作为新频道id
//		int newId=channels.get(channels.size()-1).getId()+1;
//		c.setId(newId);
//		channels.add(c);
//		return c;
		return repo.save(c);
	}
	/**
	 * 更新指定的频道信息
	 * @param c 新的频道信息，用于更新已存在的同一频道
	 * @return 更新后的频道信息
	 */
	public Channel updateChannel(Channel c) {
		//仅修改用户指定的属性
		//Channel toUpdate=getChannel(c.getId());
		//if(toUpdate !=null) {
			//toUpdate.setTitle(c.getTitle());
			//toUpdate.setQuality(c.getQuality());
			//toUpdate.setUrl(c.getUrl());
		//}
		//return toUpdate;
		return null;
	}
}
