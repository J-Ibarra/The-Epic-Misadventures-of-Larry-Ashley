package com.steftmax.temol.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.steftmax.temol.component.PositionComponent;
import com.steftmax.temol.component.VelocityComponent;

/**
 * @author pieter3457
 *
 */
@Deprecated
public class MovementSystem extends IteratingSystem {

	private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
	private ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);

	public MovementSystem() {
		super(Family.all(PositionComponent.class, VelocityComponent.class).get());
	}

	public void processEntity(Entity entity, float deltaTime) {
		PositionComponent position = pm.get(entity);
		VelocityComponent velocity = vm.get(entity);

		position.x += velocity.x * deltaTime;
		position.y += velocity.y * deltaTime;
	}
}