package me.hjordan.swingy.objects.artifact;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class Artifact {

    private ArtifactType type;
    private float value;
    private int id;
}
