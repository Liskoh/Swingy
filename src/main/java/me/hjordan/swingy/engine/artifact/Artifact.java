package me.hjordan.swingy.engine.artifact;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Artifact {

    private String name;
    private ArtifactType type;
    private float value;
    private int id;
}
