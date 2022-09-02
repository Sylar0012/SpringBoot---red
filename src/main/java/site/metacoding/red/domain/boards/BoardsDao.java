package site.metacoding.red.domain.boards;

import java.util.List;

import site.metacoding.red.domain.boards.mapper.BoardsDetail;
import site.metacoding.red.web.dto.request.boards.FindRespDto;
import site.metacoding.red.web.dto.request.boards.WriteDto;

public interface BoardsDao {
	public BoardsDetail findByIdtoDetail(Integer id);
	public void insert(WriteDto writeDto);
	public Boards findById(Integer id);
	public FindRespDto findByIdAsUserName (Integer id);
	public List<Boards> findByIdList(Integer id);
	public List<Boards> findAll();
	public void delete(Integer id);
	public void update(Boards boards);
}
