package com.acorn.ebd.report.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.ebd.report.dto.CafeCommentDto;

@Repository
public class CafeCommentDaoImpl implements CafeCommentDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CafeCommentDto> getList(CafeCommentDto dto) {
		List<CafeCommentDto> list=
				session.selectList("cafeComment.getList", dto);
		return list;		
	}

	@Override
	public void insert(CafeCommentDto dto) {
		session.insert("cafeComment.insert", dto);
		
	}

	@Override
	public void update(CafeCommentDto dto) {
		session.update("cafeComment.update", dto);
		
	}

	@Override
	public void delete(int num) {
		//댓글 삭제는 deleted 칼럼의 내용을 'yes' 로 수정하는 작업을 한다.
		session.update("cafeComment.delete", num);
		
	}

	@Override
	public int getSequence() {
		int seq=session.selectOne("cafeComment.getSequence");
		return seq;
	}

	@Override
	public CafeCommentDto getData(int num) {
		return session.selectOne("cafeComment.getData", num);
	}

	@Override
	public int getCount(int ref_group) {
		return session.selectOne("cafeComment.getCount", ref_group);
	}

}
