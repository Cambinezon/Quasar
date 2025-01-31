package com.lilyfena.NUBClient.api.Events.HITLEREvents.Player;

import com.lilyfena.NUBClient.api.MegaEvents.Base.Event;
import com.lilyfena.NUBClient.api.Render.BWRC;
import net.minecraft.util.hit.HitResult;
import org.jetbrains.annotations.Nullable;

public class RenderWorldEvent extends Event {
    private final Phase phase;
    private final BWRC renderContext;

    public RenderWorldEvent(Phase phase, BWRC renderContext) {
        this.phase = phase;
        this.renderContext = renderContext;
    }

    public static class Start extends RenderWorldEvent {
        public Start(BWRC renderContext) {
            super(Phase.START, renderContext);
        }
    }

    public static class AfterSetup extends RenderWorldEvent {
        public AfterSetup(BWRC renderContext) {
            super(Phase.AFTER_SETUP, renderContext);

        }
    }

    public static class BeforeEntities extends RenderWorldEvent {
        public BeforeEntities(BWRC renderContext) {
            super(Phase.BEFORE_ENTITIES, renderContext);
        }
    }

    public static class AfterEntities extends RenderWorldEvent {
        public AfterEntities(BWRC renderContext) {
            super(Phase.AFTER_ENTITIES, renderContext);
        }
    }

    public static class BeforeBlockOutline extends RenderWorldEvent {
        private final HitResult hitResult;

        public BeforeBlockOutline(BWRC renderContext, @Nullable HitResult hitResult) {
            super(Phase.BEFORE_BLOCK_OUTLINE, renderContext);
            this.hitResult = hitResult;
        }

        public HitResult getHitResult() {
            return this.hitResult;
        }
    }

    public static class BlockOutline extends RenderWorldEvent {
        private final BWRC blockOutlineContext;

        public BlockOutline(BWRC renderContext, BWRC blockOutlineContext) {
            super(Phase.BLOCK_OUTLINE, renderContext);
            this.blockOutlineContext = blockOutlineContext;
        }

        public BWRC getBlockOutlineContext() {
            return this.blockOutlineContext;
        }
    }

    public static class BeforeDebugRender extends RenderWorldEvent {
        public BeforeDebugRender(BWRC renderContext) {
            super(Phase.BEFORE_DEBUG_RENDER, renderContext);
        }
    }

    public static class AfterTranslucent extends RenderWorldEvent {
        public AfterTranslucent(BWRC renderContext) {
            super(Phase.AFTER_TRANSLUCENT, renderContext);
        }
    }

    public static class Last extends RenderWorldEvent {
        public Last(BWRC renderContext) {
            super(Phase.LAST, renderContext);
        }
    }

    public static class End extends RenderWorldEvent {
        public End(BWRC renderContext) {
            super(Phase.END, renderContext);
        }
    }



    public Phase getRenderPhase() {
        return this.phase;
    }

    public BWRC getWorldRenderContext() {
        return this.renderContext;
    }

    public enum Phase {
        START,
        AFTER_SETUP,
        BEFORE_ENTITIES,
        AFTER_ENTITIES,
        BEFORE_BLOCK_OUTLINE,
        BLOCK_OUTLINE,
        BEFORE_DEBUG_RENDER,
        AFTER_TRANSLUCENT,
        LAST,
        END
    }
}
