package edu.kh.comm.board.model.service;

import java.util.List;

import edu.kh.comm.board.model.vo.Reply;

public interface ReplyService {

	/** ��� ��� ��ȸ Service
	 * @param boardNo
	 * @return rList
	 */
	List<Reply> selectReplyList(int boardNo);

	/** ��� ��� Service
	 * @param reply
	 * @return result
	 */
	int insertReply(Reply reply);

	/** ��� ���� Service
	 * @param replyNo
	 * @return result
	 */
	int deleteReply(int replyNo);

	/** ��� ���� Service
	 * @param reply
	 * @return result
	 */
	int updateReply(Reply reply);

}
