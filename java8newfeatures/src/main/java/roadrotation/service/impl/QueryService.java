package roadrotation.service.impl;

import roadrotation.Rotater;
import roadrotation.service.Query;

public class QueryService implements Query {

	private final static QueryService instance = new QueryService();

	private Rotater manager;

	private QueryService() {

	}

	@Override
	public String[] whatNow() {

		return manager.getInEffectNumbers().getNumbers().toArray(new String[0]);
	}

	public static Query getInstance() {
		return instance;
	}

}
