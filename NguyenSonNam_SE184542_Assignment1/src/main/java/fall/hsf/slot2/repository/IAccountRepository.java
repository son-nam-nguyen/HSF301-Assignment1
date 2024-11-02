package fall.hsf.slot2.repository;

import fall.hsf.slot2.pojo.Account;

public interface IAccountRepository {
	public Account findByUserName(String userName);

}
