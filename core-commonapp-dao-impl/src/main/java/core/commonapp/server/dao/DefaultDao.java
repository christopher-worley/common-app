package core.commonapp.server.dao;

import org.springframework.stereotype.Repository;

import core.commonapp.client.dao.BaseDao;

@Repository("defaultDao")
public class DefaultDao extends BaseDaoJpaImpl<Object> implements BaseDao<Object> {

	private Class persistClass;

	public DefaultDao() {
		super();
	}

	public DefaultDao(Class persistClass) {
		super();
		this.persistClass = persistClass;
	}

	@Override
	public Class<Object> getPersistClass() {
		return persistClass;
	}

}
