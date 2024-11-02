package fsll.hsf.slot2.service;

import fall.hsf.slot2.pojo.Account;
import fall.hsf.slot2.repository.AccountRepository;
import fall.hsf.slot2.repository.IAccountRepository;

public class AccountService implements IAccountService{
	private IAccountRepository iAccountReposity =null;
	public AccountService(String fileName) {
		iAccountReposity = new AccountRepository(fileName);
	}

	@Override
	public Account findByUserName(String userName) {
		// TODO Auto-generated method stub
		return iAccountReposity.findByUserName(userName);
	}

}
