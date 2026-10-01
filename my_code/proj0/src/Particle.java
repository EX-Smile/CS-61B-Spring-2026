import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.Map;

public class Particle {
    public ParticleFlavor flavor;
    public int lifespan;

    public static final int PLANT_LIFESPAN = 150;
    public static final int FLOWER_LIFESPAN = 75;
    public static final int FIRE_LIFESPAN = 10;
    public static final Map<ParticleFlavor, Integer> LIFESPANS =
            Map.of(ParticleFlavor.FLOWER, FLOWER_LIFESPAN,
                   ParticleFlavor.PLANT, PLANT_LIFESPAN,
                   ParticleFlavor.FIRE, FIRE_LIFESPAN);

    public Particle(ParticleFlavor flavor) {
        this.flavor = flavor;
        if (flavor == ParticleFlavor.FIRE) {
            this.lifespan = FIRE_LIFESPAN;
        }
        else if (flavor == ParticleFlavor.PLANT) {
            this.lifespan = PLANT_LIFESPAN;
        }
        else if (flavor == ParticleFlavor.FLOWER) {
            this.lifespan = FLOWER_LIFESPAN;
        }
        else {
            lifespan = -1;
        }
    }

    public void decrementLifespan(Map<Direction, Particle> neighbors) {
        if (this.lifespan > 0) {
            this.lifespan -= 1;
        }
        if (this.lifespan == 0) {
            this.flavor = ParticleFlavor.EMPTY;
            this.lifespan = -1;
        }
    }

    public Color color() {
        if (flavor == ParticleFlavor.EMPTY) {
            return Color.BLACK;
        }
        if (flavor == ParticleFlavor.SAND) {
            return Color.YELLOW;
        }
        if (flavor == ParticleFlavor.BARRIER) {
            return Color.GRAY;
        }
        if (flavor == ParticleFlavor.WATER) {
            return Color.BLUE;
        }
        if (flavor == ParticleFlavor.FOUNTAIN) {
            return Color.CYAN;
        }
        if (flavor == ParticleFlavor.PLANT) {
            return new Color(0, 255, 0);
        }
        if (flavor == ParticleFlavor.FIRE) {
            return new Color(255, 0, 0);
        }
        if (flavor == ParticleFlavor.FLOWER) {
            return new Color(255, 141, 161);
        }
        if (flavor == ParticleFlavor.CLOUD) {
            return new Color(255, 255, 255);
        }
        if (flavor == ParticleFlavor.ORANGE) {
            return new Color(255, 165, 0);
        }
        return null;
    }

    public void moveInto(Particle other) {
        other.flavor = this.flavor;
        other.lifespan = this.lifespan;

        this.flavor = ParticleFlavor.EMPTY;
        this.lifespan = -1;
    }

    public void fall(Map<Direction, Particle> neighbors) {
        if (neighbors.get(Direction.DOWN).flavor == ParticleFlavor.EMPTY) {
            this.moveInto(neighbors.get(Direction.DOWN));
        }
    }

    public void flow(Map<Direction, Particle> neighbors) {
        int chance = StdRandom.uniformInt(3);
        if (chance == 0) {}
        else if (chance == 1 && neighbors.get(Direction.LEFT).flavor == ParticleFlavor.EMPTY) {
            moveInto(neighbors.get(Direction.LEFT));
        }
        else if (chance == 2 && neighbors.get(Direction.RIGHT).flavor == ParticleFlavor.EMPTY) {
            moveInto(neighbors.get(Direction.RIGHT));
        }
    }

    public void grow(Map<Direction, Particle> neighbors) {
        int chance = StdRandom.uniformInt(10);
        if (chance == 0 && neighbors.get(Direction.LEFT).flavor == ParticleFlavor.EMPTY) {
        neighbors.get(Direction.LEFT).flavor = this.flavor;
        neighbors.get(Direction.LEFT).lifespan = this.lifespan;
        }
        else if (chance == 1 && neighbors.get(Direction.RIGHT).flavor == ParticleFlavor.EMPTY) {
            neighbors.get(Direction.RIGHT).flavor = this.flavor;
            neighbors.get(Direction.RIGHT).lifespan = this.lifespan;
        }
        else if (chance == 2 && neighbors.get(Direction.UP).flavor == ParticleFlavor.EMPTY) {
            neighbors.get(Direction.UP).flavor = this.flavor;
            neighbors.get(Direction.UP).lifespan = this.lifespan;
        }
        else {}
    }

    public void burn(Map<Direction, Particle> neighbors) {
    }

    public void action(Map<Direction, Particle> neighbors) {
        if (this.flavor == ParticleFlavor.EMPTY) {
            return;
        }
        if (this.flavor != ParticleFlavor.BARRIER) {
            fall(neighbors);
        }
        if (this.flavor == ParticleFlavor.WATER) {
            flow(neighbors);
        }
        if (this.flavor == ParticleFlavor.FLOWER || this.flavor == ParticleFlavor.PLANT) {
            grow(neighbors);
        }
    }
}