package edu.kh.comm.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.comm.member.model.dao.MemberDAO;

@Service // ����Ͻ� ����(������ ����, DB ���� ��)�� ó���ϴ� Ŭ�������� ��� + bean ���
public class MemberServiceImpl implements MemberService {

	@Autowired // bean���� ��ϵ� ��ü �� ���� Ÿ���� ������ ������ ����(DI)
	private MemberDAO dao;
}
