package batu.dev.sem.bundles.UserManagement.dao;

import java.util.List;

public interface OperationDao<C> {
	public int create(C pEntity);
	public int update(C pEntity);
	public int delete(C pEntity);
	public C get(long pId);
	public C get(String pName);
	public List<C> get(String ...p);
}
