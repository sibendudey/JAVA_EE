package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {
	public void save(Spitter spitter);

	public Spitter findByUserName(String userName);

}
