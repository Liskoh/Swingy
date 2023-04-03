package me.hjordan.swingy.registry.impl;

import me.hjordan.swingy.engine.artifact.Artifact;
import me.hjordan.swingy.engine.artifact.ArtifactType;
import me.hjordan.swingy.registry.AbstractRegistry;

public class ArtifactRegistry extends AbstractRegistry<Artifact> {

    public ArtifactRegistry() {
        super();
    }

    @Override
    public void init() {
        // DEFAULT ARTIFACTS
        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Helmet of the North")
                .type(ArtifactType.HELMET)
                .value(10)
                .build());

        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Armor of the North")
                .type(ArtifactType.ARMOR)
                .value(10)
                .build());

        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Weapon of the North")
                .type(ArtifactType.WEAPON)
                .value(50)
                .build());

        // MEDIUM ARTIFACTS
        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Helmet of the South")
                .type(ArtifactType.HELMET)
                .value(50)
                .build());

        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Armor of the South")
                .type(ArtifactType.ARMOR)
                .value(50)
                .build());

        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Weapon of the South")
                .type(ArtifactType.WEAPON)
                .value(100)
                .build());

        // HIGH ARTIFACTS
        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Helmet of the East")
                .type(ArtifactType.HELMET)
                .value(500)
                .build());

        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Armor of the East")
                .type(ArtifactType.ARMOR)
                .value(500)
                .build());

        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Weapon of the East")
                .type(ArtifactType.WEAPON)
                .value(1000)
                .build());

        // ULTRA ARTIFACTS
        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Helmet of the West")
                .type(ArtifactType.HELMET)
                .value(5000)
                .build());

        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Armor of the West")
                .type(ArtifactType.ARMOR)
                .value(5000)
                .build());

        this.add(Artifact.builder()
                .id(this.getAvailableId())
                .name("Weapon of the West")
                .type(ArtifactType.WEAPON)
                .value(10000)
                .build());
    }

    private int getAvailableId() {
        int id = 0;
        for (Artifact artifact : this.registry)
            if (artifact.getId() > id)
                id = artifact.getId();
        return id + 1;
    }

}
