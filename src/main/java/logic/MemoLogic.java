package logic;

import java.util.List;

import DAO.MemoDAO;
import beans.MemoBeans;

public class MemoLogic {

	public void newMemoLogic(String title, String memo) {
		MemoDAO dao = new MemoDAO();
		dao.newMemo(title, memo);
	}

	public List<MemoBeans>  getMemoAllLogic() {
		MemoDAO dao = new MemoDAO();
		return dao.getMemoAll();
	}

	public void memoEditLogic(int id, String title, String memo) {
		MemoDAO dao = new MemoDAO();
		dao.memoEdit(id, title, memo);
	}

	public void deleteMemoLogic(int id) {
		MemoDAO dao = new MemoDAO();
		dao.deleteMemo(id);
	}

}
