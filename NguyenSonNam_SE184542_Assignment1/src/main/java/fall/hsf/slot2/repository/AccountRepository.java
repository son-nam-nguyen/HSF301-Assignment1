package fall.hsf.slot2.repository;

import fall.hsf.slot2.dao.AccountDAO;
import fall.hsf.slot2.pojo.Account;
import fsll.hsf.slot2.service.IAccountService;

public class AccountRepository implements IAccountRepository {
	private AccountDAO accountDAO = null;
	public AccountRepository(String fileConfig) {
		accountDAO = new AccountDAO(fileConfig);
	}

	@Override
	public Account findByUserName(String userName) {
		return accountDAO.findByUserName(userName);
	}
}
