package edu.kh.comm.member.model.service;

import java.util.List;

import edu.kh.comm.member.model.vo.Member;

/* Service Interface�� ����ϴ� ����
 * 
 * 1. ������Ʈ�� ��Ģ���� �ο��ϱ� ���ؼ�
 * 2. Spring AOP�� ���ؼ� �ʿ��ϴ�
 * 3. Ŭ���� ���� ���յ��� ��ȭ��Ű�� ���ؼ� => ���������� ��� (��ü ������ ���α׷���)
 */
public interface MemberService {
	
	// [�������̽��� Ư¡]
	// ��� �޼��尡 �߻� �޼����̴�.	(���������� public abstract)
	// ��� �ʵ�� ����̴�.			(���������� public static final)

	/** �α��� Service
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember);
	

	/** �̸��� �ߺ� �˻� Service
	 * @param memberEmail
	 * @return result
	 */
	int emailDupCheck(String memberEmail);

	
	/** �г��� �ߺ� �˻� Service
	 * @param memberNickname
	 * @return result
	 */
	int nicknameDupCheck(String memberNickname);


	/** ȸ�� ���� Service
	 * @param inputMember
	 * @return result
	 */
	int signUp(Member inputMember);


	/** ȸ�� 1�� ���� ��ȸ Service
	 * @param memberEmail
	 * @return member
	 */
	Member selectOne(String memberEmail);


	/** ȸ�� ��� ��ȸ Service
	 * @return memberList
	 */
	List<Member> selectAll();
	
}
