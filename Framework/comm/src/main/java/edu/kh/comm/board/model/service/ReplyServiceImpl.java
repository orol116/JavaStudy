package edu.kh.comm.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.comm.board.model.dao.ReplyDAO;
import edu.kh.comm.board.model.vo.Reply;
import edu.kh.comm.common.Util;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO dao;

	// ��� ��� ��ȸ
	@Override
	public List<Reply> selectReplyList(int boardNo) {
		return dao.selectReplyList(boardNo);
	}

	// ��� ����
	@Override
	public int insertReply(Reply reply) {
		
		// XSS, ���๮�� ó��
		reply.setReplyContent(Util.XSSHandling(reply.getReplyContent()));
		reply.setReplyContent(Util.newLineHandling(reply.getReplyContent()));

		return dao.insertReply(reply);
	}

	// ��� ����
	@Override
	public int deleteReply(int replyNo) {
		return dao.deleteReply(replyNo);
	}

	// ��� ����
	@Override
	public int updateReply(Reply reply) {
		
		reply.setReplyContent((Util.XSSHandling(reply.getReplyContent())));
		reply.setReplyContent(Util.newLineHandling(reply.getReplyContent()));
		
		return dao.updateReply(reply);
	}
	
}
