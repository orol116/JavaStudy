package edu.kh.comm.board.model.exception;

// ����� ���� ���� ���� ���
// 1) ������ �����ϴ� ���� Ŭ���� �ϳ��� ��� �޴´�.
//    ��, RuntimeException�� ��� ������ ���ܸ� ��� ������ unchecked Exception�� �ȴ�.
// 2) ������ �ۼ� �� super() �����ڸ� �̿��ؼ� �ڵ带 �����Ѵ�.
public class InsertFailException extends RuntimeException {
	
	public InsertFailException() {
		super("�Խñ� ���� ����");
	}
	
}
