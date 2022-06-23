package edu.kh.comm.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.comm.member.model.dao.MemberDAO;
import edu.kh.comm.member.model.vo.Member;

@Service // ����Ͻ� ����(������ ����, DB ���� ��)�� ó���ϴ� Ŭ�������� ��� + bean ���
public class MemberServiceImpl implements MemberService {

	@Autowired // bean���� ��ϵ� ��ü �� ���� Ÿ���� ������ ������ ����(DI)
	private MemberDAO dao;
	
	
	/* * Connection�� Service���� ���Դ� ���� *
	 * - Service�� �޼��� �ϳ��� ��û�� ó���ϴ� ���� ����
	 *   -> �ش� ������ ���� �� Ʈ������� �ѹ��� ó���ϱ� ���ؼ�
	 *      ��¿ �� ���� Connection�� Service���� ���� �� �ۿ� ������.
	 */

	// �α��� Service ����
	@Override
	public Member login(Member inputMember) {

		Member loginMember = dao.login(inputMember);
		
		return loginMember;
		
		// Connection�� �����ų� / ��ȯ�ϰų�
		// Ʈ����� ó���� �ϴ� ������ ���� �ʾƵ�
		// Spring���� ��� �ϱ� ������
	}
}
