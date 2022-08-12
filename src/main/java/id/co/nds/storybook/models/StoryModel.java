package id.co.nds.storybook.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import id.co.nds.storybook.controllers.ControllerGroup.PostingNew;

public class StoryModel {
    @Null(message = "Story ID is auto generated, do not input ID",
            groups = {PostingNew.class})
    private String id;

    @NotBlank(message = "Story name is required",
            groups = {PostingNew.class})
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
