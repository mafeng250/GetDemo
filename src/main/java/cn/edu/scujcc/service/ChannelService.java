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
		//ģ������10��Ƶ������
		channels=new ArrayList<>();
		for(int i=0;i<10;i++) {
			Channel c=new Channel();
		  //c.setId(i+1);
			c.setTitle("����"+(i+1)+"̨");
			c.setUrl("http://www.cctv.com");
			channels.add(c);
		}
	}
	/**
	 * ��ȡ���е�Ƶ��������
	 * @return Ƶ��List
	 */
	public List<Channel> getAllChannels(){
		return this.channels;
	}
	/**
	 * ��ȡһ����Ƶ��������
	 * @param channelId Ƶ�����
	 * @return Ƶ��������δ�ҵ��򷵻�Ϊ��
	 */
	public Channel getChannel(int channelId){
		Channel result=null;
		//ѭ������ָ����Ƶ��
		for(Channel c:channels) {
			//if(c.getId()==channelId) {
				//result=c;
				//break;
			//}
		}
		return result;
	}
	/**
	 * ɾ��ָ����Ƶ��
	 * @param channelId ��ɾ����Ƶ�����
	 * @return ��ɾ���ɹ��򷵻�true,���򷵻�false;
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
	 * ����Ƶ��
	 * @param c �������Ƶ������(û��idֵ)
	 * @return������Ƶ������idֵ��
	 */
	public Channel createChannel(Channel c) {
		//�ҵ�Ŀǰ����id��������1��Ϊ��Ƶ��id
//		int newId=channels.get(channels.size()-1).getId()+1;
//		c.setId(newId);
//		channels.add(c);
//		return c;
		return repo.save(c);
	}
	/**
	 * ����ָ����Ƶ����Ϣ
	 * @param c �µ�Ƶ����Ϣ�����ڸ����Ѵ��ڵ�ͬһƵ��
	 * @return ���º��Ƶ����Ϣ
	 */
	public Channel updateChannel(Channel c) {
		//���޸��û�ָ��������
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
