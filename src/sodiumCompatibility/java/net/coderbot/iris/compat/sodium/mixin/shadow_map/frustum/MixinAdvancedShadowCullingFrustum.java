package net.coderbot.iris.compat.sodium.mixin.shadow_map.frustum;

import me.jellysquid.mods.sodium.client.util.frustum.Frustum;
import net.coderbot.iris.shadows.frustum.advanced.AdvancedShadowCullingFrustum;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AdvancedShadowCullingFrustum.class)
public abstract class MixinAdvancedShadowCullingFrustum implements Frustum {
	@Shadow
	public abstract boolean fastAabbTest(float minX, float minY, float minZ, float maxX, float maxY, float maxZ);

	@Override
	public Visibility testBox(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		// TODO: Visibility.INSIDE
		return fastAabbTest(minX, minY, minZ, maxX, maxY, maxZ) ? Visibility.INTERSECT : Visibility.OUTSIDE;
	}
}