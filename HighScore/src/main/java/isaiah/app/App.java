package isaiah.app;

import com.google.gson.Gson;
import entity.Score;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public class App {

    static List<Score> scoreList = new ArrayList();
    static Gson gson = new Gson();

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.get("/scores", context -> {
            String scoreJson = gson.toJson(scoreList);
            context.result(scoreJson);
        });

        app.post("/scores", context -> {
            String json = context.body();
            Score score = gson.fromJson(json, Score.class);
            if (score.getScore() < 0){
                context.status(400);
                context.result("Score cannot be negative");
            }
            scoreList.add(score);
            context.status(201);
            context.result("Score was added!!!");
        });

        app.start(5000);

    }
}

