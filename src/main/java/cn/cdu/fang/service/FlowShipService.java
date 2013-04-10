package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.FlowShip;
import cn.cdu.fang.entity.User;

public interface FlowShipService {
	public void save(FlowShip entity);
	public void update(FlowShip entity);
	public void delete(Integer id);
	
	public FlowShip getEntity(Integer id);
	public List<FlowShip> getEntities();
	
	/**
	 * 传入当前用户，找到当前用户的关注[对象]-----Target
	 * 
	 * @param user 当前用户
	 * @return
	 */
	List<FlowShip> findByFollowed(User user);
	
	/**
	 * 传入当前用户，找到关注当前用户的所有[对象]---Followed
	 * 
	 * @param user 当前用户
	 * @return
	 */
	List<FlowShip> findByTarget(User user);
	/**
	 * 根据关注用户，查找关系是否存在
	 * 
	 * @param followed
	 * @param target
	 * @return
	 */
	FlowShip findByFollowedAndTarget(User followed,User target);
}
