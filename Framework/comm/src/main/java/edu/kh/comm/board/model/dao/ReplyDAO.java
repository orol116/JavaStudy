package edu.kh.comm.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.board.model.vo.Reply;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** ��� ��� ��ȸ DAO
	 * @param boardNo
	 * @return rList
	 */
	public List<Reply> selectReplyList(int boardNo) {
		return sqlSession.selectList("replyMapper.selectReplyList", boardNo);
	}

	/** ��� ���� DAO
	 * @param reply
	 * @return result
	 */
	public int insertReply(Reply reply) {
		return sqlSession.insert("replyMapper.insertReply", reply);
	}

	/** ��� ���� DAO
	 * @param replyNo
	 * @return result
	 */
	public int deleteReply(int replyNo) {
		return sqlSession.update("replyMapper.deleteReply", replyNo);
	}

	/** ��� ���� DAO
	 * @param reply
	 * @return result
	 */
	public int updateReply(Reply reply) {
		return sqlSession.update("replyMapper.updateReply", reply);
	}
	
}
