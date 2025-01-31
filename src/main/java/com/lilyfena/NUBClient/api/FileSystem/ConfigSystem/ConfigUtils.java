package com.lilyfena.NUBClient.api.FileSystem.ConfigSystem;

import com.ferra13671.TextureUtils.PathMode;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lilyfena.NUBClient.api.FileSystem.FileSystem;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ConfigUtils {

    public static void registerFiles(String name, String path) throws IOException {
        Path p = Paths.get("NUBClient/" + path + "/" + name + ".json");
        if (Files.exists(p)) {
            File file = new File("NUBClient/" + path + "/" + name + ".json");
            file.delete();
        }

        Files.createFile(p);
    }

    public static OutputStreamWriter createWriter(Path path) throws IOException {
        return new OutputStreamWriter(Files.newOutputStream(path), StandardCharsets.UTF_8);
    }

    public static String jsonToString(JsonObject object) {
        return ConfigSystem.gson.toJson(JsonParser.parseString(object.toString()));
    }

    public static InputStream newInputStream(String path, com.ferra13671.TextureUtils.PathMode pathMode) {
        if (pathMode == PathMode.INSIDEJAR) {
            return ConfigUtils.class.getClassLoader().getResourceAsStream(path);
        } else {
            try {
                return Files.newInputStream(Paths.get(path));
            } catch (IOException e) {
                return null;
            }
        }
    }

    public static void loadFromTxt(String fileName, String path, RunnableWithObject<String> runnable) throws IOException {
        Path savePath = Paths.get("NUBClient/" + path + "/" + fileName + ".txt");

        if (!Files.exists(savePath)) {
            FileSystem.registerFile(fileName, path, "txt");
            return;
        }

        BufferedReader reader = Files.newBufferedReader(savePath, StandardCharsets.UTF_8);
        String line = reader.readLine();
        while (line != null) {
            runnable.run(line);
            line = reader.readLine();
        }
        reader.close();
    }

    public static void saveInTxt(String fileName, String path, RunnableWithObject<BufferedWriter> runnable) throws IOException {
        Path savePath = Paths.get("NUBClient/" + path + "/" + fileName + ".txt");

        if (Files.exists(savePath)) {
            File file = savePath.toFile();
            file.delete();
            FileSystem.registerFile(fileName, path, "txt");
        }

        BufferedWriter writer = Files.newBufferedWriter(savePath, StandardCharsets.UTF_8);
        runnable.run(writer);
        writer.close();
    }

    public static void loadFromJson(String fileName, String path, RunnableWithObject<JsonObject> runnable) throws IOException {
        Path path1 = Paths.get("NUBClient/" + path + "/" + fileName + ".json");
        if (!Files.exists(path1)) {
            return;
        }

        InputStream inputStream = Files.newInputStream(path1);
        JsonObject jsonObject = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();

        runnable.run(jsonObject);

        inputStream.close();
    }

    public static void saveInJson(String fileName, String path, RunnableWithObject<JsonObject> runnable) throws IOException {
        registerFiles(fileName, path.replace("NUBClient/", ""));
        OutputStreamWriter fileOutputStreamWriter = createWriter(Paths.get("NUBClient/" + path + "/" + fileName + ".json"));

        JsonObject jsonObject = new JsonObject();

        runnable.run(jsonObject);

        String jsonString = jsonToString(jsonObject);
        fileOutputStreamWriter.write(jsonString);
        fileOutputStreamWriter.close();
    }
}
