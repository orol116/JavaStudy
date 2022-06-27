package edu.kh.comm.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.comm.member.model.vo.Member;

@Repository // ���Ӽ��� ������ DB/���ϰ� ����Ǵ� ��ü���� ��� + bean ���
public class MemberDAO {
	
	// DAO�� DB�� �����ϱ� ���� Connection�� ���������� �ʿ��ϴ�.
	// ��? DAO�� DB�� ���� �����ؾ��ϱ� �����̴�.
	// -> �ʵ忡 ����
	//  + Mybatis ���Ӽ� �����ӿ�ũ�� �̿��Ϸ��� Connection�� �̿��� ������� ��ü
	//    SqlSessionTemplate�� ���
	
	@Autowired // root-context.xml ���� ������ SqlSessionTemplate bean�� ������ ����(DI)
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(MemberDAO.class);

	public Member login(Member inputMember) {
		
		// 1�� ��ȸ(�Ķ���� X)���
		// int count = sqlSession.selectOne("namespace��.id��");
		// int count = sqlSession.selectOne("memberMapper.test1");
		// logger.debug(count + "");
		
		// 1�� ��ȸ(�Ķ���� O) ���
		// String memberNickname = sqlSession.selectOne("memberMapper.test2", inputMember.getMemberEmail());
		// logger.debug(memberNickname);
		
		// 1�� ��ȸ(�Ķ���Ͱ� VO�� ���)
		// String memberTel = sqlSession.selectOne("memberMapper.test3", inputMember);
		// logger.debug(memberTel);
		
		// 1�� ��ȸ (�Ķ���Ͱ� VO, ��ȯ�Ǵ� ����� VO)
		Member loginMember = sqlSession.selectOne("memberMapper.login", inputMember);
		
		return loginMember;
	}

	/** �̸��� �ߺ� �˻� DAO
	 * @param memberEmail
	 * @return result
	 */
	public int emailDupCheck(String memberEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck", memberEmail);
	}

	/** �г��� �ߺ� �˻� DAO
	 * @param memberNickname
	 * @return result
	 */
	public int nicknameDupCheck(String memberNickname) {
		return sqlSession.selectOne("memberMapper.nicknameDupCheck", memberNickname);
	}

	/** ȸ�� ���� DAO
	 * @param inputMember
	 * @return result
	 */
	public int signUp(Member inputMember) {

		// INSERT, UPDATE, DELETE�� �����ϱ� ���� �޼��尡 �����Ѵ�.
		
		// * insert() / update() / delete �޼����� ��ȯ ���� int������ �����̴�.
		//   -> mapper������ resultType�� �׻� _int�� ����
		//      -> resultType ���� ����(���������� _int)
		
		return sqlSession.insert("memberMapper.signUp", inputMember);
	}

	/** ȸ�� 1�� ���� ��ȸ DAO
	 * @param memberEmail
	 * @return member
	 */
	public Member selectOne(String memberEmail) {
		return sqlSession.selectOne("memberMapper.selectOne", memberEmail);
		
	}

	/** ȸ�� ��� ��ȸ DAO
	 * @return memberList
	 */
	public List<Member> selectAll() {
		
		// selectList() : ���� ���� ��ȸ -> ���� Ÿ���� List
		// * ��ȸ�Ǵ� ��� ���� ���������� �����ؼ� VO�� �ʵ� ���� ���� �� List�� �ڵ� �߰�
		
		return sqlSession.selectList("memberMapper.selectAll");
	}

}
