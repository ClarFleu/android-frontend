package ch.heigvd.pro.b04.android.Datamodel;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import java.util.Objects;

public class Answer {
    @SerializedName("idModerator")
    private String idModerator;

    @SerializedName("idPoll")
    private String idPoll;

    @SerializedName("idQuestion")
    private long idQuestion;

    @SerializedName("idAnswer")
    private long idAnswer;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("checked")
    private boolean selected;

    public Answer(String idModerator, String idPoll, String idQuestion, String idAnswer, String title, String description, String selected) {
        this.idModerator = idModerator;
        this.idPoll = idPoll;
        this.idQuestion = Long.getLong(idQuestion);
        this.idAnswer = Long.getLong(idAnswer);
        this.title = title;
        this.description = description;
        this.selected = Boolean.getBoolean(selected);
    }

    public String getIdModerator() {
        return idModerator;
    }

    public String getIdPoll() {
        return idPoll;
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public long getIdAnswer() {
        return idAnswer;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void toggle() {
        selected = !selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;
        return  Objects.equals(idModerator, answer.idModerator) &&
                Objects.equals(idPoll, answer.idPoll) &&
                Objects.equals(idQuestion, answer.idQuestion) &&
                Objects.equals(title, answer.title) &&
                Objects.equals(description, answer.description);
    }

    public LinkedTreeMap<String, String> toStringMap() {
        LinkedTreeMap<String, String> map = new LinkedTreeMap<>();

        map.put("idModerator", idModerator);
        map.put("idPoll", idPoll);
        map.put("idQuestion", "" + idQuestion);
        map.put("idAnswer", "" + idAnswer);
        map.put("title", title);
        map.put("description", description);
        map.put("selected", "" + selected);

        return map;
    }
}
