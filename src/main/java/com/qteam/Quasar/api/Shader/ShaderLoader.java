package com.qteam.Quasar.api.Shader;

import com.qteam.Quasar.impl.Mc;
import net.minecraft.util.Identifier;
import org.lwjgl.opengl.GL20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ShaderLoader implements Mc {
    private final Identifier vertexShaderId;
    private final Identifier fragmentShaderId;
    private int programId = -1;

    public ShaderLoader(Identifier vertexShaderId, Identifier fragmentShaderId) {
        this.vertexShaderId = vertexShaderId;
        this.fragmentShaderId = fragmentShaderId;
    }

    /**
     * Initializes the shader program.
     */
    public void init() {
        int vertexShader = loadShader(vertexShaderId, GL20.GL_VERTEX_SHADER);
        int fragmentShader = loadShader(fragmentShaderId, GL20.GL_FRAGMENT_SHADER);

        programId = GL20.glCreateProgram();
        GL20.glAttachShader(programId, vertexShader);
        GL20.glAttachShader(programId, fragmentShader);
        GL20.glLinkProgram(programId);

        int linkStatus = GL20.glGetProgrami(programId, GL20.GL_LINK_STATUS);
        if (linkStatus == GL20.GL_FALSE) {
            String log = GL20.glGetProgramInfoLog(programId);
            throw new RuntimeException("Shader program linking failed: " + log);
        }

        // Clean up shaders after linking
        GL20.glDeleteShader(vertexShader);
        GL20.glDeleteShader(fragmentShader);
    }

    /**
     * Loads a shader from the resource location.
     *
     * @param shaderId   The identifier for the shader.
     * @param shaderType The type of shader (e.g., GL20.GL_VERTEX_SHADER).
     * @return The OpenGL shader ID.
     */
    private int loadShader(Identifier shaderId, int shaderType) {
        String shaderSource = readShaderSource(shaderId);

        int shader = GL20.glCreateShader(shaderType);
        GL20.glShaderSource(shader, shaderSource);
        GL20.glCompileShader(shader);

        int compileStatus = GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS);
        if (compileStatus == GL20.GL_FALSE) {
            String log = GL20.glGetShaderInfoLog(shader);
            throw new RuntimeException("Failed to compile shader " + shaderId + ": " + log);
        }

        return shader;
    }

    /**
     * Reads the shader source code from a file.
     */
    private String readShaderSource(Identifier shaderId) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                mc.getResourceManager().getResource(shaderId).get().getInputStream(),
                StandardCharsets.UTF_8
        ))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read shader source: " + shaderId, e);
        }
    }

    /**
     * Activates the shader program.
     */
    public void activate() {
        if (programId != -1) {
            GL20.glUseProgram(programId);
        }
    }

    /**
     * Deactivates the shader program.
     */
    public void deactivate() {
        GL20.glUseProgram(0);
    }

    /**
     * Cleans up the shader program.
     */
    public void close() {
        if (programId != -1) {
            GL20.glDeleteProgram(programId);
            programId = -1;
        }
    }

    public int getProgramId() {
        return programId;
    }
}
