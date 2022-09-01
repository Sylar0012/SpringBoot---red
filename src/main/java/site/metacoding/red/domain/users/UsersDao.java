package site.metacoding.red.domain.users;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;

public interface UsersDao {
	public void insert(JoinDto joinDto);
	public Users findById(Integer id);
	public List<Users> findAll();
	public void delete(Integer id);
	public void update(Users users);
	
	
}