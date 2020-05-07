package ch.heigvd.pro.b04.android.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

import ch.heigvd.pro.b04.android.Datamodel.Answer;
import ch.heigvd.pro.b04.android.Utils.Exceptions.AnswersNotSetException;
import ch.heigvd.pro.b04.android.Utils.Exceptions.TokenNotSetException;

public final class Persistent {
    private Persistent() {};
    public static final String dataSP = "dataSP";
    public static final String tokenSP = "TokenValue";

    private static String answerList = "List of answers";

    /**
     * This function returns the token if it was set previously.
     * @param context The app context. Needed to access the Shared Preferences
     * @return The token value
     * @throws TokenNotSetException is thrown if no token was stored
     */
    public static String getStoredTokenOrError(Context context) throws TokenNotSetException {
        String defValue = "Error";
        SharedPreferences preferences = context.getSharedPreferences(
                dataSP, Context.MODE_PRIVATE);

        String token = preferences.getString(tokenSP, defValue);

        if (token.equals(defValue)) {
            throw new TokenNotSetException();
        } else {
            return token;
        }
    }

    /**
     * This function will write the token to the Shared Preferences
     * @param context The app context. Needed to access the Shared Preferences
     * @param token The token to write
     */
    public static void writeToken(Context context, String token) {
        context.getSharedPreferences(dataSP, Context.MODE_PRIVATE)
                .edit()
                .putString(tokenSP, token)
                .apply();
    }

    public static List<Answer> getStoredAnswersOrError(Context context) throws AnswersNotSetException {
        String defValue = "Empty";
        SharedPreferences preferences = context.getSharedPreferences(
                dataSP, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = preferences.getString(answerList, "Empty");
        List answers = gson.fromJson(json, List.class);

        if (answers.equals(defValue)) {
            throw new AnswersNotSetException();
        } else {
            return answers;
        }
    }

    public static void writeAnswers(Context context, List<Answer> answers) {
        Gson gson = new Gson();
        context.getSharedPreferences(dataSP, Context.MODE_PRIVATE)
                .edit()
                .putString(answerList, gson.toJson(answers))
                .apply();
    }
}
