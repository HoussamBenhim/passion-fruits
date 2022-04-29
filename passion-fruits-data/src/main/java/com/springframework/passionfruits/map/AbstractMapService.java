package com.springframework.passionfruits.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.springframework.passionfruits.moddels.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
	protected Map<Long, T> map = new HashMap<>();

	Set<T> findAll() {
		return new HashSet(map.values());
	};

	T findById(ID id) {
		return map.get(id);
	};

	T save(T entity) {
		if (entity != null) {
			if (entity.getId() == null) {
				entity.setId(getNextId());
				map.put(entity.getId(), entity);
			} else {
				map.put(entity.getId(), entity);
			}
		} else {
			throw new RuntimeException("Object Cannot be null !");
		}

		return entity;
	};

	void deleteByID(ID id) {
		map.remove(id);
	};

	void delete(T entity) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
	};

	private Long getNextId() {
		Long nextId = null;
		try {
			return nextId = Collections.max(map.keySet()) + 1;
		} catch (RuntimeException e) {
			return nextId = 1L;
		}

	}

}
