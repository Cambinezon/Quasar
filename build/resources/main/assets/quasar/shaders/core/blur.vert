#version 150
in vec4 Position;
in vec2 TexCoord;
out vec2 texCoords;

void main() {
    gl_Position = Position;
    texCoords = TexCoord;
}